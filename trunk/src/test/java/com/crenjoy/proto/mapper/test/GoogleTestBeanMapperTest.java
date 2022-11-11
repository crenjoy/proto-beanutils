
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.GoogleTestBean;
import com.crenjoy.proto.mapper.bean.test.GoogleTestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.GoogleTestMessageBuilder;
import crenjoy.protobuf.GoogleTestMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Google Bean Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTestBeanMapperTest {

  // Empty.
  @Test
  @Order(1)
  public void testEmpty() {
    GoogleTestMessage actual = GoogleTestMessageBuilder.getEmpty();
    GoogleTestBean expected = GoogleTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(2)
  public void testMin() {
    GoogleTestMessage actual = GoogleTestMessageBuilder.getMin();
    GoogleTestBean expected = GoogleTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getMin());
  }

  // Max.
  @Test
  @Order(3)
  public void testMax() {
    GoogleTestMessage actual = GoogleTestMessageBuilder.getMax();
    GoogleTestBean expected = GoogleTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getMax());
  }

  // Empty.
  @Test
  @Order(4)
  public void testUpdateEmpty() {
    GoogleTestBean expected = GoogleTestBeanBuilder.getMax();
    GoogleTestMessage actual = GoogleTestMessageBuilder.getEmpty();
    GoogleTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getEmpty());
  }

  // Empty.
  @Test
  @Order(5)
  public void testUpdateEmpty2() {
    GoogleTestBean expected = GoogleTestBeanBuilder.getMin();
    GoogleTestMessage actual = GoogleTestMessageBuilder.getEmpty();
    GoogleTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(6)
  public void testUpdateMin() {
    GoogleTestBean expected = GoogleTestBeanBuilder.getMax();
    GoogleTestMessage actual = GoogleTestMessageBuilder.getMin();
    GoogleTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getMin());
  }

  // Max.
  @Test
  @Order(7)
  public void testUpdateMax() {
    GoogleTestBean expected = GoogleTestBeanBuilder.getMin();
    GoogleTestMessage actual = GoogleTestMessageBuilder.getMax();
    GoogleTestBeanMapper.INSTANCE.updateBean(expected, actual);
    Assertions.assertEquals(expected, GoogleTestBeanBuilder.getMax());
  }

}
