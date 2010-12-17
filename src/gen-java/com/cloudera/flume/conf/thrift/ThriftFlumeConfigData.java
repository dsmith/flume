/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.cloudera.flume.conf.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class ThriftFlumeConfigData implements TBase<ThriftFlumeConfigData, ThriftFlumeConfigData._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("ThriftFlumeConfigData");

  private static final TField TIMESTAMP_FIELD_DESC = new TField("timestamp", TType.I64, (short)1);
  private static final TField SOURCE_CONFIG_FIELD_DESC = new TField("sourceConfig", TType.STRING, (short)2);
  private static final TField SINK_CONFIG_FIELD_DESC = new TField("sinkConfig", TType.STRING, (short)3);
  private static final TField SOURCE_VERSION_FIELD_DESC = new TField("sourceVersion", TType.I64, (short)4);
  private static final TField SINK_VERSION_FIELD_DESC = new TField("sinkVersion", TType.I64, (short)5);
  private static final TField FLOW_ID_FIELD_DESC = new TField("flowID", TType.STRING, (short)6);

  public long timestamp;
  public String sourceConfig;
  public String sinkConfig;
  public long sourceVersion;
  public long sinkVersion;
  public String flowID;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    TIMESTAMP((short)1, "timestamp"),
    SOURCE_CONFIG((short)2, "sourceConfig"),
    SINK_CONFIG((short)3, "sinkConfig"),
    SOURCE_VERSION((short)4, "sourceVersion"),
    SINK_VERSION((short)5, "sinkVersion"),
    FLOW_ID((short)6, "flowID");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TIMESTAMP
          return TIMESTAMP;
        case 2: // SOURCE_CONFIG
          return SOURCE_CONFIG;
        case 3: // SINK_CONFIG
          return SINK_CONFIG;
        case 4: // SOURCE_VERSION
          return SOURCE_VERSION;
        case 5: // SINK_VERSION
          return SINK_VERSION;
        case 6: // FLOW_ID
          return FLOW_ID;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private static final int __SOURCEVERSION_ISSET_ID = 1;
  private static final int __SINKVERSION_ISSET_ID = 2;
  private BitSet __isset_bit_vector = new BitSet(3);

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TIMESTAMP, new FieldMetaData("timestamp", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64        , "Timestamp")));
    tmpMap.put(_Fields.SOURCE_CONFIG, new FieldMetaData("sourceConfig", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.SINK_CONFIG, new FieldMetaData("sinkConfig", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.SOURCE_VERSION, new FieldMetaData("sourceVersion", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.SINK_VERSION, new FieldMetaData("sinkVersion", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I64)));
    tmpMap.put(_Fields.FLOW_ID, new FieldMetaData("flowID", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(ThriftFlumeConfigData.class, metaDataMap);
  }

  public ThriftFlumeConfigData() {
  }

  public ThriftFlumeConfigData(
    long timestamp,
    String sourceConfig,
    String sinkConfig,
    long sourceVersion,
    long sinkVersion,
    String flowID)
  {
    this();
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    this.sourceConfig = sourceConfig;
    this.sinkConfig = sinkConfig;
    this.sourceVersion = sourceVersion;
    setSourceVersionIsSet(true);
    this.sinkVersion = sinkVersion;
    setSinkVersionIsSet(true);
    this.flowID = flowID;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftFlumeConfigData(ThriftFlumeConfigData other) {
    __isset_bit_vector.clear();
    __isset_bit_vector.or(other.__isset_bit_vector);
    this.timestamp = other.timestamp;
    if (other.isSetSourceConfig()) {
      this.sourceConfig = other.sourceConfig;
    }
    if (other.isSetSinkConfig()) {
      this.sinkConfig = other.sinkConfig;
    }
    this.sourceVersion = other.sourceVersion;
    this.sinkVersion = other.sinkVersion;
    if (other.isSetFlowID()) {
      this.flowID = other.flowID;
    }
  }

  public ThriftFlumeConfigData deepCopy() {
    return new ThriftFlumeConfigData(this);
  }

  @Deprecated
  public ThriftFlumeConfigData clone() {
    return new ThriftFlumeConfigData(this);
  }

  @Override
  public void clear() {
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.sourceConfig = null;
    this.sinkConfig = null;
    setSourceVersionIsSet(false);
    this.sourceVersion = 0;
    setSinkVersionIsSet(false);
    this.sinkVersion = 0;
    this.flowID = null;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public ThriftFlumeConfigData setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bit_vector.clear(__TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been asigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return __isset_bit_vector.get(__TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bit_vector.set(__TIMESTAMP_ISSET_ID, value);
  }

  public String getSourceConfig() {
    return this.sourceConfig;
  }

  public ThriftFlumeConfigData setSourceConfig(String sourceConfig) {
    this.sourceConfig = sourceConfig;
    return this;
  }

  public void unsetSourceConfig() {
    this.sourceConfig = null;
  }

  /** Returns true if field sourceConfig is set (has been asigned a value) and false otherwise */
  public boolean isSetSourceConfig() {
    return this.sourceConfig != null;
  }

  public void setSourceConfigIsSet(boolean value) {
    if (!value) {
      this.sourceConfig = null;
    }
  }

  public String getSinkConfig() {
    return this.sinkConfig;
  }

  public ThriftFlumeConfigData setSinkConfig(String sinkConfig) {
    this.sinkConfig = sinkConfig;
    return this;
  }

  public void unsetSinkConfig() {
    this.sinkConfig = null;
  }

  /** Returns true if field sinkConfig is set (has been asigned a value) and false otherwise */
  public boolean isSetSinkConfig() {
    return this.sinkConfig != null;
  }

  public void setSinkConfigIsSet(boolean value) {
    if (!value) {
      this.sinkConfig = null;
    }
  }

  public long getSourceVersion() {
    return this.sourceVersion;
  }

  public ThriftFlumeConfigData setSourceVersion(long sourceVersion) {
    this.sourceVersion = sourceVersion;
    setSourceVersionIsSet(true);
    return this;
  }

  public void unsetSourceVersion() {
    __isset_bit_vector.clear(__SOURCEVERSION_ISSET_ID);
  }

  /** Returns true if field sourceVersion is set (has been asigned a value) and false otherwise */
  public boolean isSetSourceVersion() {
    return __isset_bit_vector.get(__SOURCEVERSION_ISSET_ID);
  }

  public void setSourceVersionIsSet(boolean value) {
    __isset_bit_vector.set(__SOURCEVERSION_ISSET_ID, value);
  }

  public long getSinkVersion() {
    return this.sinkVersion;
  }

  public ThriftFlumeConfigData setSinkVersion(long sinkVersion) {
    this.sinkVersion = sinkVersion;
    setSinkVersionIsSet(true);
    return this;
  }

  public void unsetSinkVersion() {
    __isset_bit_vector.clear(__SINKVERSION_ISSET_ID);
  }

  /** Returns true if field sinkVersion is set (has been asigned a value) and false otherwise */
  public boolean isSetSinkVersion() {
    return __isset_bit_vector.get(__SINKVERSION_ISSET_ID);
  }

  public void setSinkVersionIsSet(boolean value) {
    __isset_bit_vector.set(__SINKVERSION_ISSET_ID, value);
  }

  public String getFlowID() {
    return this.flowID;
  }

  public ThriftFlumeConfigData setFlowID(String flowID) {
    this.flowID = flowID;
    return this;
  }

  public void unsetFlowID() {
    this.flowID = null;
  }

  /** Returns true if field flowID is set (has been asigned a value) and false otherwise */
  public boolean isSetFlowID() {
    return this.flowID != null;
  }

  public void setFlowIDIsSet(boolean value) {
    if (!value) {
      this.flowID = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case SOURCE_CONFIG:
      if (value == null) {
        unsetSourceConfig();
      } else {
        setSourceConfig((String)value);
      }
      break;

    case SINK_CONFIG:
      if (value == null) {
        unsetSinkConfig();
      } else {
        setSinkConfig((String)value);
      }
      break;

    case SOURCE_VERSION:
      if (value == null) {
        unsetSourceVersion();
      } else {
        setSourceVersion((Long)value);
      }
      break;

    case SINK_VERSION:
      if (value == null) {
        unsetSinkVersion();
      } else {
        setSinkVersion((Long)value);
      }
      break;

    case FLOW_ID:
      if (value == null) {
        unsetFlowID();
      } else {
        setFlowID((String)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TIMESTAMP:
      return new Long(getTimestamp());

    case SOURCE_CONFIG:
      return getSourceConfig();

    case SINK_CONFIG:
      return getSinkConfig();

    case SOURCE_VERSION:
      return new Long(getSourceVersion());

    case SINK_VERSION:
      return new Long(getSinkVersion());

    case FLOW_ID:
      return getFlowID();

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case TIMESTAMP:
      return isSetTimestamp();
    case SOURCE_CONFIG:
      return isSetSourceConfig();
    case SINK_CONFIG:
      return isSetSinkConfig();
    case SOURCE_VERSION:
      return isSetSourceVersion();
    case SINK_VERSION:
      return isSetSinkVersion();
    case FLOW_ID:
      return isSetFlowID();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftFlumeConfigData)
      return this.equals((ThriftFlumeConfigData)that);
    return false;
  }

  public boolean equals(ThriftFlumeConfigData that) {
    if (that == null)
      return false;

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_sourceConfig = true && this.isSetSourceConfig();
    boolean that_present_sourceConfig = true && that.isSetSourceConfig();
    if (this_present_sourceConfig || that_present_sourceConfig) {
      if (!(this_present_sourceConfig && that_present_sourceConfig))
        return false;
      if (!this.sourceConfig.equals(that.sourceConfig))
        return false;
    }

    boolean this_present_sinkConfig = true && this.isSetSinkConfig();
    boolean that_present_sinkConfig = true && that.isSetSinkConfig();
    if (this_present_sinkConfig || that_present_sinkConfig) {
      if (!(this_present_sinkConfig && that_present_sinkConfig))
        return false;
      if (!this.sinkConfig.equals(that.sinkConfig))
        return false;
    }

    boolean this_present_sourceVersion = true;
    boolean that_present_sourceVersion = true;
    if (this_present_sourceVersion || that_present_sourceVersion) {
      if (!(this_present_sourceVersion && that_present_sourceVersion))
        return false;
      if (this.sourceVersion != that.sourceVersion)
        return false;
    }

    boolean this_present_sinkVersion = true;
    boolean that_present_sinkVersion = true;
    if (this_present_sinkVersion || that_present_sinkVersion) {
      if (!(this_present_sinkVersion && that_present_sinkVersion))
        return false;
      if (this.sinkVersion != that.sinkVersion)
        return false;
    }

    boolean this_present_flowID = true && this.isSetFlowID();
    boolean that_present_flowID = true && that.isSetFlowID();
    if (this_present_flowID || that_present_flowID) {
      if (!(this_present_flowID && that_present_flowID))
        return false;
      if (!this.flowID.equals(that.flowID))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ThriftFlumeConfigData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ThriftFlumeConfigData typedOther = (ThriftFlumeConfigData)other;

    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(typedOther.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {      lastComparison = TBaseHelper.compareTo(this.timestamp, typedOther.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSourceConfig()).compareTo(typedOther.isSetSourceConfig());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceConfig()) {      lastComparison = TBaseHelper.compareTo(this.sourceConfig, typedOther.sourceConfig);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSinkConfig()).compareTo(typedOther.isSetSinkConfig());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinkConfig()) {      lastComparison = TBaseHelper.compareTo(this.sinkConfig, typedOther.sinkConfig);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSourceVersion()).compareTo(typedOther.isSetSourceVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSourceVersion()) {      lastComparison = TBaseHelper.compareTo(this.sourceVersion, typedOther.sourceVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSinkVersion()).compareTo(typedOther.isSetSinkVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSinkVersion()) {      lastComparison = TBaseHelper.compareTo(this.sinkVersion, typedOther.sinkVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFlowID()).compareTo(typedOther.isSetFlowID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFlowID()) {      lastComparison = TBaseHelper.compareTo(this.flowID, typedOther.flowID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // TIMESTAMP
          if (field.type == TType.I64) {
            this.timestamp = iprot.readI64();
            setTimestampIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SOURCE_CONFIG
          if (field.type == TType.STRING) {
            this.sourceConfig = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // SINK_CONFIG
          if (field.type == TType.STRING) {
            this.sinkConfig = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // SOURCE_VERSION
          if (field.type == TType.I64) {
            this.sourceVersion = iprot.readI64();
            setSourceVersionIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // SINK_VERSION
          if (field.type == TType.I64) {
            this.sinkVersion = iprot.readI64();
            setSinkVersionIsSet(true);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // FLOW_ID
          if (field.type == TType.STRING) {
            this.flowID = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
    oprot.writeI64(this.timestamp);
    oprot.writeFieldEnd();
    if (this.sourceConfig != null) {
      oprot.writeFieldBegin(SOURCE_CONFIG_FIELD_DESC);
      oprot.writeString(this.sourceConfig);
      oprot.writeFieldEnd();
    }
    if (this.sinkConfig != null) {
      oprot.writeFieldBegin(SINK_CONFIG_FIELD_DESC);
      oprot.writeString(this.sinkConfig);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(SOURCE_VERSION_FIELD_DESC);
    oprot.writeI64(this.sourceVersion);
    oprot.writeFieldEnd();
    oprot.writeFieldBegin(SINK_VERSION_FIELD_DESC);
    oprot.writeI64(this.sinkVersion);
    oprot.writeFieldEnd();
    if (this.flowID != null) {
      oprot.writeFieldBegin(FLOW_ID_FIELD_DESC);
      oprot.writeString(this.flowID);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ThriftFlumeConfigData(");
    boolean first = true;

    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceConfig:");
    if (this.sourceConfig == null) {
      sb.append("null");
    } else {
      sb.append(this.sourceConfig);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sinkConfig:");
    if (this.sinkConfig == null) {
      sb.append("null");
    } else {
      sb.append(this.sinkConfig);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("sourceVersion:");
    sb.append(this.sourceVersion);
    first = false;
    if (!first) sb.append(", ");
    sb.append("sinkVersion:");
    sb.append(this.sinkVersion);
    first = false;
    if (!first) sb.append(", ");
    sb.append("flowID:");
    if (this.flowID == null) {
      sb.append("null");
    } else {
      sb.append(this.flowID);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

