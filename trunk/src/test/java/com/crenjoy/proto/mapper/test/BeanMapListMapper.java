
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.BasicTestBeanList;
import com.crenjoy.proto.beanutils.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.mapper.BeanMapper;
import crenjoy.protobuf.BasicTestMessageList;
import crenjoy.protobuf.BasicTestMessageMap;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Proto Message List Map To Bean List Map.
 *
 * @author CGD
 *
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface BeanMapListMapper extends BeanMapper {

  BeanMapListMapper INSTANCE = Mappers.getMapper(BeanMapListMapper.class);

  BasicTestBeanMap toMap(BasicTestMessageMap msgMap);

  BasicTestBeanList toList(BasicTestMessageList msgList);

  void updateMap(@MappingTarget BasicTestBeanMap beanMap, BasicTestMessageMap msgMap);

  void updateList(@MappingTarget BasicTestBeanList beanList, BasicTestMessageList msgList);

}
