
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1TestBean;
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

  Basic1TestBean toBean1(Basic1TestMessage basicMsg);

  void updateBean1(@MappingTarget Basic1TestBean bean1, Basic1TestMessage basicMsg);

}
