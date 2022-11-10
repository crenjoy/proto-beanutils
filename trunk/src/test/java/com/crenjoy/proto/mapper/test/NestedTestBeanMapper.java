package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.bean.test.NestedTestBean;
import crenjoy.protobuf.NestedTestMessage;
import crenjoy.protobuf.TestEnum;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NestedTestBeanMapper extends BeanMapper {

  NestedTestBeanMapper INSTANCE = Mappers.getMapper(NestedTestBeanMapper.class);

  NestedTestBean toBean(NestedTestMessage msg);

  void updateBean(@MappingTarget NestedTestBean bean, NestedTestMessage msg);

  default TestEnum toEnum(Object value) {
    return ProtoConvertUtils.convert(value, TestEnum.class);
  }
}
