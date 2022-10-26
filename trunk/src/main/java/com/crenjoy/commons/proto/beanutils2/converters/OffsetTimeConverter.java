package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;

import java.time.OffsetTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class OffsetTimeConverter extends DateTimeConverter<OffsetTime> {

  public OffsetTimeConverter() {
    this(null);
  }

  public OffsetTimeConverter(final OffsetTime defaultValue) {
    super(defaultValue, DateTimeParse.getOffsetTimeFormatters());
  }

  @Override
  protected Class<OffsetTime> getDefaultType() {
    return OffsetTime.class;
  }

}
