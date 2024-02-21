
package com.crenjoy.proto.mapper.message.test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import crenjoy.protobuf.ConvertTestMessage;
import crenjoy.protobuf.TestEnum;

public class ConvertTestMessageBuilder {

  public static ConvertTestMessage getEmpty() {
    ConvertTestMessage.Builder builder = ConvertTestMessage.newBuilder();
    return builder.build();
  }

  public static ConvertTestMessage getMin() {
    ConvertTestMessage.Builder builder = ConvertTestMessage.newBuilder();
    builder.setTestLocalDateTime(LocalDateTime.MIN.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    builder.setTestLocalDate(LocalDate.MIN.toString());
    builder.setTestLocalTime(LocalTime.MIN.format(DateTimeFormatter.ISO_LOCAL_TIME));
    builder.setTestInstant(Instant.MIN.toString());
    builder.setTestDuration(Duration.between(Instant.MIN, Instant.MAX).toString());
    builder
        .setTestOffsetDateTime(OffsetDateTime.MIN.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    builder.setTestOffsetTime(OffsetTime.MIN.format(DateTimeFormatter.ISO_OFFSET_TIME));
    builder.setTestZonedDateTime(
        OffsetDateTime.MIN.toZonedDateTime().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    builder.setTestStrEnum(TestEnum.male.name());
    builder.setTestIntEnum(0);
    builder.setTestEnum(TestEnum.male);
    builder.setTestBigDecimal(BigDecimal.valueOf(Double.MIN_VALUE).toString());
    builder.setTestDoubleBigDecimal(Double.MIN_VALUE);
    builder.setTestBigInteger(String.valueOf(Integer.MIN_VALUE));
    builder.setTestUuid("00000000-0000-0000-0000-000000000000");
    return builder.build();
  }

  public static ConvertTestMessage getMax() {
    ConvertTestMessage.Builder builder = ConvertTestMessage.newBuilder();
    builder.setTestLocalDateTime(LocalDateTime.MAX.toString());
    builder.setTestLocalDate(LocalDate.MAX.toString());
    builder.setTestLocalTime(LocalTime.MAX.toString());
    builder.setTestInstant(Instant.MAX.toString());
    builder.setTestDuration(Duration.between(Instant.MAX, Instant.MIN).toString());
    builder.setTestOffsetDateTime(OffsetDateTime.MAX.toString());
    builder.setTestOffsetTime(OffsetTime.MAX.toString());
    builder.setTestZonedDateTime(OffsetDateTime.MAX.toZonedDateTime().toString());
    builder.setTestStrEnum(TestEnum.female.name());
    builder.setTestIntEnum(1);
    builder.setTestEnum(TestEnum.female);
    builder.setTestBigDecimal(BigDecimal.valueOf(Double.MAX_VALUE).toString());
    builder.setTestDoubleBigDecimal(Double.MAX_VALUE);
    builder.setTestBigInteger(String.valueOf(Integer.MAX_VALUE));
    builder.setTestUuid("ffffffff-ffff-ffff-ffff-ffffffffffff");
    return builder.build();
  }
}
