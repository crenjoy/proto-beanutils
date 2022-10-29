
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.Basic1Test1Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test1BeanBuilder;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2Bean;
import com.crenjoy.proto.beanutils.bean.test.Basic1Test2BeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
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
  @Order(1)
  public void test1ToMessage()  {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getEmpty();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getDefault());
  }

  /**
   * Min --> Min.
   */
  @Test
  @Order(2)
  public void test1ToMessageMin() {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMin();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMin());
  }

  /**
   * Max --> Max.
   */
  @Test
  @Order(3)
  public void test1ToMessageMax() {
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getMax();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMax());
  }

  /**
   * Value Update Empty.
   */
  @Test
  @Order(4)
  public void testEmptyUpdateMessage1()  {
    // Default Update Empty.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Min Update Empty.
    expected = Basic1TestMsgBuilder.getMin().toBuilder();
    actual = Basic1Test1BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Max Update Empty.
    expected = Basic1TestMsgBuilder.getMax().toBuilder();
    actual = Basic1Test1BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());
  }

  /**
   * Default Update Value.
   */
  @Test
  @Order(5)
  public void testDefaultUpdateMessage1() {
    // Default Update Default.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Default Update Min.
    expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    actual = Basic1Test1BeanBuilder.getMin();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getMin());

    // Default Update Max.
    expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    actual = Basic1Test1BeanBuilder.getMax();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getMax());
  }

  /**
   * Value Update Default.
   */
  @Test
  @Order(6)
  public void testValueUpdateMessage1()  {
    // Min Update Default.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getMin().toBuilder();
    Basic1Test1Bean actual = Basic1Test1BeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Max Update Default.
    expected = Basic1TestMsgBuilder.getMax().toBuilder();
    actual = Basic1Test1BeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());
  }

  /**
   * Bean2 null --> Default.
   */
  @Test
  @Order(7)
  public void test2ToMessage() {
    Basic1Test2Bean actual = Basic1Test2BeanBuilder.getEmpty();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage2(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getDefault());
  }

  /**
   * Bean2 Value Update Empty.
   */
  @Test
  @Order(8)
  public void testEmptyUpdateMessage2()  {
    // Default Update Empty.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    Basic1Test2Bean actual = Basic1Test2BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage2(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Min Update Empty.
    expected = Basic1TestMsgBuilder.getMin().toBuilder();
    actual = Basic1Test2BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage2(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Max Update Empty.
    expected = Basic1TestMsgBuilder.getMax().toBuilder();
    actual = Basic1Test2BeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage2(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());
  }

}
