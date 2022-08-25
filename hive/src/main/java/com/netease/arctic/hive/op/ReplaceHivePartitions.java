package com.netease.arctic.hive.op;

import com.netease.arctic.hive.HMSClient;
import com.netease.arctic.hive.exceptions.CannotAlterHiveLocationException;
import com.netease.arctic.hive.table.UnkeyedHiveTable;
import com.netease.arctic.hive.utils.HivePartitionUtil;
import com.netease.arctic.op.UpdatePartitionProperties;
import com.netease.arctic.table.TableProperties;
import com.netease.arctic.utils.FileUtil;
import com.netease.arctic.utils.TablePropertyUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.metastore.api.NoSuchObjectException;
import org.apache.hadoop.hive.metastore.api.Partition;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.iceberg.ContentFile;
import org.apache.iceberg.DataFile;
import org.apache.iceberg.ReplacePartitions;
import org.apache.iceberg.Snapshot;
import org.apache.iceberg.StructLike;
import org.apache.iceberg.Transaction;
import org.apache.iceberg.relocated.com.google.common.base.Joiner;
import org.apache.iceberg.relocated.com.google.common.collect.Lists;
import org.apache.iceberg.relocated.com.google.common.collect.Maps;
import org.apache.iceberg.types.Types;
import org.apache.thrift.TException;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReplaceHivePartitions implements ReplacePartitions {

  private final Transaction transaction;
  private final boolean insideTransaction;
  private final ReplacePartitions delegate;

  private final HMSClient hmsClient;
  private final HMSClient transactionalHMSClient;

  private final UnkeyedHiveTable table;
  private final List<DataFile> addFiles = Lists.newArrayList();
  private final String db;
  private final String tableName;
  private final Table hiveTable;

  private final Map<StructLike, Partition> rewritePartitions = Maps.newHashMap();
  private final Map<StructLike, Partition> newPartitions = Maps.newHashMap();
  private String unpartitionTableLocation;

  public ReplaceHivePartitions(
      Transaction transaction,
      boolean insideTransaction,
      UnkeyedHiveTable table,
      HMSClient client,
      HMSClient transactionalClient) {
    this.transaction = transaction;
    this.insideTransaction = insideTransaction;
    this.delegate = transaction.newReplacePartitions();
    this.hmsClient = client;
    this.transactionalHMSClient = transactionalClient;
    this.table = table;
    this.db = table.id().getDatabase();
    this.tableName = table.id().getTableName();
    try {
      this.hiveTable = client.run(c -> c.getTable(db, tableName));
    } catch (TException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public ReplacePartitions addFile(DataFile file) {
    delegate.addFile(file);
    String tableLocation = table.hiveLocation();
    String dataFileLocation = file.path().toString();
    if (dataFileLocation.toLowerCase().contains(tableLocation.toLowerCase())) {
      // only handle file in hive location
      this.addFiles.add(file);
    }
    return this;
  }

  @Override
  public ReplacePartitions validateAppendOnly() {
    delegate.validateAppendOnly();
    return this;
  }

  @Override
  public ReplacePartitions set(String property, String value) {
    delegate.set(property, value);
    return this;
  }

  @Override
  public ReplacePartitions deleteWith(Consumer<String> deleteFunc) {
    delegate.deleteWith(deleteFunc);
    return this;
  }

  @Override
  public ReplacePartitions stageOnly() {
    delegate.stageOnly();
    return this;
  }

  @Override
  public Snapshot apply() {
    return delegate.apply();
  }

  @Override
  public void commit() {
    if (!addFiles.isEmpty()) {
      if (table.spec().isUnpartitioned()) {
        generateUnpartitionTableLocation();
      } else {
        applyHivePartitions();
      }

      delegate.commit();
      setHiveLocations();
      if (!insideTransaction) {
        transaction.commitTransaction();
      }

      if (table.spec().isUnpartitioned()) {
        commitUnPartitionedTable();
      } else {
        commitPartitionedTable();
      }
    }
  }

  private void setHiveLocations() {
    UpdatePartitionProperties updatePartitionProperties = table.updatePartitionProperties(transaction);
    if (table.spec().isUnpartitioned() && unpartitionTableLocation != null) {
      updatePartitionProperties.set(
          TablePropertyUtil.EMPTY_STRUCT,
          TableProperties.PARTITION_PROPERTIES_KEY_HIVE_LOCATION, unpartitionTableLocation);
    } else {
      rewritePartitions.forEach((partitionData, partition) -> {
        updatePartitionProperties.set(partitionData, TableProperties.PARTITION_PROPERTIES_KEY_HIVE_LOCATION,
            partition.getSd().getLocation());
      });
      newPartitions.forEach((partitionData, partition) -> {
        updatePartitionProperties.set(partitionData, TableProperties.PARTITION_PROPERTIES_KEY_HIVE_LOCATION,
            partition.getSd().getLocation());
      });
    }
    updatePartitionProperties.commit();
  }

  @Override
  public Object updateEvent() {
    return delegate.updateEvent();
  }

  private void applyHivePartitions() {
    Types.StructType partitionSchema = table.spec().partitionType();

    // partitionValue -> partitionLocation.
    Map<String, String> partitionLocationMap = Maps.newHashMap();
    Map<String, List<DataFile>> partitionDataFileMap = Maps.newHashMap();
    Map<String, List<String>> partitionValueMap = Maps.newHashMap();

    for (DataFile d : addFiles) {
      List<String> partitionValues = HivePartitionUtil.partitionValuesAsList(d.partition(), partitionSchema);
      String value = Joiner.on("/").join(partitionValues);
      String location = FileUtil.getFileDir(d.path().toString());
      partitionLocationMap.put(value, location);
      if (!partitionDataFileMap.containsKey(value)) {
        partitionDataFileMap.put(value, Lists.newArrayList());
      }
      partitionDataFileMap.get(value).add(d);
      partitionValueMap.put(value, partitionValues);
    }
    partitionLocationMap.forEach((k, v) -> checkDataFileInSameLocation(v, partitionDataFileMap.get(k)));

    for (String val : partitionValueMap.keySet()) {
      List<String> values = partitionValueMap.get(val);
      String location = partitionLocationMap.get(val);
      List<DataFile> dataFiles = partitionDataFileMap.get(val);

      try {
        Partition partition = hmsClient.run(c -> c.getPartition(db, tableName, values));
        rewriteHivePartitions(partition, location, dataFiles);
        rewritePartitions.put(dataFiles.get(0).partition(), partition);
      } catch (NoSuchObjectException e) {
        Partition p = HivePartitionUtil.newPartition(hiveTable, values, location, dataFiles);
        newPartitions.put(dataFiles.get(0).partition(), p);
      } catch (TException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void commitUnPartitionedTable() {
    if (!addFiles.isEmpty()) {
      final String newDataLocation = FileUtil.getFileDir(addFiles.get(0).path().toString());
      try {
        transactionalHMSClient.run(c -> {
          Table tbl = c.getTable(db, tableName);
          tbl.getSd().setLocation(newDataLocation);
          c.alter_table(db, tableName, tbl);
          return 0;
        });
      } catch (TException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void commitPartitionedTable() {
    try {
      transactionalHMSClient.run(c -> {
        if (!rewritePartitions.isEmpty()) {
          c.alter_partitions(db, tableName, rewritePartitions.values().stream().collect(Collectors.toList()));
        }
        if (!newPartitions.isEmpty()) {
          c.add_partitions(newPartitions.values().stream().collect(Collectors.toList()));
        }
        return 0;
      });
    } catch (TException | InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  private void checkDataFileInSameLocation(String partitionLocation, List<DataFile> files) {
    Path partitionPath = new Path(partitionLocation);
    for (DataFile df : files) {
      String fileDir = FileUtil.getFileDir(df.path().toString());
      Path dirPath = new Path(fileDir);
      if (!partitionPath.equals(dirPath)) {
        throw new CannotAlterHiveLocationException(
            "can't create new hive location: " + partitionLocation + " for data file: " + df.path().toString() +
                " is not under partition location path"
        );
      }
    }
  }

  private void generateUnpartitionTableLocation() {
    unpartitionTableLocation = FileUtil.getFileDir(this.addFiles.get(0).path().toString());
  }

  private static void rewriteHivePartitions(Partition partition, String location, List<DataFile> dataFiles) {
    partition.getSd().setLocation(location);
    int lastAccessTime = (int) (System.currentTimeMillis() / 1000);
    partition.setLastAccessTime(lastAccessTime);
    int files = dataFiles.size();
    long totalSize = dataFiles.stream().map(ContentFile::fileSizeInBytes).reduce(0L, Long::sum);
    partition.putToParameters("transient_lastDdlTime", lastAccessTime + "");
    partition.putToParameters("totalSize", totalSize + "");
    partition.putToParameters("numFiles", files + "");
  }
}