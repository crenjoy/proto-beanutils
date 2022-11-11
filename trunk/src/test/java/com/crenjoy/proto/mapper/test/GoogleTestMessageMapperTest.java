
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoogleTestMessageMapperTest {

  // Null.
  @Test
  @Order(0)
  public void testNull() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getNull();
    GoogleTestMessage expected = GoogleTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getEmpty());
  }

  // Empty.
  @Test
  @Order(1)
  public void testEmpty() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getEmpty();
    System.out.println(actual);
    GoogleTestMessage expected = GoogleTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(2)
  public void testMin() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getMin();
    GoogleTestMessage expected = GoogleTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getMin());
  }

  // Max.
  @Test
  @Order(3)
  public void testMax() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getMax();
    GoogleTestMessage expected = GoogleTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getMax());
  }

  // Empty.
  @Test
  @Order(4)
  public void testUpdateEmpty() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getEmpty();
    GoogleTestMessage expected = GoogleTestMessageBuilder.getMax();
    expected = GoogleTestMessageMapper.INSTANCE.updateMessage(expected, actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getEmpty());
  }

  // Min.
  @Test
  @Order(4)
  public void testUpdateMin() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getMin();
    GoogleTestMessage expected = GoogleTestMessageBuilder.getMax();
    expected = GoogleTestMessageMapper.INSTANCE.updateMessage(expected, actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getMin());
  }

  // Max.
  @Test
  @Order(4)
  public void testUpdateMax() {
    GoogleTestBean actual = GoogleTestBeanBuilder.getMax();
    GoogleTestMessage expected = GoogleTestMessageBuilder.getMin();
    expected = GoogleTestMessageMapper.INSTANCE.updateMessage(expected, actual);
    Assertions.assertEquals(expected, GoogleTestMessageBuilder.getMax());
  }

}
