
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.ConvertTestBean;
import com.crenjoy.proto.mapper.bean.test.ConvertTestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.ConvertTestMessageBuilder;

import crenjoy.protobuf.ConvertTestMessage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Convert Bean Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConvertTestBeanMapperTest {

  // Empty.
  @Test
  @Order(1)
  public void testEmpty() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getEmpty();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(2)
  public void testMin() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMin();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMin());
  }

  // Max.
  @Test
  @Order(3)
  public void testMax() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMax();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMax());
  }

  // Empty.
  @Test
  @Order(4)
  public void testUpdateEmpty() {
    ConvertTestBean expected = ConvertTestBeanBuilder.getMax();
    ConvertTestMessage actual = ConvertTestMessageBuilder.getEmpty();
    ConvertTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getEmpty());
  }

  // Empty.
  @Test
  @Order(5)
  public void testUpdateEmpty2() {
    ConvertTestBean expected = ConvertTestBeanBuilder.getMin();
    ConvertTestMessage actual = ConvertTestMessageBuilder.getEmpty();
    ConvertTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(6)
  public void testUpdateMin() {
    ConvertTestBean expected = ConvertTestBeanBuilder.getMax();
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMin();
    ConvertTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMin());
  }

  // Max.
  @Test
  @Order(7)
  public void testUpdateMax() {
    ConvertTestBean expected = ConvertTestBeanBuilder.getMin();
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMax();
    ConvertTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMax());
  }

}
