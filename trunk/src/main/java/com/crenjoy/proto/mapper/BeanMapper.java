
package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;

import java.util.List;

/**
 * target POJO Bean.
 *
 * @author CGD
 *
 */
//@Mapper(collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface BeanMapper {
  /**
   * ByteString To byte[].
   */
  default byte[] toByteArray(ByteString value) {
    return ProtoConvertUtils.convert(value, byte[].class);
  }

  /** ProtocolStringList is List String SubClass. */
  default List<String> toListString(ProtocolStringList value) {
    return (List<String>) value;
  }

}
