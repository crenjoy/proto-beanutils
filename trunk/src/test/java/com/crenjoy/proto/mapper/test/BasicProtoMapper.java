
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

  /**
   * Bean Update Proto Message.
   */
  default Basic1TestMessage updateMsg1(Basic1TestMessage basicMsg, Basic1Test1Bean bean1) {
    Basic1TestMessage.Builder builder = basicMsg.toBuilder();
    updateMessage1(builder, bean1);
    return builder.build();
  }

  /**
   * Bean Update Proto Message.
   */
  default Basic1TestMessage updateMsg2(Basic1TestMessage basicMsg, Basic1Test2Bean bean2) {
    Basic1TestMessage.Builder builder = basicMsg.toBuilder();
    updateMessage2(builder, bean2);
    return builder.build();
  }

  void updateMessage1(@MappingTarget Basic1TestMessage.Builder basicMsg, Basic1Test1Bean bean1);

  void updateMessage2(@MappingTarget Basic1TestMessage.Builder basicMsg, Basic1Test2Bean bean2);

}
