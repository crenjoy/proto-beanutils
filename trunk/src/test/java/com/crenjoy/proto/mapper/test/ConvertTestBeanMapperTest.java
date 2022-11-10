
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
public class ConvertTestBeanMapperTest {

  // Empty
  @Test
  @Order(1)
  public void testEmpty() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getEmpty();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getEmpty());
  }

  // Min
  @Test
  @Order(2)
  public void testMin() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMin();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMin());
  }

  // Max
  @Test
  @Order(3)
  public void testMax() {
    ConvertTestMessage actual = ConvertTestMessageBuilder.getMax();
    ConvertTestBean expected = ConvertTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, ConvertTestBeanBuilder.getMax());
  }
  
  

}
