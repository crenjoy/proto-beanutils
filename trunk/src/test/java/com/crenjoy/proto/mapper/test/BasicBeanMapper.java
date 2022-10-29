
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2Bean;
import com.crenjoy.proto.mapper.BeanMapper;
import crenjoy.protobuf.Basic1TestMessage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Basic Proto Message To Bean.
 *
 * @author CGD
 *
 */
@Mapper
public interface BasicBeanMapper extends BeanMapper {

  BasicBeanMapper INSTANCE = Mappers.getMapper(BasicBeanMapper.class);

  Basic1Test1Bean toBean1(Basic1TestMessage basicMsg);

  Basic1Test2Bean toBean2(Basic1TestMessage basicMsg);

  void updateBean1(@MappingTarget Basic1Test1Bean bean1, Basic1TestMessage basicMsg);

  void updateBean2(@MappingTarget Basic1Test2Bean bean2, Basic1TestMessage basicMsg);

}
