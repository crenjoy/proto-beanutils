
package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.Timestamp;

import java.util.List;

/**
 * Target Proto Message Mapper. <br/>
 * 1、resolve,Null Bean Update Value Message To Default Message . <br/>
 * 2、No resolve,Map List NULL Value Update Message .<br/>
 * 3、resolve,TARGET_IMMUTABLE. Map List e.g:Collections.emptyMap()
 * Colletions.emptyList() Arrays.asList("a") remove Unsupported .<br/>
 *
 * @author CGD
 *
 */
public interface ProtoMapper {

  default Timestamp toProtoTimestamp(Object value) {
    return ProtoConvertUtils.convert(value, Timestamp.class);
  }
  
  default Duration toProtoDuration(Object value) {
    return ProtoConvertUtils.convert(value, Duration.class);
  }

  /**
   * byte[] to ByteString.
   */
  default ByteString toProtoByteArray(byte[] value) {
    return ProtoConvertUtils.convert(value, ByteString.class);
  }

  /** List String To ProtocolStringList. */
  default ProtocolStringList toProtoListString(List<String> value) {
    if (value == null || value.isEmpty()) {
      return new LazyStringArrayList();
    }
    ProtocolStringList protoList = new LazyStringArrayList();
    protoList.addAll(value);
    return protoList;
  }

  /**
   * Proto Integer Not Null,Default 0.
   */
  default Integer nullToProto(Integer value) {
    return (null == value) ? Integer.valueOf(0) : value;
  }

  /**
   * Proto Long Not Null,Default 0.
   */
  default Long nullToProto(Long value) {
    return (null == value) ? Long.valueOf(0) : value;
  }

  /**
   * Proto String Not Null,Default Empty.
   */
  default String nullToProto(String value) {
    return (null == value) ? "" : value;
  }

  default String toProtoString(Object value) {
    String str = ProtoConvertUtils.convert(value);
    return (null == str) ? "" : str;
  }

  /**
   * Proto Float Not Null,Default 0.0.
   */
  default Float nullToProto(Float value) {
    return (null == value) ? Float.valueOf(0f) : value;
  }

  /**
   * Proto Double Not Null,Default 0.0.
   */
  default Double nullToProto(Double value) {
    return (null == value) ? Double.valueOf(0d) : value;
  }

  /**
   * Proto Double Not Null,Default 0.0.
   */
  default Boolean nullToProto(Boolean value) {
    return (null == value) ? Boolean.FALSE : value;
  }

}
