package com.crenjoy.proto.beanutils.bean.test;

import com.google.protobuf.ByteString;

/**
 * Basic1Test1Bean Builder.
 *
 * @author CGD
 *
 */
public class Basic1Test1BeanBuilder {

  /**
   * Min Bean.
   */
  public static Basic1Test1Bean getMin() {
    Basic1Test1Bean msg = new Basic1Test1Bean();
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
    msg.setTestString("Hello World!");
    msg.setTestBytes(ByteString.fromHex("ABCDEF1234567890").toByteArray());
    return msg;
  }

  /**
   * Max Bean.
   */
  public static Basic1Test1Bean getMax() {
    Basic1Test1Bean msg = new Basic1Test1Bean();
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
    msg.setTestBytes(ByteString.fromHex("ABCDEF1234567890").toByteArray());
    return msg;
  }

}
