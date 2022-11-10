
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.bean.test.ConvertTestBean;

import crenjoy.protobuf.ConvertTestMessage;
import crenjoy.protobuf.TestEnum;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConvertTestBeanMapper extends BeanMapper {

  ConvertTestBeanMapper INSTANCE = Mappers.getMapper(ConvertTestBeanMapper.class);

  ConvertTestBean toBean(ConvertTestMessage msg);

  void updateBean(@MappingTarget ConvertTestBean bean, ConvertTestMessage msg);

  default TestEnum toEnum(Object value) {
    TestEnum testEnum = ProtoConvertUtils.convert(value, TestEnum.class);
    return (testEnum == null) ? TestEnum.male : testEnum;
  }

}
