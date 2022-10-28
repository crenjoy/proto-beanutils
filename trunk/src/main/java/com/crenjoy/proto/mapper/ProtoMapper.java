package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import org.mapstruct.Mapper;

/**
 * Target Proto Message Mapper.
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
   * Proto String Not Null,Default Empty.
   */
  default String nullToEmpty(String value) {
    return (null == value) ? "" : value;
  }

}
