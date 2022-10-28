package com.crenjoy.commons.proto.beanutils2.message.test;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;
import com.crenjoy.commons.proto.beanutils2.bean.test.Basic1Test1Bean;
import com.crenjoy.commons.proto.beanutils2.bean.test.Basic1Test2Bean;
import com.google.protobuf.ByteString;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import crenjoy.protobuf.Basic1TestMessage;

@Mapper
public interface BasicMapper {

  BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);

  Basic1Test1Bean toBean1(Basic1TestMessage basicMsg);

  Basic1Test2Bean toBean2(Basic1TestMessage basicMsg);

  Basic1TestMessage toMessage1(Basic1Test1Bean basicBean);

  Basic1TestMessage toMessage2(Basic1Test2Bean basicBean);

  default byte[] map(ByteString value) {
    return (byte[]) ProtoConvertUtils.convert(value, byte[].class);
  }

  default ByteString toBytes(byte[] value) {
    return ProtoConvertUtils.convert(value, ByteString.class);
  }

  default String nullToEmpty(String value) {
    return (null == value) ? "" : value;
  }

}
