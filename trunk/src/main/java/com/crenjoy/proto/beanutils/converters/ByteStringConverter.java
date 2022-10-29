package com.crenjoy.proto.beanutils.converters;

import com.google.protobuf.ByteString;
import java.util.Objects;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ByteString类型转换.
 *
 * @author CGD
 *
 */
public class ByteStringConverter extends AbstractConverter {

  private transient Log log;

  public ByteStringConverter() {
    this(ByteString.EMPTY);
  }

  public ByteStringConverter(final ByteString defaultValue) {
    super(defaultValue);
  }

  @Override
  protected Class<ByteString> getDefaultType() {
    return ByteString.class;
  }

  @Override
  protected <R> R convertToType(Class<R> type, Object value) throws Throwable {
    // Handle SubClass Type
    if (type.isAssignableFrom(value.getClass())) {
      return type.cast(value);
    }
    if (type.equals(ByteString.class) && value instanceof byte[]) {
      byte[] bytes = (byte[]) value;
      return type.cast(ByteString.copyFrom(bytes));
    }
    final String msg = toString(getClass()) + " cannot handle conversion to '" + toString(type)
        + "'";
    if (getLog().isWarnEnabled()) {
      getLog().warn("    " + msg);
    }
    throw new ConversionException(msg);
  }

  /**
   * Converts the given object to a lower-case string.
   *
   * @param value the input string.
   * @return the given string trimmed and converter to lower-case.
   */
  protected static String toString(final Object value) {
    return Objects.requireNonNull(value, "value").toString();
  }

  @Override
  protected Object convertArray(final Object value) {
    return value;
  }

  protected Log getLog() {
    if (log == null) {
      log = LogFactory.getLog(getClass());
    }
    return log;
  }
}
