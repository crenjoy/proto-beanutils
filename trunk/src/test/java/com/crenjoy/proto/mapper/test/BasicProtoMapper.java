
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2Bean;
import com.crenjoy.proto.mapper.ProtoMapper;
import crenjoy.protobuf.Basic1TestMessage;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * Bean To Proto Message.
 *
 * @author CGD
 *
 */
@Mapper
public interface BasicProtoMapper extends ProtoMapper {

  BasicProtoMapper INSTANCE = Mappers.getMapper(BasicProtoMapper.class);

  Basic1TestMessage toMessage1(Basic1Test1Bean basicBean);

  Basic1TestMessage toMessage2(Basic1Test2Bean basicBean);

  void updateMessage1(@MappingTarget Basic1TestMessage.Builder basicMsg, Basic1Test1Bean bean1);

  void updateMessage2(@MappingTarget Basic1TestMessage.Builder basicMsg, Basic1Test2Bean bean2);

}
