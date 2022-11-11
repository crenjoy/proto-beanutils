
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.NestedTestBean;
import com.crenjoy.proto.mapper.bean.test.NestedTestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.NestedTestMessageBuilder;
import crenjoy.protobuf.NestedTestMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NestedTestBeanMapperTest {

  // Empty
  @Test
  @Order(1)
  public void testEmpty() {
    NestedTestMessage actual = NestedTestMessageBuilder.getEmpty();
    NestedTestBean expected = NestedTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, NestedTestBeanBuilder.getEmpty());
  }

  // Min
  @Test
  @Order(2)
  public void testMin() {
    NestedTestMessage actual = NestedTestMessageBuilder.getMin();
    NestedTestBean expected = NestedTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, NestedTestBeanBuilder.getMin());
  }

  // Max
  @Test
  @Order(3)
  public void testMax() {
    NestedTestMessage actual = NestedTestMessageBuilder.getMax();
    NestedTestBean expected = NestedTestBeanMapper.INSTANCE.toBean(actual);
    Assertions.assertEquals(expected, NestedTestBeanBuilder.getMax());
  }

}
