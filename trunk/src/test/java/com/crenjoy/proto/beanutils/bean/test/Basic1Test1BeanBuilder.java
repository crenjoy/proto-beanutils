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
   * Empty Bean.
   */
  public static Basic1Test1Bean getEmpty() {
    return new Basic1Test1Bean();
  }

  /**
   * Default Value.
   */
  public static Basic1Test1Bean getDefaultValue() {
    Basic1Test1Bean msg = new Basic1Test1Bean();
    msg.setTestDouble(0.0d);
    msg.setTestFloat(0.0f);
    msg.setTestInt32(0);
    msg.setTestInt64(0L);
    msg.setTestUint32(0);
    msg.setTestUint64(0L);
    msg.setTestSint32(0);
    msg.setTestSint64(0L);
    msg.setTestFixed32(0);
    msg.setTestFixed64(0L);
    msg.setTestSfixed32(0);
    msg.setTestSfixed64(0L);
    msg.setTestBool(false);
    msg.setTestString("");
    msg.setTestBytes(ByteString.EMPTY.toByteArray());
    return msg;
  }

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
    msg.setTestString("00000000");
    msg.setTestBytes(ByteString.fromHex("00000000").toByteArray());
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
