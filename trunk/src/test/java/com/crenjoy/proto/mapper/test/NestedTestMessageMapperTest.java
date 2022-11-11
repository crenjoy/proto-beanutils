
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.NestedTestBean;
import com.crenjoy.proto.mapper.bean.test.NestedTestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.NestedTestMessageBuilder;
import crenjoy.protobuf.NestedTestMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class NestedTestMessageMapperTest {

  // Null
  @Test
  @Order(0)
  public void testNull() {
    NestedTestBean actual = NestedTestBeanBuilder.getNull();
    NestedTestMessage expected = NestedTestMessageMapper.INSTANCE.toMessage(actual);
    expected=expected.toBuilder().clearTestBasicBean().clearTestMessageList().clearTestMessageMap().build();
    Assertions.assertEquals(expected, NestedTestMessageBuilder.getEmpty());
  }

  // Empty
  @Test
  @Order(1)
  public void testEmpty() {
    NestedTestBean actual = NestedTestBeanBuilder.getEmpty();
    NestedTestMessage expected = NestedTestMessageMapper.INSTANCE.toMessage(actual);
    expected=expected.toBuilder().clearTestBasicBean().clearTestMessageList().clearTestMessageMap().build();
    Assertions.assertEquals(expected, NestedTestMessageBuilder.getEmpty());
  }

  // Min
  @Test
  @Order(1)
  public void testMin() {
    NestedTestBean actual = NestedTestBeanBuilder.getMin();
    NestedTestMessage expected = NestedTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, NestedTestMessageBuilder.getMin());
  }
  
  // Max
  @Test
  @Order(1)
  public void testMax() {
    NestedTestBean actual = NestedTestBeanBuilder.getMax();
    NestedTestMessage expected = NestedTestMessageMapper.INSTANCE.toMessage(actual);
    Assertions.assertEquals(expected, NestedTestMessageBuilder.getMax());
  }

}
