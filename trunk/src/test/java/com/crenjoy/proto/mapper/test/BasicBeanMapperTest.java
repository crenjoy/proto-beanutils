
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test1BeanBuilder;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2BeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.lang.reflect.InvocationTargetException;
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
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getDefault());
  }

  /**
   * Min --> Min.
   */
  @Test
  @Order(2)
  public void testToBean1Min() {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMin();
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMin());
  }

  /**
   * Max --> Max.
   */
  @Test
  @Order(3)
  public void testToBean1Max() {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMax();
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMax());
  }

  /**
   * Empty Update Value.
   */
  @Test
  @Order(4)
  public void testEmptyUpdateBean1() {
    // Empty Update Default.
    Basic1Test1Bean expected = Basic1Test1BeanBuilder.getEmpty();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getDefault());

    // Empty Update Min.
    expected = Basic1Test1BeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMin();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMin());

    // Empty Update Max.
    expected = Basic1Test1BeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMax();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMax());
  }

  /**
   * Default Update Value.
   */
  @Test
  @Order(5)
  public void testDefaultUpdateBean1() {
    // Default Update Default.
    Basic1Test1Bean expected = Basic1Test1BeanBuilder.getDefault();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getDefault());

    // Default Update Min.
    expected = Basic1Test1BeanBuilder.getDefault();
    actual = Basic1TestMsgBuilder.getMin();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMin());

    // Default Update Max.
    expected = Basic1Test1BeanBuilder.getDefault();
    actual = Basic1TestMsgBuilder.getMax();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getMax());
  }

  /**
   * Value Update Default.
   */
  @Test
  @Order(6)
  public void testValueUpdateBean1() {
    // Min Update Default.
    Basic1Test1Bean expected = Basic1Test1BeanBuilder.getMin();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getDefault());

    // Max Update Default.
    expected = Basic1Test1BeanBuilder.getMax();
    actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean1(expected, actual);
    Assertions.assertEquals(expected, Basic1Test1BeanBuilder.getDefault());
  }

  /**
   * Bean2 Default --> Default.
   */
  @Test
  @Order(7)
  public void testToBean2() {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    Basic1Test2Bean expected = BasicBeanMapper.INSTANCE.toBean2(actual);
    Assertions.assertEquals(expected, Basic1Test2BeanBuilder.getDefault());
  }

  /**
   * Bean2 Empty Update Value.
   */
  @Test
  @Order(4)
  public void testEmptyUpdateBean2() {
    // Empty Update Default.
    Basic1Test2Bean expected = Basic1Test2BeanBuilder.getEmpty();
    Basic1TestMessage actual = Basic1TestMsgBuilder.getDefault();
    BasicBeanMapper.INSTANCE.updateBean2(expected, actual);
    Assertions.assertEquals(expected, Basic1Test2BeanBuilder.getDefault());

    // Empty Update Min.
    expected = Basic1Test2BeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMin();
    BasicBeanMapper.INSTANCE.updateBean2(expected, actual);
    Assertions.assertEquals(expected, Basic1Test2BeanBuilder.getMin());

    // Empty Update Max.
    expected = Basic1Test2BeanBuilder.getEmpty();
    actual = Basic1TestMsgBuilder.getMax();
    BasicBeanMapper.INSTANCE.updateBean2(expected, actual);
    Assertions.assertEquals(expected, Basic1Test2BeanBuilder.getMax());
  }

}
