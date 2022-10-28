package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import org.mapstruct.Mapper;

/**
 * target POJO Bean.
 *
 * @author CGD
 *
 */
@Mapper
public interface BeanMapper {
  /**
   * ByteString To byte[].
   */
  default byte[] toByteArray(ByteString value) {
    return ProtoConvertUtils.convert(value, byte[].class);
  }

}
