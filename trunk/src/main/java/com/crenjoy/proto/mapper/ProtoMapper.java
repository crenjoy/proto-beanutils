
package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import org.mapstruct.Mapper;

/**
 * Target Proto Message Mapper. <br/>
 * 1、resolve,Null Bean Update Value Message To Default Message . <br/>
 * 2、No resolve,Map List NULL Value To Message Exception.<br/>
 * 3、No resolve,Map List Not Support Add Exception e.g:Collections.emptyMap()
 * Colletions.emptyList().<br/>
 *
 * @author CGD
 *
 */
@Mapper
public interface ProtoMapper {

  /**
   * byte[] to ByteString.
   */
  default ByteString fromByteArray(byte[] value) {
    return ProtoConvertUtils.convert(value, ByteString.class);
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
