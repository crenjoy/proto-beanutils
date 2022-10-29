
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test1BeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
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

  /**
   * null --> Default.
   */
  @Test
  public void test1ToMessage() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = new Basic1Test1Bean();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getEmpty());
  }

  /**
   * Min --> Min.
   */
  @Test
  public void test1ToMessageMin() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMin();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMin());
  }

  /**
   * Max --> Max.
   */
  @Test
  public void test1ToMessageMax() throws IllegalAccessException, InstantiationException,
      InvocationTargetException, NoSuchMethodException {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMax();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMax());
  }

}
