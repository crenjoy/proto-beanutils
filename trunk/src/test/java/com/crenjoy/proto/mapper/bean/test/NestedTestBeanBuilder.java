
package com.crenjoy.proto.mapper.bean.test;

import java.util.Collections;

public class NestedTestBeanBuilder {

  protected NestedTestBeanBuilder() {

  }

  public static NestedTestBean getNull() {
    return new NestedTestBean();
  }

  public static NestedTestBean getEmpty() {
    NestedTestBean bean = new NestedTestBean();
    bean.setTestString("");
    bean.setTestStrMap(Collections.emptyMap());
    bean.setTestBasicMap(Collections.emptyMap());
    bean.setTestStrList(Collections.emptyList());
    bean.setTestBasicList(Collections.emptyList());
    return bean;
  }

////Nested Test Message.
//message NestedTestMessage {
//    string test_string = 1;
//    double test_double = 2;
//    bool test_bool = 3;
//    Basic2TestMessage test_basic_bean = 4;
//    map < string, string > test_str_map = 5;
//    map < string, Basic2TestMessage > test_basic_map = 6;
//    repeated string test_str_list = 7;
//    repeated Basic2TestMessage test_basic_list = 8;
//    TestMessageList test_message_list = 9;
//    TestMessageMap test_message_map = 10;
//}

}
