
package com.crenjoy.proto.mapper.bean.test;

/**
 * Basic1Test1Bean Builder.
 *
 * @author CGD
 *
 */
public class Basic2TestBeanBuilder {

  protected Basic2TestBeanBuilder() {

  }

  /**
   * Empty Bean.
   */
  public static Basic2TestBean getEmpty() {
    return new Basic2TestBean();
  }

  /**
   * Default Value.
   */
  public static Basic2TestBean getDefault() {
    Basic2TestBean msg = new Basic2TestBean();
    msg.setTestFloat(0.0f);
    msg.setTestInt32(0);
    msg.setTestBool(false);
    msg.setTestString("");
    return msg;
  }

  /**
   * Min Bean.
   */
  public static Basic2TestBean getMin() {
    Basic2TestBean msg = new Basic2TestBean();

    msg.setTestFloat(Float.MIN_VALUE);
    msg.setTestInt32(Integer.MIN_VALUE);
    msg.setTestBool(false);
    msg.setTestString("000000000000");
    return msg;
  }

  /**
   * Max Bean.
   */
  public static Basic2TestBean getMax() {
    Basic2TestBean msg = new Basic2TestBean();

    msg.setTestFloat(Float.MAX_VALUE);
    msg.setTestInt32(Integer.MAX_VALUE);
    msg.setTestBool(true);
    msg.setTestString("1234567890ABCDEF");
    return msg;
  }

}
