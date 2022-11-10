package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class OffsetDateTimeConverter extends DateTimeConverter<OffsetDateTime> {

  public OffsetDateTimeConverter() {
    this(Instant.EPOCH.atOffset(ZoneOffset.UTC));
  }

  public OffsetDateTimeConverter(final OffsetDateTime defaultValue) {
    super(defaultValue, DateTimeParse.getOffsetDateTimeFormatters());
  }

  @Override
  protected Class<OffsetDateTime> getDefaultType() {
    return OffsetDateTime.class;
  }

}
