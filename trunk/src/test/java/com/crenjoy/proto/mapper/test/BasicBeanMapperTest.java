package com.crenjoy.proto.mapper.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test1BeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.lang.reflect.InvocationTargetException;
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
  public void testToBean1() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage actual = Basic1TestMessage.newBuilder().build();
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    assertEquals(expected, Basic1Test1BeanBuilder.getDefaultValue());
  }
  
  /**
   * Min --> Min.
   */
  @Test
  @Order(2)
  public void testToBean1Min() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMin();
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    assertEquals(expected, Basic1Test1BeanBuilder.getMin());
  }
  
  /**
   * Max --> Max.
   */
  @Test
  @Order(3)
  public void testToBean1Max() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMax();
    Basic1Test1Bean expected = BasicBeanMapper.INSTANCE.toBean1(actual);
    assertEquals(expected, Basic1Test1BeanBuilder.getMax());
  }
  


}
