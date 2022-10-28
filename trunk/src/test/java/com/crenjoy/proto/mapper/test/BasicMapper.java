package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2Bean;
import com.crenjoy.proto.mapper.ProtoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import crenjoy.protobuf.Basic1TestMessage;

@Mapper
public interface BasicMapper extends ProtoMapper {

  BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);

  Basic1Test1Bean toBean1(Basic1TestMessage basicMsg);

  Basic1Test2Bean toBean2(Basic1TestMessage basicMsg);

  Basic1TestMessage toMessage1(Basic1Test1Bean basicBean);

  Basic1TestMessage toMessage2(Basic1Test2Bean basicBean);

}
