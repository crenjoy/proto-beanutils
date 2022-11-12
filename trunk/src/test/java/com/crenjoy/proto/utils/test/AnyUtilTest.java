
package com.crenjoy.proto.utils.test;

import com.crenjoy.proto.utils.AnyUtil;
import com.google.protobuf.Any;
import crenjoy.protobuf.TestEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * AnyUtil 工具类测试.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnyUtilTest {

  private static Log log = LogFactory.getLog(AnyUtilTest.class);

  @Test
  @Order(1)
  public void testInt() {
    Any any = AnyUtil.pack(Integer.MAX_VALUE);
    log.info(any);
    Integer d4 = (Integer) AnyUtil.unpack(any);
    Assertions.assertEquals(d4, Integer.MAX_VALUE);

    any = AnyUtil.pack(Integer.MIN_VALUE);
    log.info(any);
    d4 = (Integer) AnyUtil.unpack(any);
    Assertions.assertEquals(d4, Integer.MIN_VALUE);
  }

  @Test
  @Order(2)
  public void testLong() {
    Any any = AnyUtil.pack(Long.MAX_VALUE);
    log.info(any);
    Long d3 = (Long) AnyUtil.unpack(any);
    Assertions.assertEquals(d3, Long.MAX_VALUE);

    any = AnyUtil.pack(Long.MIN_VALUE);
    log.info(any);
    d3 = (Long) AnyUtil.unpack(any);
    Assertions.assertEquals(d3, Long.MIN_VALUE);
  }

  @Test
  @Order(3)
  public void testString() {
    Any any = AnyUtil.pack("");
    log.info(any);
    String d3 = (String) AnyUtil.unpack(any);
    Assertions.assertEquals(d3, "");

    any = AnyUtil.pack("test");
    log.info(any);
    d3 = (String) AnyUtil.unpack(any);
    Assertions.assertEquals(d3, "test");
  }

  @Test
  @Order(4)
  public void testBoolean() {
    Any any = AnyUtil.pack(true);
    log.info(any);
    Boolean d5 = (Boolean) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, true);

    any = AnyUtil.pack(false);
    log.info(any);
    d5 = (Boolean) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, false);
  }

  @Test
  @Order(5)
  public void testFloat() {
    Any any = AnyUtil.pack(1.23f);
    log.info(any);
    Float d5 = (Float) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, 1.23f);

    any = AnyUtil.pack(0.01f);
    log.info(any);
    d5 = (Float) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, 0.01f);
  }

  @Test
  @Order(6)
  public void testLocalDateTime() {
    LocalDateTime v = LocalDateTime.now();
    Any any = AnyUtil.pack(v);
    log.info(any);
    LocalDateTime d5 = (LocalDateTime) AnyUtil.unpack(any, LocalDateTime.class);
    Assertions.assertEquals(d5, v);

    v = LocalDateTime.now();
    any = AnyUtil.pack(v);
    log.info(any);
    d5 = (LocalDateTime) AnyUtil.unpack(any, LocalDateTime.class);
    Assertions.assertEquals(d5, v);
  }

  @Test
  @Order(7)
  public void testBigDecimal() {
    BigDecimal bd = BigDecimal.valueOf(1.23d);
    Any any = AnyUtil.pack(bd);
    log.info(any);
    log.info(bd.doubleValue());
    BigDecimal d5 = (BigDecimal) AnyUtil.unpack(any, BigDecimal.class);
    Assertions.assertEquals(d5, bd);

    any = AnyUtil.pack(BigDecimal.valueOf(0.01d));
    log.info(any);
    d5 = (BigDecimal) AnyUtil.unpack(any, BigDecimal.class);
    Assertions.assertEquals(d5, BigDecimal.valueOf(0.01d));
  }

  @Test
  @Order(6)
  public void testUuid() {
    UUID v = UUID.randomUUID();
    Any any = AnyUtil.pack(v);
    log.info(any);
    UUID d5 = (UUID) AnyUtil.unpack(any, UUID.class);
    Assertions.assertEquals(d5, v);

    v = UUID.randomUUID();
    any = AnyUtil.pack(v);
    log.info(any);
    d5 = (UUID) AnyUtil.unpack(any, UUID.class);
    Assertions.assertEquals(d5, v);
  }

  @Test
  @Order(7)
  public void testEnum() {
    Any any = AnyUtil.pack(TestEnum.male);
    log.info(any);
    Enum<?> d5 = (Enum<?>) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, TestEnum.male);

    any = AnyUtil.pack(TestEnum.female);
    log.info(any);
    d5 = (Enum<?>) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, TestEnum.female);

    any = AnyUtil.pack(TestEnum.UNRECOGNIZED);
    log.info(any);
    d5 = (Enum<?>) AnyUtil.unpack(any);
    Assertions.assertEquals(d5, TestEnum.UNRECOGNIZED);
  }

}
