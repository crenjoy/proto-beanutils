package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.bean.test.TestBeanList;
import com.crenjoy.proto.mapper.bean.test.TestBeanMap;

import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapListMapper extends BeanMapper {

  TestMapListMapper INSTANCE = Mappers.getMapper(TestMapListMapper.class);

  TestBeanMap toMap(TestMessageMap msgMap);

  TestBeanList toList(TestMessageList msgList);

  void updateMap(@MappingTarget TestBeanMap beanMap, TestMessageMap msgMap);

  void updateList(@MappingTarget TestBeanList beanList, TestMessageList msgList);
  
}
