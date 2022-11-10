
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.ProtoMapper;
import com.crenjoy.proto.mapper.bean.test.Basic2TestBean;
import com.crenjoy.proto.mapper.bean.test.NestedTestBean;
import com.crenjoy.proto.mapper.bean.test.TestBeanList;
import com.crenjoy.proto.mapper.bean.test.TestBeanMap;
import crenjoy.protobuf.Basic2TestMessage;
import crenjoy.protobuf.NestedTestMessage;
import crenjoy.protobuf.TestEnum;
import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NestedTestMessageMapper extends ProtoMapper {

  NestedTestMessageMapper INSTANCE = Mappers.getMapper(NestedTestMessageMapper.class);

  NestedTestMessage toMessage(NestedTestBean bean);

  default NestedTestMessage updateMessage(NestedTestMessage msg, NestedTestBean bean) {
    NestedTestMessage.Builder builder = msg.toBuilder();
    updateMessage(builder, bean);
    return builder.build();
  }

  void updateMessage(@MappingTarget NestedTestMessage.Builder builder, NestedTestBean bean);

  default TestEnum toEnum(Object value) {
    TestEnum testEnum = ProtoConvertUtils.convert(value, TestEnum.class);
    return (testEnum == null) ? TestEnum.male : testEnum;
  }

  default Basic2TestMessage toMessage(Basic2TestBean testBasicBean) {
    Basic2TestMessage.Builder msg = Basic2TestMessage.newBuilder();
    if (null != testBasicBean) {
      updateMessage1(msg, testBasicBean);
    }
    return msg.build();
  }

  void updateMessage1(@MappingTarget Basic2TestMessage.Builder msg, Basic2TestBean testBasicBean);

  default TestMessageMap toMap(TestBeanMap beanMap) {
    TestMessageMap.Builder msg = TestMessageMap.newBuilder();
    if (null != beanMap) {
      updateMap(msg, beanMap);
    }
    return msg.build();
  }

  void updateMap(@MappingTarget TestMessageMap.Builder msg, TestBeanMap beanList);

  default TestMessageList toList(TestBeanList beanList) {
    TestMessageList.Builder msg = TestMessageList.newBuilder();
    if (null != beanList) {
      updateList(msg, beanList);
    }
    return msg.build();
  }

  void updateList(@MappingTarget TestMessageList.Builder msg, TestBeanList beanList);

}
