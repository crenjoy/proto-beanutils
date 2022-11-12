
package com.crenjoy.proto.utils.test;

import com.crenjoy.proto.utils.TypeUtil;
import com.google.protobuf.Timestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * 类型转换测试.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TypeUtilTest {

  @Test
  @Order(1)
  public void testBigDecimal() {
    // -- 数值
    BigDecimal v1 = new BigDecimal("1.123");
    // 序列化
    String d1 = TypeUtil.INSTANCE.toProtoString(v1);
    Assertions.assertEquals(d1, "1.123");
    // 反序列化
    BigDecimal v2 = TypeUtil.INSTANCE.toBigDecimal(d1);
    Assertions.assertEquals(v1, v2);

    // -- null值
    v1 = BigDecimal.valueOf(Double.MIN_VALUE);
    // 序列化
    double dx = v1.doubleValue();

    Assertions.assertEquals(dx, Double.MIN_VALUE);
    // 反序列化
    v2 = BigDecimal.valueOf(dx);
    Assertions.assertEquals(v1, v2);

  }

  @Test
  @Order(2)
  public void testTimestamp() {
    LocalDateTime v1 = LocalDateTime.MIN;
    // 序列化
    Timestamp d1 = TypeUtil.INSTANCE.toProtoTimestamp(v1);
    // 反序列化
    LocalDateTime v2 = TypeUtil.INSTANCE.toLocalDateTime(d1);
    Assertions.assertEquals(v1, v2);
  }

  @Test
  @Order(3)
  public void testTimestamp2() {
    LocalDateTime v1 = LocalDateTime.MAX;
    // 序列化
    Timestamp d1 = TypeUtil.INSTANCE.toProtoTimestamp(v1);
    // 反序列化
    LocalDateTime v2 = TypeUtil.INSTANCE.toLocalDateTime(d1);
    Assertions.assertEquals(v1, v2);
  }

  @Test
  @Order(4)
  public void testTimestamp3() {
    LocalTime v1 = LocalTime.MAX;
    // 序列化
    Timestamp d1 = TypeUtil.INSTANCE.toProtoTimestamp(v1);
    // 反序列化
    LocalTime v2 = TypeUtil.INSTANCE.toLocalTime(d1);
    Assertions.assertEquals(v1, v2);
  }

  @Test
  @Order(5)
  public void testTimestamp4() {
    LocalTime v1 = LocalTime.MIN;
    // 序列化
    Timestamp d1 = TypeUtil.INSTANCE.toProtoTimestamp(v1);
    // 反序列化
    LocalTime v2 = TypeUtil.INSTANCE.toLocalTime(d1);
    Assertions.assertEquals(v1, v2);
  }

  @Test
  @Order(6)
  public void testUuid() {
    // 随机测试
    UUID v1 = UUID.randomUUID();
    // 序列化
    String d1 = TypeUtil.INSTANCE.toProtoString(v1);
    // 反序列化
    UUID v2 = TypeUtil.INSTANCE.toUUID(d1);
    Assertions.assertEquals(v1, v2);
  }

}
