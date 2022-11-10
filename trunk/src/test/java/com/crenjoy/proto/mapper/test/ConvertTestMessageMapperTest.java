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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConvertTestMessageMapperTest {
  
//  // Null
//  @Test
//  @Order(0)
//  public void testNull() {
//    ConvertTestBean actual = ConvertTestBeanBuilder.getNull();
//    ConvertTestMessage expected = ConvertTestMessageMapper.INSTANCE.toMessage(actual);
//    Assertions.assertEquals(expected, ConvertTestMessageBuilder.getEmpty());
//  }
  
  // Empty
  @Test
  @Order(1)
  public void testEmpty() {
    ConvertTestBean actual = ConvertTestBeanBuilder.getEmpty();
    ConvertTestMessage expected = ConvertTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, ConvertTestMessageBuilder.getEmpty());
  }
  
  
  // Min
  @Test
  @Order(2)
  public void testMin() {
    ConvertTestBean actual = ConvertTestBeanBuilder.getMin();
    ConvertTestMessage expected = ConvertTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, ConvertTestMessageBuilder.getMin());
  }
  
  // Max
  @Test
  @Order(3)
  public void testMax() {
    ConvertTestBean actual = ConvertTestBeanBuilder.getMax();
    ConvertTestMessage expected = ConvertTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, ConvertTestMessageBuilder.getMax());
  }
  

}
