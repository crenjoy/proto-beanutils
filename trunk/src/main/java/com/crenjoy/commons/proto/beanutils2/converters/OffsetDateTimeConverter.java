package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.OffsetDateTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class OffsetDateTimeConverter extends DateTimeConverter<OffsetDateTime> {

  public OffsetDateTimeConverter() {
    this(null);
  }

  public OffsetDateTimeConverter(final OffsetDateTime defaultValue) {
    super(defaultValue, DateTimeParse.getOffsetDateTimeFormatters());
  }

  @Override
  protected Class<OffsetDateTime> getDefaultType() {
    return OffsetDateTime.class;
  }

}
