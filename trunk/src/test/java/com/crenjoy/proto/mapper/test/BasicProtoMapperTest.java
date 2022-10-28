package com.crenjoy.proto.mapper.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test1BeanBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Bean To Proto Message.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicProtoMapperTest {

  @Test
  public void test1ToMessage() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = new Basic1Test1Bean();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    assertEquals(expected.getTestFloat(), actual.getTestFloat());
  }

  @Test
  public void test1ToMessageMin() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMin();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    assertEquals(expected.getTestFloat(), actual.getTestFloat());
  }

  @Test
  public void test1ToMessageMax() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMax();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    assertEquals(expected.getTestFloat(), actual.getTestFloat());
  }

}
