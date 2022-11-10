
package com.crenjoy.proto.mapper.bean.test;

import crenjoy.protobuf.TestEnum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class ConvertTestBeanBuilder {

  public ConvertTestBean getNull() {
    return new ConvertTestBean();
  }

  public static ConvertTestBean getEmpty() {
    ConvertTestBean bean = new ConvertTestBean();
    bean.setTestLocalDateTime(LocalDateTime.of(LocalDate.EPOCH, LocalTime.MIN));
    bean.setTestLocalDate(LocalDate.EPOCH);
    bean.setTestLocalTime(LocalTime.MIN);
    bean.setTestInstant(Instant.EPOCH);
    bean.setTestDuration(Duration.ZERO);

    bean.setTestOffsetDateTime(Instant.EPOCH.atOffset(ZoneOffset.UTC));
    bean.setTestOffsetTime(OffsetTime.of(LocalTime.MIN, ZoneOffset.UTC));
    
    bean.setTestZonedDateTime(Instant.EPOCH.atOffset(ZoneOffset.UTC).toZonedDateTime());
    bean.setTestStrEnum(TestEnum.male);
    bean.setTestIntEnum(TestEnum.male);
    bean.setTestEnum(TestEnum.male);
    bean.setTestBigDecimal(BigDecimal.ZERO);
    bean.setTestDoubleBigDecimal(BigDecimal.valueOf(0d));
    bean.setTestBigInteger(BigInteger.ZERO);
    bean.setTestUuid(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    return bean;
  }

  public static ConvertTestBean getMin() {
    ConvertTestBean bean = new ConvertTestBean();
    bean.setTestLocalDateTime(LocalDateTime.MIN);
    bean.setTestLocalDate(LocalDate.MIN);
    bean.setTestLocalTime(LocalTime.MIN);
    bean.setTestInstant(Instant.MIN);
    bean.setTestDuration(Duration.between(Instant.MIN, Instant.MAX));
    bean.setTestOffsetDateTime(OffsetDateTime.MIN);
    bean.setTestOffsetTime(OffsetTime.MIN);
    bean.setTestZonedDateTime(OffsetDateTime.MIN.toZonedDateTime());
    bean.setTestStrEnum(TestEnum.male);
    bean.setTestIntEnum(TestEnum.male);
    bean.setTestEnum(TestEnum.male);
    bean.setTestBigDecimal(BigDecimal.valueOf(Double.MIN_VALUE));
    bean.setTestDoubleBigDecimal(BigDecimal.valueOf(Double.MIN_VALUE));
    bean.setTestBigInteger(BigInteger.valueOf(Integer.MIN_VALUE));
    bean.setTestUuid(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    return bean;
  }

  public static ConvertTestBean getMax() {
    ConvertTestBean bean = new ConvertTestBean();
    bean.setTestLocalDateTime(LocalDateTime.MAX);
    bean.setTestLocalDate(LocalDate.MAX);
    bean.setTestLocalTime(LocalTime.MAX);
    bean.setTestInstant(Instant.MAX);
    bean.setTestDuration(Duration.between(Instant.MAX, Instant.MIN));
    bean.setTestOffsetDateTime(OffsetDateTime.MAX);
    bean.setTestOffsetTime(OffsetTime.MAX);
    bean.setTestZonedDateTime(OffsetDateTime.MAX.toZonedDateTime());
    bean.setTestStrEnum(TestEnum.female);
    bean.setTestIntEnum(TestEnum.female);
    bean.setTestEnum(TestEnum.female);
    bean.setTestBigDecimal(BigDecimal.valueOf(Double.MAX_VALUE));
    bean.setTestDoubleBigDecimal(BigDecimal.valueOf(Double.MAX_VALUE));
    bean.setTestBigInteger(BigInteger.valueOf(Integer.MAX_VALUE));
    bean.setTestUuid(UUID.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    return bean;
  }

}
