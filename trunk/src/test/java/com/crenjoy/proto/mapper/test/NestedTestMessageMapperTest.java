
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
    //Assertions.assertEquals(expected, NestedTestMessageBuilder.getEmpty());
  }

  // Empty
  @Test
  @Order(1)
  public void testEmpty() {
    NestedTestBean actual = NestedTestBeanBuilder.getEmpty();
    NestedTestMessage expected = NestedTestMessageMapper.INSTANCE.toMessage(actual);
    //Assertions.assertEquals(expected, NestedTestMessageBuilder.getEmpty());
  }
  
////Nested Test Message.
//message NestedTestMessage {
//  string test_string = 1;
//  double test_double = 2;
//  bool test_bool = 3;
//  Basic2TestMessage test_basic_bean = 4;
//  map < string, string > test_str_map = 5;
//  map < string, Basic2TestMessage > test_basic_map = 6;
//  repeated string test_str_list = 7;
//  repeated Basic2TestMessage test_basic_list = 8;
//  TestMessageList test_message_list = 9;
//  TestMessageMap test_message_map = 10;
//}

}
