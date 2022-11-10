package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.ConvertTestBean;

import crenjoy.protobuf.ConvertTestMessage;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConvertTestMessageMapper extends ProtoMapper {

  ConvertTestMessageMapper INSTANCE = Mappers.getMapper(ConvertTestMessageMapper.class);

  ConvertTestMessage toMessage(ConvertTestBean bean);

  void updateMessage(@MappingTarget ConvertTestMessage.Builder builder, ConvertTestBean bean);
  
}
