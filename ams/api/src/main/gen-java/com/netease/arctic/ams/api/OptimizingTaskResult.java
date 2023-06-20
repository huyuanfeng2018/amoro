/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.netease.arctic.ams.api;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2023-05-16")
public class OptimizingTaskResult implements org.apache.thrift.TBase<OptimizingTaskResult, OptimizingTaskResult._Fields>, java.io.Serializable, Cloneable, Comparable<OptimizingTaskResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("OptimizingTaskResult");

  private static final org.apache.thrift.protocol.TField TASK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("taskId", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField THREAD_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("threadId", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TASK_OUTPUT_FIELD_DESC = new org.apache.thrift.protocol.TField("taskOutput", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField ERROR_MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorMessage", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField SUMMARY_FIELD_DESC = new org.apache.thrift.protocol.TField("summary", org.apache.thrift.protocol.TType.MAP, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new OptimizingTaskResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new OptimizingTaskResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable OptimizingTaskId taskId; // required
  public int threadId; // required
  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer taskOutput; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String errorMessage; // optional
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> summary; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TASK_ID((short)1, "taskId"),
    THREAD_ID((short)2, "threadId"),
    TASK_OUTPUT((short)3, "taskOutput"),
    ERROR_MESSAGE((short)4, "errorMessage"),
    SUMMARY((short)5, "summary");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TASK_ID
          return TASK_ID;
        case 2: // THREAD_ID
          return THREAD_ID;
        case 3: // TASK_OUTPUT
          return TASK_OUTPUT;
        case 4: // ERROR_MESSAGE
          return ERROR_MESSAGE;
        case 5: // SUMMARY
          return SUMMARY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __THREADID_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TASK_OUTPUT,_Fields.ERROR_MESSAGE,_Fields.SUMMARY};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TASK_ID, new org.apache.thrift.meta_data.FieldMetaData("taskId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, OptimizingTaskId.class)));
    tmpMap.put(_Fields.THREAD_ID, new org.apache.thrift.meta_data.FieldMetaData("threadId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TASK_OUTPUT, new org.apache.thrift.meta_data.FieldMetaData("taskOutput", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.ERROR_MESSAGE, new org.apache.thrift.meta_data.FieldMetaData("errorMessage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.SUMMARY, new org.apache.thrift.meta_data.FieldMetaData("summary", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(OptimizingTaskResult.class, metaDataMap);
  }

  public OptimizingTaskResult() {
  }

  public OptimizingTaskResult(
    OptimizingTaskId taskId,
    int threadId)
  {
    this();
    this.taskId = taskId;
    this.threadId = threadId;
    setThreadIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public OptimizingTaskResult(OptimizingTaskResult other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTaskId()) {
      this.taskId = new OptimizingTaskId(other.taskId);
    }
    this.threadId = other.threadId;
    if (other.isSetTaskOutput()) {
      this.taskOutput = org.apache.thrift.TBaseHelper.copyBinary(other.taskOutput);
    }
    if (other.isSetErrorMessage()) {
      this.errorMessage = other.errorMessage;
    }
    if (other.isSetSummary()) {
      java.util.Map<java.lang.String,java.lang.String> __this__summary = new java.util.HashMap<java.lang.String,java.lang.String>(other.summary);
      this.summary = __this__summary;
    }
  }

  public OptimizingTaskResult deepCopy() {
    return new OptimizingTaskResult(this);
  }

  @Override
  public void clear() {
    this.taskId = null;
    setThreadIdIsSet(false);
    this.threadId = 0;
    this.taskOutput = null;
    this.errorMessage = null;
    this.summary = null;
  }

  @org.apache.thrift.annotation.Nullable
  public OptimizingTaskId getTaskId() {
    return this.taskId;
  }

  public OptimizingTaskResult setTaskId(@org.apache.thrift.annotation.Nullable OptimizingTaskId taskId) {
    this.taskId = taskId;
    return this;
  }

  public void unsetTaskId() {
    this.taskId = null;
  }

  /** Returns true if field taskId is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskId() {
    return this.taskId != null;
  }

  public void setTaskIdIsSet(boolean value) {
    if (!value) {
      this.taskId = null;
    }
  }

  public int getThreadId() {
    return this.threadId;
  }

  public OptimizingTaskResult setThreadId(int threadId) {
    this.threadId = threadId;
    setThreadIdIsSet(true);
    return this;
  }

  public void unsetThreadId() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __THREADID_ISSET_ID);
  }

  /** Returns true if field threadId is set (has been assigned a value) and false otherwise */
  public boolean isSetThreadId() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __THREADID_ISSET_ID);
  }

  public void setThreadIdIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __THREADID_ISSET_ID, value);
  }

  public byte[] getTaskOutput() {
    setTaskOutput(org.apache.thrift.TBaseHelper.rightSize(taskOutput));
    return taskOutput == null ? null : taskOutput.array();
  }

  public java.nio.ByteBuffer bufferForTaskOutput() {
    return org.apache.thrift.TBaseHelper.copyBinary(taskOutput);
  }

  public OptimizingTaskResult setTaskOutput(byte[] taskOutput) {
    this.taskOutput = taskOutput == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(taskOutput.clone());
    return this;
  }

  public OptimizingTaskResult setTaskOutput(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer taskOutput) {
    this.taskOutput = org.apache.thrift.TBaseHelper.copyBinary(taskOutput);
    return this;
  }

  public void unsetTaskOutput() {
    this.taskOutput = null;
  }

  /** Returns true if field taskOutput is set (has been assigned a value) and false otherwise */
  public boolean isSetTaskOutput() {
    return this.taskOutput != null;
  }

  public void setTaskOutputIsSet(boolean value) {
    if (!value) {
      this.taskOutput = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getErrorMessage() {
    return this.errorMessage;
  }

  public OptimizingTaskResult setErrorMessage(@org.apache.thrift.annotation.Nullable java.lang.String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  public void unsetErrorMessage() {
    this.errorMessage = null;
  }

  /** Returns true if field errorMessage is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorMessage() {
    return this.errorMessage != null;
  }

  public void setErrorMessageIsSet(boolean value) {
    if (!value) {
      this.errorMessage = null;
    }
  }

  public int getSummarySize() {
    return (this.summary == null) ? 0 : this.summary.size();
  }

  public void putToSummary(java.lang.String key, java.lang.String val) {
    if (this.summary == null) {
      this.summary = new java.util.HashMap<java.lang.String,java.lang.String>();
    }
    this.summary.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.String> getSummary() {
    return this.summary;
  }

  public OptimizingTaskResult setSummary(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.String> summary) {
    this.summary = summary;
    return this;
  }

  public void unsetSummary() {
    this.summary = null;
  }

  /** Returns true if field summary is set (has been assigned a value) and false otherwise */
  public boolean isSetSummary() {
    return this.summary != null;
  }

  public void setSummaryIsSet(boolean value) {
    if (!value) {
      this.summary = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TASK_ID:
      if (value == null) {
        unsetTaskId();
      } else {
        setTaskId((OptimizingTaskId)value);
      }
      break;

    case THREAD_ID:
      if (value == null) {
        unsetThreadId();
      } else {
        setThreadId((java.lang.Integer)value);
      }
      break;

    case TASK_OUTPUT:
      if (value == null) {
        unsetTaskOutput();
      } else {
        if (value instanceof byte[]) {
          setTaskOutput((byte[])value);
        } else {
          setTaskOutput((java.nio.ByteBuffer)value);
        }
      }
      break;

    case ERROR_MESSAGE:
      if (value == null) {
        unsetErrorMessage();
      } else {
        setErrorMessage((java.lang.String)value);
      }
      break;

    case SUMMARY:
      if (value == null) {
        unsetSummary();
      } else {
        setSummary((java.util.Map<java.lang.String,java.lang.String>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TASK_ID:
      return getTaskId();

    case THREAD_ID:
      return getThreadId();

    case TASK_OUTPUT:
      return getTaskOutput();

    case ERROR_MESSAGE:
      return getErrorMessage();

    case SUMMARY:
      return getSummary();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TASK_ID:
      return isSetTaskId();
    case THREAD_ID:
      return isSetThreadId();
    case TASK_OUTPUT:
      return isSetTaskOutput();
    case ERROR_MESSAGE:
      return isSetErrorMessage();
    case SUMMARY:
      return isSetSummary();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof OptimizingTaskResult)
      return this.equals((OptimizingTaskResult)that);
    return false;
  }

  public boolean equals(OptimizingTaskResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_taskId = true && this.isSetTaskId();
    boolean that_present_taskId = true && that.isSetTaskId();
    if (this_present_taskId || that_present_taskId) {
      if (!(this_present_taskId && that_present_taskId))
        return false;
      if (!this.taskId.equals(that.taskId))
        return false;
    }

    boolean this_present_threadId = true;
    boolean that_present_threadId = true;
    if (this_present_threadId || that_present_threadId) {
      if (!(this_present_threadId && that_present_threadId))
        return false;
      if (this.threadId != that.threadId)
        return false;
    }

    boolean this_present_taskOutput = true && this.isSetTaskOutput();
    boolean that_present_taskOutput = true && that.isSetTaskOutput();
    if (this_present_taskOutput || that_present_taskOutput) {
      if (!(this_present_taskOutput && that_present_taskOutput))
        return false;
      if (!this.taskOutput.equals(that.taskOutput))
        return false;
    }

    boolean this_present_errorMessage = true && this.isSetErrorMessage();
    boolean that_present_errorMessage = true && that.isSetErrorMessage();
    if (this_present_errorMessage || that_present_errorMessage) {
      if (!(this_present_errorMessage && that_present_errorMessage))
        return false;
      if (!this.errorMessage.equals(that.errorMessage))
        return false;
    }

    boolean this_present_summary = true && this.isSetSummary();
    boolean that_present_summary = true && that.isSetSummary();
    if (this_present_summary || that_present_summary) {
      if (!(this_present_summary && that_present_summary))
        return false;
      if (!this.summary.equals(that.summary))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTaskId()) ? 131071 : 524287);
    if (isSetTaskId())
      hashCode = hashCode * 8191 + taskId.hashCode();

    hashCode = hashCode * 8191 + threadId;

    hashCode = hashCode * 8191 + ((isSetTaskOutput()) ? 131071 : 524287);
    if (isSetTaskOutput())
      hashCode = hashCode * 8191 + taskOutput.hashCode();

    hashCode = hashCode * 8191 + ((isSetErrorMessage()) ? 131071 : 524287);
    if (isSetErrorMessage())
      hashCode = hashCode * 8191 + errorMessage.hashCode();

    hashCode = hashCode * 8191 + ((isSetSummary()) ? 131071 : 524287);
    if (isSetSummary())
      hashCode = hashCode * 8191 + summary.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(OptimizingTaskResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTaskId()).compareTo(other.isSetTaskId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskId, other.taskId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetThreadId()).compareTo(other.isSetThreadId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetThreadId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.threadId, other.threadId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTaskOutput()).compareTo(other.isSetTaskOutput());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTaskOutput()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.taskOutput, other.taskOutput);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetErrorMessage()).compareTo(other.isSetErrorMessage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorMessage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorMessage, other.errorMessage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSummary()).compareTo(other.isSetSummary());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSummary()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.summary, other.summary);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("OptimizingTaskResult(");
    boolean first = true;

    sb.append("taskId:");
    if (this.taskId == null) {
      sb.append("null");
    } else {
      sb.append(this.taskId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("threadId:");
    sb.append(this.threadId);
    first = false;
    if (isSetTaskOutput()) {
      if (!first) sb.append(", ");
      sb.append("taskOutput:");
      if (this.taskOutput == null) {
        sb.append("null");
      } else {
        org.apache.thrift.TBaseHelper.toString(this.taskOutput, sb);
      }
      first = false;
    }
    if (isSetErrorMessage()) {
      if (!first) sb.append(", ");
      sb.append("errorMessage:");
      if (this.errorMessage == null) {
        sb.append("null");
      } else {
        sb.append(this.errorMessage);
      }
      first = false;
    }
    if (isSetSummary()) {
      if (!first) sb.append(", ");
      sb.append("summary:");
      if (this.summary == null) {
        sb.append("null");
      } else {
        sb.append(this.summary);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (taskId != null) {
      taskId.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class OptimizingTaskResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public OptimizingTaskResultStandardScheme getScheme() {
      return new OptimizingTaskResultStandardScheme();
    }
  }

  private static class OptimizingTaskResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<OptimizingTaskResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, OptimizingTaskResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TASK_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.taskId = new OptimizingTaskId();
              struct.taskId.read(iprot);
              struct.setTaskIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // THREAD_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.threadId = iprot.readI32();
              struct.setThreadIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TASK_OUTPUT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.taskOutput = iprot.readBinary();
              struct.setTaskOutputIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ERROR_MESSAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.errorMessage = iprot.readString();
              struct.setErrorMessageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // SUMMARY
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                struct.summary = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map10.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key11;
                @org.apache.thrift.annotation.Nullable java.lang.String _val12;
                for (int _i13 = 0; _i13 < _map10.size; ++_i13)
                {
                  _key11 = iprot.readString();
                  _val12 = iprot.readString();
                  struct.summary.put(_key11, _val12);
                }
                iprot.readMapEnd();
              }
              struct.setSummaryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, OptimizingTaskResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.taskId != null) {
        oprot.writeFieldBegin(TASK_ID_FIELD_DESC);
        struct.taskId.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(THREAD_ID_FIELD_DESC);
      oprot.writeI32(struct.threadId);
      oprot.writeFieldEnd();
      if (struct.taskOutput != null) {
        if (struct.isSetTaskOutput()) {
          oprot.writeFieldBegin(TASK_OUTPUT_FIELD_DESC);
          oprot.writeBinary(struct.taskOutput);
          oprot.writeFieldEnd();
        }
      }
      if (struct.errorMessage != null) {
        if (struct.isSetErrorMessage()) {
          oprot.writeFieldBegin(ERROR_MESSAGE_FIELD_DESC);
          oprot.writeString(struct.errorMessage);
          oprot.writeFieldEnd();
        }
      }
      if (struct.summary != null) {
        if (struct.isSetSummary()) {
          oprot.writeFieldBegin(SUMMARY_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.summary.size()));
            for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter14 : struct.summary.entrySet())
            {
              oprot.writeString(_iter14.getKey());
              oprot.writeString(_iter14.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OptimizingTaskResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public OptimizingTaskResultTupleScheme getScheme() {
      return new OptimizingTaskResultTupleScheme();
    }
  }

  private static class OptimizingTaskResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<OptimizingTaskResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, OptimizingTaskResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTaskId()) {
        optionals.set(0);
      }
      if (struct.isSetThreadId()) {
        optionals.set(1);
      }
      if (struct.isSetTaskOutput()) {
        optionals.set(2);
      }
      if (struct.isSetErrorMessage()) {
        optionals.set(3);
      }
      if (struct.isSetSummary()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTaskId()) {
        struct.taskId.write(oprot);
      }
      if (struct.isSetThreadId()) {
        oprot.writeI32(struct.threadId);
      }
      if (struct.isSetTaskOutput()) {
        oprot.writeBinary(struct.taskOutput);
      }
      if (struct.isSetErrorMessage()) {
        oprot.writeString(struct.errorMessage);
      }
      if (struct.isSetSummary()) {
        {
          oprot.writeI32(struct.summary.size());
          for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter15 : struct.summary.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            oprot.writeString(_iter15.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, OptimizingTaskResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.taskId = new OptimizingTaskId();
        struct.taskId.read(iprot);
        struct.setTaskIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.threadId = iprot.readI32();
        struct.setThreadIdIsSet(true);
      }
      if (incoming.get(2)) {
        struct.taskOutput = iprot.readBinary();
        struct.setTaskOutputIsSet(true);
      }
      if (incoming.get(3)) {
        struct.errorMessage = iprot.readString();
        struct.setErrorMessageIsSet(true);
      }
      if (incoming.get(4)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.summary = new java.util.HashMap<java.lang.String,java.lang.String>(2*_map16.size);
          @org.apache.thrift.annotation.Nullable java.lang.String _key17;
          @org.apache.thrift.annotation.Nullable java.lang.String _val18;
          for (int _i19 = 0; _i19 < _map16.size; ++_i19)
          {
            _key17 = iprot.readString();
            _val18 = iprot.readString();
            struct.summary.put(_key17, _val18);
          }
        }
        struct.setSummaryIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
