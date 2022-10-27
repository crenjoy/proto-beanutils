package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.LocalTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class LocalTimeConverter extends DateTimeConverter<LocalTime> {

  public LocalTimeConverter() {
    this(LocalTime.MIN);
  }

  public LocalTimeConverter(final LocalTime defaultValue) {
    super(defaultValue, DateTimeParse.getLocalTimeFormatters());
  }

  @Override
  protected Class<LocalTime> getDefaultType() {
    return LocalTime.class;
  }

}
