package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;

import java.time.LocalDate;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class LocalDateConverter extends DateTimeConverter<LocalDate> {

  public LocalDateConverter() {
    this(LocalDate.EPOCH);
  }

  public LocalDateConverter(final LocalDate defaultValue) {
    super(defaultValue, DateTimeParse.getLocalDateFormatters());
  }

  @Override
  protected Class<LocalDate> getDefaultType() {
    return LocalDate.class;
  }

}
