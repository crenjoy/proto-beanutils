package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.ZonedDateTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class ZonedDateTimeConverter extends DateTimeConverter<ZonedDateTime> {

  public ZonedDateTimeConverter() {
    this(null);
  }

  public ZonedDateTimeConverter(final ZonedDateTime defaultValue) {
    super(defaultValue, DateTimeParse.getZonedDateTimeFormatters());
  }

  @Override
  protected Class<ZonedDateTime> getDefaultType() {
    return ZonedDateTime.class;
  }

}
