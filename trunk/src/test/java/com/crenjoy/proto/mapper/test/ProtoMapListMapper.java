
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.BasicTestBeanList;
import com.crenjoy.proto.mapper.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.mapper.bean.test.BasicTestIntBeanList;

import crenjoy.protobuf.BasicTestIntMessageList;
import crenjoy.protobuf.BasicTestMessageList;
import crenjoy.protobuf.BasicTestMessageMap;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Bean List Map To Proto Message List Map.
 *
 * @author CGD
 *
 */
@Mapper
public interface ProtoMapListMapper extends ProtoMapper {

  ProtoMapListMapper INSTANCE = Mappers.getMapper(ProtoMapListMapper.class);

  BasicTestMessageMap toMap(BasicTestBeanMap beanMap);

  BasicTestMessageList toList(BasicTestBeanList beanList);

  /**
   * Map Update Proto Map Message.
   */
  default BasicTestMessageMap updateMap(BasicTestMessageMap msgMap, BasicTestBeanMap beanMap) {
    BasicTestMessageMap.Builder builder = msgMap.toBuilder();
    updateMap(builder, beanMap);
    return builder.build();
  }

  void updateMap(@MappingTarget BasicTestMessageMap.Builder msgMap, BasicTestBeanMap beanMap);

  /**
   * List Update Proto List Message.
   */
  default BasicTestMessageList updateList(BasicTestMessageList msgList,
      BasicTestBeanList beanList) {
    BasicTestMessageList.Builder builder = msgList.toBuilder();
    updateList(builder, beanList);
    return builder.build();
  }

  void updateList(@MappingTarget BasicTestMessageList.Builder msgList, BasicTestBeanList beanList);

  
  BasicTestIntMessageList toIntList(BasicTestIntBeanList beanList);

  /**
   * List Update Proto List Message.
   */
  default BasicTestIntMessageList updateIntList(BasicTestIntMessageList msgList,
      BasicTestIntBeanList beanList) {
    BasicTestIntMessageList.Builder builder = msgList.toBuilder();
    updateIntList(builder, beanList);
    return builder.build();
  }

  void updateIntList(@MappingTarget BasicTestIntMessageList.Builder msgList,
      BasicTestIntBeanList beanList);

}
