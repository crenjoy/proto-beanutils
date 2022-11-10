
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.ConvertTestBean;
import crenjoy.protobuf.ConvertTestMessage;
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
public interface ConvertTestMessageMapper extends ProtoMapper {

  ConvertTestMessageMapper INSTANCE = Mappers.getMapper(ConvertTestMessageMapper.class);

  ConvertTestMessage toMessage(ConvertTestBean bean);

  default ConvertTestMessage updateMessage(ConvertTestMessage msg, ConvertTestBean bean) {
    ConvertTestMessage.Builder builder = msg.toBuilder();
    updateMessage(builder, bean);
    return builder.build();
  }

  void updateMessage(@MappingTarget ConvertTestMessage.Builder builder, ConvertTestBean bean);
  
  
  default TestEnum toEnum(Object value) {
    TestEnum testEnum = ProtoConvertUtils.convert(value, TestEnum.class);
    return (testEnum == null) ? TestEnum.male : testEnum;
  }
  
}
