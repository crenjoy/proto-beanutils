package com.crenjoy.commons.proto.beanutils2;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;

/**
 * <p>
 * Utility methods for converting String scalar values to objects of the
 * specified Class, String arrays to arrays of the specified Class.
 * </p>
 *
 * <p>
 * For more details, see {@code ConvertUtilsBean} which provides the
 * implementations for these methods.
 * </p>
 *
 * @see ConvertUtilsBean
 */
public class ProtoConvertUtils {
  /**
   * Set Default Locale Simplified Chinese、Shanghai TimeZone.
   */
  public static void defaultChinaLocale() {
    Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
    final TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
    TimeZone.setDefault(timeZone);
  }

  /**
   * <p>
   * Converts the specified value into a String.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param value Value to be converted (may be null)
   * @return The converted String value or null if value is null
   *
   * @see ConvertUtilsBean#convert(Object)
   */
  public static String convert(final Object value) {
    return ProtoConvertUtilsBean.getInstance().convert(value);
  }

  /**
   * <p>
   * Converts the specified value to an object of the specified class (if
   * possible). Otherwise, return a String representation of the value.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param value Value to be converted (may be null)
   * @param clazz Java class to be converted to (must not be null)
   * @return The converted value
   *
   * @see ConvertUtilsBean#convert(String, Class)
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(final String value, final Class<T> clazz) {
    return (T) ProtoConvertUtilsBean.getInstance().convert(value, clazz);
  }

  /**
   * <p>
   * Convert an array of specified values to an array of objects of the specified
   * class (if possible).
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param values Array of values to be converted
   * @param clazz  Java array or element class to be converted to (must not be
   *               null)
   * @return The converted value
   *
   * @see ConvertUtilsBean#convert(String[], Class)
   */
  public static Object convert(final String[] values, final Class<?> clazz) {
    return ProtoConvertUtilsBean.getInstance().convert(values, clazz);
  }

  /**
   * <p>
   * Converts the value to an object of the specified class (if possible).
   * </p>
   *
   * @param value      Value to be converted (may be null)
   * @param targetType Class of the value to be converted to (must not be null)
   * @return The converted value
   *
   * @throws ConversionException if thrown by an underlying Converter
   */
  @SuppressWarnings("unchecked")
  public static <T> T convert(final Object value, final Class<T> targetType) {
    return (T) ProtoConvertUtilsBean.getInstance().convert(value, targetType);
  }

  /**
   * <p>
   * Remove all registered {@link Converter}s, and re-establish the standard
   * Converters.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @see ConvertUtilsBean#deregister()
   */
  public static void deregister() {
    ProtoConvertUtilsBean.getInstance().deregister();
  }

  /**
   * <p>
   * Remove any registered {@link Converter} for the specified destination
   * {@code Class}.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param clazz Class for which to remove a registered Converter
   * @see ConvertUtilsBean#deregister(Class)
   */
  public static void deregister(final Class<?> clazz) {
    ProtoConvertUtilsBean.getInstance().deregister(clazz);
  }

  /**
   * <p>
   * Look up and return any registered {@link Converter} for the specified
   * destination class; if there is no registered Converter, return {@code null}.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param clazz Class for which to return a registered Converter
   * @return The registered {@link Converter} or {@code null} if not found
   * @see ConvertUtilsBean#lookup(Class)
   */
  public static Converter lookup(final Class<?> clazz) {
    return ProtoConvertUtilsBean.getInstance().lookup(clazz);
  }

  /**
   * Look up and return any registered {@link Converter} for the specified source
   * and destination class; if there is no registered Converter, return
   * {@code null}.
   *
   * @param sourceType Class of the value being converted
   * @param targetType Class of the value to be converted to
   * @return The registered {@link Converter} or {@code null} if not found
   */
  public static Converter lookup(final Class<?> sourceType, final Class<?> targetType) {
    return ProtoConvertUtilsBean.getInstance().lookup(sourceType, targetType);
  }

  /**
   * <p>
   * Register a custom {@link Converter} for the specified destination
   * {@code Class}, replacing any previously registered Converter.
   * </p>
   *
   * <p>
   * For more details see {@code ConvertUtilsBean}.
   * </p>
   *
   * @param converter Converter to be registered
   * @param clazz     Destination class for conversions performed by this
   *                  Converter
   * @see ConvertUtilsBean#register(Converter, Class)
   */
  public static void register(final Converter converter, final Class<?> clazz) {
    ProtoConvertUtilsBean.getInstance().register(converter, clazz);
  }

  /**
   * Change primitive Class types to the associated wrapper class. This is useful
   * for concrete converter implementations which typically treat primitive types
   * like their corresponding wrapper types.
   *
   * @param <T>  The type to be checked.
   * @param type The class type to check.
   * @return The converted type.
   * @since 1.9
   */
  // All type casts are safe because the TYPE members of the wrapper types
  // return their own class.
  @SuppressWarnings("unchecked")
  public static <T> Class<T> primitiveToWrapper(final Class<T> type) {
    if (type == null || !type.isPrimitive()) {
      return type;
    }

    if (type == Integer.TYPE) {
      return (Class<T>) Integer.class;
    }
    if (type == Double.TYPE) {
      return (Class<T>) Double.class;
    }
    if (type == Long.TYPE) {
      return (Class<T>) Long.class;
    }
    if (type == Boolean.TYPE) {
      return (Class<T>) Boolean.class;
    }
    if (type == Float.TYPE) {
      return (Class<T>) Float.class;
    }
    if (type == Short.TYPE) {
      return (Class<T>) Short.class;
    }
    if (type == Byte.TYPE) {
      return (Class<T>) Byte.class;
    }
    if (type == Character.TYPE) {
      return (Class<T>) Character.class;
    }
    return type;
  }

}
