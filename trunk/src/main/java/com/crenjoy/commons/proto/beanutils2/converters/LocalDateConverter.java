package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.LocalDate;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class LocalDateConverter extends DateTimeConverter<LocalDate> {

  public LocalDateConverter() {
    this(null);
  }

  public LocalDateConverter(final LocalDate defaultValue) {
    super(defaultValue, DateTimeParse.getLocalDateFormatters());
  }

  @Override
  protected Class<LocalDate> getDefaultType() {
    return LocalDate.class;
  }

}
