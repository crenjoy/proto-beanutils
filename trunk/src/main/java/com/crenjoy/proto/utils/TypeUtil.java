
package com.crenjoy.proto.utils;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.mapper.BeanMapper;
import com.crenjoy.proto.mapper.ProtoMapper;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
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

}
