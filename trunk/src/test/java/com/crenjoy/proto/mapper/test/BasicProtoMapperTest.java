
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.Basic1TestBean;
import com.crenjoy.proto.mapper.bean.test.Basic1TestBeanBuilder;
import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
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
  public void test1ToMessage() {
    Basic1TestBean actual = Basic1TestBeanBuilder.getEmpty();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getDefault());
  }

  /**
   * Min --> Min.
   */
  @Test
  @Order(2)
  public void test1ToMessageMin() {
    Basic1TestBean actual = Basic1TestBeanBuilder.getMin();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMin());
  }

  /**
   * Max --> Max.
   */
  @Test
  @Order(3)
  public void test1ToMessageMax() {
    Basic1TestBean actual = Basic1TestBeanBuilder.getMax();
    Basic1TestMessage expected = BasicProtoMapper.INSTANCE.toMessage1(actual);
    Assertions.assertEquals(expected, Basic1TestMsgBuilder.getMax());
  }

  /**
   * Value Update Empty.
   */
  @Test
  @Order(4)
  public void testEmptyUpdateMessage1() {
    // Default Update Empty.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    Basic1TestBean actual = Basic1TestBeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Min Update Empty.
    expected = Basic1TestMsgBuilder.getMin().toBuilder();
    actual = Basic1TestBeanBuilder.getEmpty();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Max Update Empty.
    expected = Basic1TestMsgBuilder.getMax().toBuilder();
    actual = Basic1TestBeanBuilder.getEmpty();
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
    Basic1TestBean actual = Basic1TestBeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Default Update Min.
    expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    actual = Basic1TestBeanBuilder.getMin();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getMin());

    // Default Update Max.
    expected = Basic1TestMsgBuilder.getDefault().toBuilder();
    actual = Basic1TestBeanBuilder.getMax();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getMax());
  }

  /**
   * Value Update Default.
   */
  @Test
  @Order(6)
  public void testValueUpdateMessage1() {
    // Min Update Default.
    Basic1TestMessage.Builder expected = Basic1TestMsgBuilder.getMin().toBuilder();
    Basic1TestBean actual = Basic1TestBeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());

    // Max Update Default.
    expected = Basic1TestMsgBuilder.getMax().toBuilder();
    actual = Basic1TestBeanBuilder.getDefault();
    BasicProtoMapper.INSTANCE.updateMessage1(expected, actual);
    Assertions.assertEquals(expected.build(), Basic1TestMsgBuilder.getDefault());
  }

}
