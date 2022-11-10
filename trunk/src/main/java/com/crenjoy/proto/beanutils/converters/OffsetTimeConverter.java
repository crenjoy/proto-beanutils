package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class OffsetTimeConverter extends DateTimeConverter<OffsetTime> {

  public OffsetTimeConverter() {
    this(OffsetTime.of(LocalTime.MIN, ZoneOffset.UTC));
  }

  public OffsetTimeConverter(final OffsetTime defaultValue) {
    super(defaultValue, DateTimeParse.getOffsetTimeFormatters());
  }

  @Override
  protected Class<OffsetTime> getDefaultType() {
    return OffsetTime.class;
  }

}
