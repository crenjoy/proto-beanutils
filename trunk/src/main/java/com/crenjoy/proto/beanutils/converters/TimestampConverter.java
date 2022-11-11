package com.crenjoy.proto.beanutils.converters;

import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Timestamps;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * com.google.protobuf.Timestamp类型转换.
 *
 * @author CGD
 *
 */
public class TimestampConverter extends DateTimeConverter<Timestamp> {

  public TimestampConverter() {
    this(Timestamps.EPOCH);
    this.setZoneId(ZoneOffset.UTC);
  }

  public TimestampConverter(final Timestamp defaultValue) {
    super(defaultValue, new DateTimeFormatter[] { DateTimeFormatter.ISO_INSTANT });
    this.setZoneId(ZoneOffset.UTC);
  }

  @Override
  protected Class<Timestamp> getDefaultType() {
    return Timestamp.class;
  }

}
