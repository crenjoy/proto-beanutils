package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class LocalDateTimeConverter extends DateTimeConverter<LocalDateTime> {

  public LocalDateTimeConverter() {
    this(LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIN));
  }

  public LocalDateTimeConverter(final LocalDateTime defaultValue) {
    super(defaultValue, DateTimeParse.getLocalDateTimeFormatters());
  }

  @Override
  protected Class<LocalDateTime> getDefaultType() {
    return LocalDateTime.class;
  }

}
