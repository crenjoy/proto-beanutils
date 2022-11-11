
package com.crenjoy.proto.mapper.message.test;

import crenjoy.protobuf.Basic2TestMessage;
import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;

public class TestMessageBuilder {

  protected TestMessageBuilder() {

  }

  public static TestMessageList getListNull() {
    return TestMessageList.newBuilder().build();
  }

  public static TestMessageList getListFull() {
    TestMessageList.Builder bean = TestMessageList.newBuilder();
    bean.addTestBasicList(Basic2TestMessage.newBuilder());

    bean.addTestBasicList(Basic2TestMessageBuilder.getMax());

    bean.addTestBasicList(Basic2TestMessageBuilder.getMin());

    bean.addTestBasicList(Basic2TestMessageBuilder.getEmpty());

    return bean.build();
  }

  public static TestMessageMap getMapNull() {
    return TestMessageMap.newBuilder().build();
  }

  public static TestMessageMap getMapFull() {
    TestMessageMap.Builder bean = TestMessageMap.newBuilder();

    bean.putTestBasicMap("Null", Basic2TestMessage.newBuilder().build());

    bean.putTestBasicMap("Max", Basic2TestMessageBuilder.getMax());

    bean.putTestBasicMap("Min", Basic2TestMessageBuilder.getMin());

    bean.putTestBasicMap("Zero", Basic2TestMessageBuilder.getEmpty());

    return bean.build();
  }
}
