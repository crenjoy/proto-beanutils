
package com.crenjoy.proto.mapper.message.test;

import crenjoy.protobuf.NestedTestMessage;

public class NestedTestMessageBuilder {

  public static NestedTestMessage getEmpty() {
    return NestedTestMessage.newBuilder().build();
  }

  public static NestedTestMessage getMin() {
    NestedTestMessage.Builder builder = NestedTestMessage.newBuilder();
    builder.setTestString("1234567890ABCDEF");
    builder.setTestDouble(Double.MIN_VALUE);
    builder.setTestBool(false);
    builder.setTestBasicBean(Basic2TestMessageBuilder.getMin());
    builder.putAllTestStrMap(BeanMapListMsgBuilder.getMapDefault().getTestStrMapMap());
    builder.putAllTestBasicMap(TestMessageBuilder.getMapNull().getTestBasicMapMap());
    builder.addAllTestStrList(BeanMapListMsgBuilder.getListDefault().getTestStrListList());
    builder.addAllTestBasicList(TestMessageBuilder.getListNull().getTestBasicListList());
    builder.setTestMessageList(TestMessageBuilder.getListNull());
    builder.setTestMessageMap(TestMessageBuilder.getMapNull());
    return builder.build();
  }

  public static NestedTestMessage getMax() {
    NestedTestMessage.Builder builder = NestedTestMessage.newBuilder();
    builder.setTestString("0000000000");
    builder.setTestDouble(Double.MAX_VALUE);
    builder.setTestBool(true);
    builder.setTestBasicBean(Basic2TestMessageBuilder.getMax());
    builder.putAllTestStrMap(BeanMapListMsgBuilder.getMapFull().getTestStrMapMap());
    builder.putAllTestBasicMap(TestMessageBuilder.getMapFull().getTestBasicMapMap());
    builder.addAllTestStrList(BeanMapListMsgBuilder.getListFull().getTestStrListList());
    builder.addAllTestBasicList(TestMessageBuilder.getListFull().getTestBasicListList());
    builder.setTestMessageList(TestMessageBuilder.getListFull());
    builder.setTestMessageMap(TestMessageBuilder.getMapFull());
    return builder.build();
  }
 
}
