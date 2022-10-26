package com.crenjoy.commons.proto.beanutils2.converters;

import com.google.protobuf.ByteString;

import org.apache.commons.beanutils2.ConversionException;
import org.apache.commons.beanutils2.converters.AbstractConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * ByteString类型转换.
 *
 * @author CGD
 *
 */
public class ByteStringConverter extends AbstractConverter<ByteString> {

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
