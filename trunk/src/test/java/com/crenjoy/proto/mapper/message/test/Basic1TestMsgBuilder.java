package com.crenjoy.proto.mapper.message.test;

import com.google.protobuf.ByteString;

import crenjoy.protobuf.Basic1TestMessage;

/**
 * Basic1TestMessage Builder.
 *
 * @author CGD
 *
 */
public class Basic1TestMsgBuilder {
  
  protected Basic1TestMsgBuilder() {

  }

  /**
   * Empty Message.
   */
  public static Basic1TestMessage getDefault() {    
    return Basic1TestMessage.newBuilder().build();
  }

  /**
   * Min Message.
   */
  public static Basic1TestMessage getMin() {
    Basic1TestMessage.Builder msg = Basic1TestMessage.newBuilder();
    msg.setTestDouble(Double.MIN_VALUE);
    msg.setTestFloat(Float.MIN_VALUE);
    msg.setTestInt32(Integer.MIN_VALUE);
    msg.setTestInt64(Long.MIN_VALUE);
    msg.setTestUint32(Integer.MIN_VALUE);
    msg.setTestUint64(Long.MIN_VALUE);
    msg.setTestSint32(Integer.MIN_VALUE);
    msg.setTestSint64(Long.MIN_VALUE);
    msg.setTestFixed32(Integer.MIN_VALUE);
    msg.setTestFixed64(Long.MIN_VALUE);
    msg.setTestSfixed32(Integer.MIN_VALUE);
    msg.setTestSfixed64(Long.MIN_VALUE);
    msg.setTestBool(true);
    msg.setTestString("00000000");
    msg.setTestBytes(ByteString.fromHex("00000000"));
    return msg.build();
  }

  /**
   * Max Message.
   */
  public static Basic1TestMessage getMax() {
    Basic1TestMessage.Builder msg = Basic1TestMessage.newBuilder();
    msg.setTestDouble(Double.MAX_VALUE);
    msg.setTestFloat(Float.MAX_VALUE);
    msg.setTestInt32(Integer.MAX_VALUE);
    msg.setTestInt64(Long.MAX_VALUE);
    msg.setTestUint32(Integer.MAX_VALUE);
    msg.setTestUint64(Long.MAX_VALUE);
    msg.setTestSint32(Integer.MAX_VALUE);
    msg.setTestSint64(Long.MAX_VALUE);
    msg.setTestFixed32(Integer.MAX_VALUE);
    msg.setTestFixed64(Long.MAX_VALUE);
    msg.setTestSfixed32(Integer.MAX_VALUE);
    msg.setTestSfixed64(Long.MAX_VALUE);
    msg.setTestBool(false);
    msg.setTestString("Hello World!");
    msg.setTestBytes(ByteString.fromHex("ABCDEF1234567890"));
    return msg.build();
  }

}
