
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.bean.test.GoogleTestBean;
import crenjoy.protobuf.GoogleTestMessage;
import crenjoy.protobuf.TestEnum;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoogleTestBeanMapper extends BeanMapper {

  GoogleTestBeanMapper INSTANCE = Mappers.getMapper(GoogleTestBeanMapper.class);

  GoogleTestBean toBean(GoogleTestMessage msg);

  void updateBean(@MappingTarget GoogleTestBean bean, GoogleTestMessage msg);

  default TestEnum toEnum(Object value) {
    return ProtoConvertUtils.convert(value, TestEnum.class);
  }

}
