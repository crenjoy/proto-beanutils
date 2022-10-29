package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;
import java.time.Instant;

/**
 * 类型转换.
 *
 * @author CGD
 *
 */
public class InstantConverter extends DateTimeConverter<Instant> {

  public InstantConverter() {
    this(Instant.EPOCH);
  }

  public InstantConverter(final Instant defaultValue) {
    super(defaultValue, DateTimeParse.getInstantFormatters());
  }

  @Override
  protected Class<Instant> getDefaultType() {
    return Instant.class;
  }

}
