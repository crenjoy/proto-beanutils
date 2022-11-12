
package com.crenjoy.proto.utils;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.StringValue;
import com.google.protobuf.Timestamp;
import java.math.BigDecimal;
import java.time.temporal.TemporalAccessor;
import java.util.UUID;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Proto3 Any 类型转换为实体类型.
 *
 * @author CGD
 *
 */
public class AnyUtil {

  private static Log log = LogFactory.getLog(AnyUtil.class);

  /**
   * 封箱.
   *
   * @param message Message Object.
   * @return Proto3 Any Object.
   */
  public static <T extends com.google.protobuf.Message> Any pack(T message) {
    return Any.pack(message);
  }

  public static Any pack(String value) {
    return Any.pack(StringValue.of(value));
  }

  public static Any pack(int value) {
    return Any.pack(Int32Value.of(value));
  }

  public static Any pack(long value) {
    return Any.pack(Int64Value.of(value));
  }

  public static Any pack(boolean value) {
    return Any.pack(BoolValue.of(value));
  }

  public static Any pack(float value) {
    return Any.pack(FloatValue.of(value));
  }

  public static Any pack(double value) {
    return Any.pack(DoubleValue.of(value));
  }

  public static Any pack(byte[] value) {
    ByteString byteString = TypeUtil.INSTANCE.toProtoByteString(value);
    return Any.pack(BytesValue.of(byteString));
  }

  public static Any pack(ByteString value) {
    return Any.pack(BytesValue.of(value));
  }

  /** LocalDateTime、LocalDate、LocalTime、Instant. */
  public static Any pack(TemporalAccessor value) {
    Timestamp timeStamp = TypeUtil.INSTANCE.toProtoTimestamp(value);
    return Any.pack(timeStamp);
  }

  /** UUID pack . */
  public static Any pack(UUID value) {
    StringValue stringValue = StringValue.of(value.toString());
    return Any.pack(stringValue);
  }

  /** BigDecimal pack. */
  public static Any pack(BigDecimal value) {
    StringValue stringValue = StringValue.of(value.toString());
    return Any.pack(stringValue);
  }

  /** 枚举类型封箱. */
  public static Any pack(Enum<?> value) {
    StringValue stringValue = StringValue.of(value.name());
    return Any.newBuilder().setTypeUrl("Enum/" + value.getClass().getName())
        .setValue(stringValue.toByteString()).build();
  }

  /**
   * 拆箱.
   *
   * @param any Proto3 Any对象
   * @return Java 对象
   */
  public static Object unpack(Any any) {
    try {
      if (any.getTypeUrl().endsWith(StringValue.class.getName().substring(4))) {
        return any.unpack(StringValue.class).getValue();
      } else if (any.getTypeUrl().endsWith(Int32Value.class.getName().substring(4))) {
        return any.unpack(Int32Value.class).getValue();
      } else if (any.getTypeUrl().endsWith(Int64Value.class.getName().substring(4))) {
        return any.unpack(Int64Value.class).getValue();
      } else if (any.getTypeUrl().endsWith(BoolValue.class.getName().substring(4))) {
        return any.unpack(BoolValue.class).getValue();
      } else if (any.getTypeUrl().endsWith(DoubleValue.class.getName().substring(4))) {
        return any.unpack(DoubleValue.class).getValue();
      } else if (any.getTypeUrl().endsWith(FloatValue.class.getName().substring(4))) {
        return any.unpack(FloatValue.class).getValue();
      } else if (any.getTypeUrl().endsWith(BytesValue.class.getName().substring(4))) {
        return any.unpack(BytesValue.class).getValue();
      } else if (any.getTypeUrl().endsWith(Timestamp.class.getName().substring(4))) {
        Timestamp t = any.unpack(Timestamp.class);
        return t;
      } else if (any.getTypeUrl().startsWith("Enum/")) {
        String clazz = any.getTypeUrl().substring("Enum/".length());
        String enumName = StringValue.parseFrom(any.getValue()).getValue();
        Class<Enum> c = (Class) Class.forName(clazz);
        return EnumUtils.getEnum(c, enumName);
      }
    } catch (Exception ex) {
      log.error("unpack", ex);
    }
    return null;
  }

  /**
   * 拆箱.
   *
   * @param <T>   T Object Type.
   * @param any   Any Object.
   * @param clazz Object Class.
   * @return Object.
   */
  public static <T> T unpack(Any any, Class<T> clazz) {
    Object obj = unpack(any);
    if (clazz.isAssignableFrom(obj.getClass())) {
      return clazz.cast(obj);
    }
    return ProtoConvertUtils.convert(obj, clazz);
  }

}
