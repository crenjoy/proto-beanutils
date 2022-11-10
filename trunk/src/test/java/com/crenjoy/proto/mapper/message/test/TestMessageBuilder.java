
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
    
    
    Basic2TestMessage.Builder bt=Basic2TestMessage.newBuilder();
    bt.setTestBool(true);
    bt.setTestFloat(Float.MAX_VALUE);
    bt.setTestInt32(Integer.MAX_VALUE);
    bt.setTestString("");
    bean.addTestBasicList(bt);
   
    Basic2TestMessage.Builder bt1=Basic2TestMessage.newBuilder();
    bt1.setTestBool(false);
    bt1.setTestFloat(Float.MIN_VALUE);
    bt1.setTestInt32(Integer.MIN_VALUE);
    bt1.setTestString("");
    bean.addTestBasicList(bt1);
    
    Basic2TestMessage.Builder bt2=Basic2TestMessage.newBuilder();
    bt2.setTestBool(true);
    bt2.setTestFloat(0f);
    bt2.setTestInt32(0);
    bt2.setTestString("123");
    bean.addTestBasicList(bt2);

    return bean.build();
  }

  public static TestMessageMap getMapNull() {
    return TestMessageMap.newBuilder().build();
  }

  public static TestMessageMap getMapFull() {
    TestMessageMap.Builder bean = TestMessageMap.newBuilder();

    bean.putTestBasicMap("Null", Basic2TestMessage.newBuilder().build());
    
    Basic2TestMessage.Builder bt = Basic2TestMessage.newBuilder();
    bt.setTestBool(true);
    bt.setTestFloat(Float.MAX_VALUE);
    bt.setTestInt32(Integer.MAX_VALUE);
    bt.setTestString("");
    bean.putTestBasicMap("Max", bt.build());
    
    Basic2TestMessage.Builder bt1 = Basic2TestMessage.newBuilder();
    bt1.setTestBool(false);
    bt1.setTestFloat(Float.MIN_VALUE);
    bt1.setTestInt32(Integer.MIN_VALUE);
    bt1.setTestString("");
    bean.putTestBasicMap("Min", bt1.build());
    
    Basic2TestMessage.Builder bt2 = Basic2TestMessage.newBuilder();
    bt2.setTestBool(true);
    bt2.setTestFloat(0f);
    bt2.setTestInt32(0);
    bt2.setTestString("123");
    bean.putTestBasicMap("Zero", bt2.build());
   
    return bean.build();
  }
}
