
package com.crenjoy.proto.utils;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.ProtoMapper;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;

/**
 * 常用类型转换.
 *
 * @author CGD
 *
 */
public class TypeUtil implements BeanMapper, ProtoMapper {

  public static TypeUtil INSTANCE = new TypeUtil();

  protected TypeUtil() {
  }

  /**
   * Message To Json.
   *
   * @param message Proto Message
   * @return String
   */
  public static String toJson(MessageOrBuilder message) {
    try {
      return JsonFormat.printer().print(message);
    } catch (Exception ex) {
      LogFactory.getLog(TypeUtil.class).error(ex);
      return "{}";
    }
  }

  /**
   * Enum To Object.
   *
   * @param enumValue   Enum value.
   * @param targetClass Target Object Class.
   * @return Enum / String / int
   */
  public static Object enumToObject(Enum<?> enumValue, Class<?> targetClass) {
    return ProtoConvertUtils.convert(enumValue, targetClass);
  }

  public static boolean isEmpty(Timestamp timestamp) {
    return null == timestamp || ((timestamp.getSeconds() == 0L) && (timestamp.getNanos() == 0L));
  }

  public static boolean isEmpty(LocalDateTime localDateTime) {
    return null == localDateTime;
  }

  public static boolean isEmpty(UUID uuid) {
    return null == uuid
        || StringUtils.equals("00000000-0000-0000-0000-000000000000", uuid.toString());
  }

  public static boolean isEmpty(String str) {
    return StringUtils.isBlank(str);
  }

}
