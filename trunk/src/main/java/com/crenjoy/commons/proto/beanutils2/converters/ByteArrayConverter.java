package com.crenjoy.commons.proto.beanutils2.converters;

import com.google.protobuf.ByteString;

import org.apache.commons.beanutils2.ConversionException;
import org.apache.commons.beanutils2.converters.AbstractConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * byte[]类型转换.
 *
 * @author CGD
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]> {

  private transient Log log;

  public ByteArrayConverter() {
    this(new byte[0]);
  }

  public ByteArrayConverter(final byte[] defaultValue) {
    super(defaultValue);
  }

  @Override
  protected Class<byte[]> getDefaultType() {
    return byte[].class;
  }

  @Override
  protected <R> R convertToType(Class<R> type, Object value) throws Throwable {
    // Handle SubClass Type
    if (type.isAssignableFrom(value.getClass())) {
      return type.cast(value);
    }
    if (type.equals(byte[].class) && value instanceof ByteString) {
      ByteString bytes = (ByteString) value;
      return type.cast(bytes.toByteArray());
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
