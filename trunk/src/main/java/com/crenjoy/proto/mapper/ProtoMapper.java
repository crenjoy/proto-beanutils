package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;

import org.mapstruct.Mapper;

/**
 * Proto Message and Bean Mapper.
 * 
 * @author CGD
 *
 */
@Mapper
public interface ProtoMapper {

  /**
   * ByteString To byte[].
   */
  default byte[] toByteArray(ByteString value) {
    return ProtoConvertUtils.convert(value, byte[].class);
  }

  /**
   * byte[] to ByteString.
   */
  default ByteString fromByteArray(byte[] value) {
    return ProtoConvertUtils.convert(value, ByteString.class);
  }

  /**
   * Proto String Not Null,Default Empty.
   */
  default String nullToEmpty(String value) {
    return (null == value) ? "" : value;
  }

}
