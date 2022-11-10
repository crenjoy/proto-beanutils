package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class ZonedDateTimeConverter extends DateTimeConverter<ZonedDateTime> {

  public ZonedDateTimeConverter() {
    this(Instant.EPOCH.atOffset(ZoneOffset.UTC).toZonedDateTime());
  }

  public ZonedDateTimeConverter(final ZonedDateTime defaultValue) {
    super(defaultValue, DateTimeParse.getZonedDateTimeFormatters());
  }

  @Override
  protected Class<ZonedDateTime> getDefaultType() {
    return ZonedDateTime.class;
  }

}
