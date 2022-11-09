
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.TestBeanList;
import com.crenjoy.proto.mapper.bean.test.TestBeanMap;
import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProtoTestMapListMapper extends ProtoMapper {

  ProtoTestMapListMapper INSTANCE = Mappers.getMapper(ProtoTestMapListMapper.class);

  TestMessageMap toMap(TestBeanMap beanMap);

  TestMessageList toList(TestBeanList beanList);

  default TestMessageMap updateMap(@MappingTarget TestMessageMap msgMap, TestBeanMap beanMap) {
    TestMessageMap.Builder builder = msgMap.toBuilder();
    updateMap(builder, beanMap);
    return builder.build();
  }

  void updateMap(@MappingTarget TestMessageMap.Builder msgMap, TestBeanMap beanMap);

  default TestMessageList updateList(@MappingTarget TestMessageList msgList,
      TestBeanList beanList) {
    TestMessageList.Builder builder = msgList.toBuilder();
    updateList(builder, beanList);
    return builder.build();
  }

  void updateList(@MappingTarget TestMessageList.Builder msgList, TestBeanList beanList);

}
