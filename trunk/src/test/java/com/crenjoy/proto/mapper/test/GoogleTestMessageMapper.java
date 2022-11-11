
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.GoogleTestBean;

import crenjoy.protobuf.GoogleTestMessage;
import crenjoy.protobuf.TestEnum;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * 
 * @author CGD
 *
 */
@Mapper
public interface GoogleTestMessageMapper extends ProtoMapper {

  GoogleTestMessageMapper INSTANCE = Mappers.getMapper(GoogleTestMessageMapper.class);

  GoogleTestMessage toMessage(GoogleTestBean bean);

  default GoogleTestMessage updateMessage(GoogleTestMessage msg, GoogleTestBean bean) {
    GoogleTestMessage.Builder builder = msg.toBuilder();
    updateMessage(builder, bean);
    return builder.build();
  }

  void updateMessage(@MappingTarget GoogleTestMessage.Builder builder, GoogleTestBean bean);
  
  
  default TestEnum toEnum(Object value) {
    TestEnum testEnum = ProtoConvertUtils.convert(value, TestEnum.class);
    return (testEnum == null) ? TestEnum.male : testEnum;
  }
  
}
