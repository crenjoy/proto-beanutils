
package com.crenjoy.proto.mapper.message.test;

import crenjoy.protobuf.Basic2TestMessage;

public class Basic2TestMessageBuilder {
  
  public static Basic2TestMessage getEmpty() {
    Basic2TestMessage.Builder bt2 = Basic2TestMessage.newBuilder();
    bt2.setTestBool(false);
    bt2.setTestFloat(0f);
    bt2.setTestInt32(0);
    bt2.setTestString("");
    return bt2.build();
  }

  public static Basic2TestMessage getMax() {
    Basic2TestMessage.Builder bt = Basic2TestMessage.newBuilder();
    bt.setTestBool(true);
    bt.setTestFloat(Float.MAX_VALUE);
    bt.setTestInt32(Integer.MAX_VALUE);
    bt.setTestString("1234567890ABCDEF");
    return bt.build();
  }

  public static Basic2TestMessage getMin() {
    Basic2TestMessage.Builder bt1 = Basic2TestMessage.newBuilder();
    bt1.setTestBool(false);
    bt1.setTestFloat(Float.MIN_VALUE);
    bt1.setTestInt32(Integer.MIN_VALUE);
    bt1.setTestString("000000000000");
    return bt1.build();
  }
  
}
