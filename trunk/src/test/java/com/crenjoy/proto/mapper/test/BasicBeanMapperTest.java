
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.Basic1TestBean;
import com.crenjoy.proto.mapper.bean.test.Basic1TestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * BasicToBeanMapper Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicBeanMapperTest {

  /**
   * Default --> Default.
   */
  @Test
  @Order(1)
  public void testToBean1() {
    Basic1TestMessage actual = Basic1TestMessage.newBuilder().build();
    Basic1TestBean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getDefault());
  }

  /**
   * Min --> Min.
   */
  @Test
  @Order(2)
  public void testToBean1Min() {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMin();
    Basic1TestBean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMin());
  }

  /**
   * Max --> Max.
   */
  @Test
  @Order(3)
  public void testToBean1Max() {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMax();
    Basic1TestBean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMax());
  }

  /**
   * Empty Update Value.
   */
  @Test
  @Order(4)
  public void testEmptyUpdateBean1() {
    // Empty Update Default.
    Basic1TestBean expected = Basic1TestBeanBuilder.getEmpty();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getDefault());

    // Empty Update Min.
    expected = Basic1TestBeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMin();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMin());

    // Empty Update Max.
    expected = Basic1TestBeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMax();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMax());
  }

  /**
   * Default Update Value.
   */
  @Test
  @Order(5)
  public void testDefaultUpdateBean1() {
    // Default Update Default.
    Basic1TestBean expected = Basic1TestBeanBuilder.getDefault();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getDefault());

    // Default Update Min.
    expected = Basic1TestBeanBuilder.getDefault();
    actual = Basic1TestMsgBuilder.getMin();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMin());

    // Default Update Max.
    expected = Basic1TestBeanBuilder.getDefault();
    actual = Basic1TestMsgBuilder.getMax();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getMax());
  }

  /**
   * Value Update Default.
   */
  @Test
  @Order(6)
  public void testValueUpdateBean1() {
    // Min Update Default.
    Basic1TestBean expected = Basic1TestBeanBuilder.getMin();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getDefault());

    // Max Update Default.
    expected = Basic1TestBeanBuilder.getMax();
    actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1TestBeanBuilder.getDefault());
  }

}
