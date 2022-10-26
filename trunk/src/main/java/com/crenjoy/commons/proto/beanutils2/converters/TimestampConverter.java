package com.crenjoy.commons.proto.beanutils2.converters;

import com.google.protobuf.Timestamp;

import java.time.format.DateTimeFormatter;

/**
 * com.google.protobuf.Timestamp类型转换.
 *
 * @author CGD
 *
 */
public class TimestampConverter extends DateTimeConverter<Timestamp> {

  public TimestampConverter() {
    this(Timestamp.newBuilder().build());
  }

  public TimestampConverter(final Timestamp defaultValue) {
    super(defaultValue, new DateTimeFormatter[] { DateTimeFormatter.ISO_INSTANT });
  }

  @Override
  protected Class<Timestamp> getDefaultType() {
    return Timestamp.class;
  }

}
