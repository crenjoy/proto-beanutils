package com.crenjoy.proto.mapper.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import crenjoy.protobuf.Basic1TestMessage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicMapperTest {

  @Test
  public void testMessageToBean() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMin();
    Basic1Test1Bean expected = BasicMapper.INSTANCE.toBean1(actual);
    assertEquals(expected.getTestDouble(), actual.getTestDouble());
  }

  @Test
  public void testBeanToMessage() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = new Basic1Test1Bean();
    actual.setTestFloat(11.21f);
//    actual.setTestString("");
//    actual.setTestBytes();
    Basic1TestMessage expected = BasicMapper.INSTANCE.toMessage1(actual);
    assertEquals(expected.getTestFloat(), actual.getTestFloat());
  }

  // @Test
  public void test2() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage actual = Basic1TestMsgBuilder.getMin();
    Basic1TestMessage.Builder expected = Basic1TestMessage.newBuilder();
    // BeanUtils.copyProperties(expected, actual);
    BeanUtils.copyProperty(actual, "testDouble", 11.23f);
    // assertEquals(expected.build(),actual);
  }

  // @Test
  public void test3() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage.Builder actual = Basic1TestMsgBuilder.getMin().toBuilder();
    // Basic1TestMessage.Builder expected=Basic1TestMessage.newBuilder();
    BeanUtils.setProperty(actual, "testDouble", 11.23f);
    assertEquals(11.23f, actual.getTestDouble());
  }

}
