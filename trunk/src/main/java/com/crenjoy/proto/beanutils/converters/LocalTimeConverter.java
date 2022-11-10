package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;

import java.time.LocalTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class LocalTimeConverter extends DateTimeConverter<LocalTime> {

  public LocalTimeConverter() {
    this(null);
  }

  public LocalTimeConverter(final LocalTime defaultValue) {
    super(defaultValue, DateTimeParse.getLocalTimeFormatters());
  }

  @Override
  protected Class<LocalTime> getDefaultType() {
    return LocalTime.class;
  }

}
