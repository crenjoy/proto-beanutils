
package com.crenjoy.proto.mapper.message.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.Timestamp;
import com.google.protobuf.util.Durations;
import com.google.protobuf.util.Timestamps;

import crenjoy.protobuf.GoogleTestMessage;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class GoogleTestMessageBuilder {

  public static GoogleTestMessage getEmpty() {
    GoogleTestMessage.Builder builder = GoogleTestMessage.newBuilder();
    builder.setTestLocalDateTime(Timestamps.EPOCH);
    builder.setTestLocalDate(Timestamps.EPOCH);
    builder.setTestLocalTime(Timestamps.EPOCH);
    builder.setTestInstant(Timestamps.EPOCH);    
    builder.setTestDuration(Durations.ZERO);
    builder.setTestOffsetDateTime(Timestamps.EPOCH);
    builder.setTestOffsetTime(Timestamps.EPOCH);
    builder.setTestZonedDateTime(Timestamps.EPOCH);
    return builder.build();
  }

  public static GoogleTestMessage getMin() {
    GoogleTestMessage.Builder builder = GoogleTestMessage.newBuilder();    
    builder.setTestLocalDateTime(ProtoConvertUtils.convert(LocalDateTime.MIN, Timestamp.class));
    builder.setTestLocalDate(ProtoConvertUtils.convert(LocalDate.MIN, Timestamp.class));
    builder.setTestLocalTime(ProtoConvertUtils.convert(LocalTime.MIN, Timestamp.class));
    builder.setTestInstant(ProtoConvertUtils.convert(Instant.MIN, Timestamp.class));    
    builder.setTestDuration(ProtoConvertUtils.convert(Duration.between(Instant.MIN, Instant.MAX), com.google.protobuf.Duration.class));
    builder.setTestOffsetDateTime(ProtoConvertUtils.convert(OffsetDateTime.MIN.toLocalDateTime(), Timestamp.class));
    builder.setTestOffsetTime(ProtoConvertUtils.convert(OffsetTime.MIN.toLocalTime(), Timestamp.class));
    builder.setTestZonedDateTime(ProtoConvertUtils.convert(OffsetDateTime.MIN.toZonedDateTime().toLocalDateTime(), Timestamp.class));
    return builder.build();
  }

  public static GoogleTestMessage getMax() {
    GoogleTestMessage.Builder builder = GoogleTestMessage.newBuilder();
    builder.setTestLocalDateTime(ProtoConvertUtils.convert(LocalDateTime.MAX, Timestamp.class));
    builder.setTestLocalDate(ProtoConvertUtils.convert(LocalDate.MAX, Timestamp.class));
    builder.setTestLocalTime(ProtoConvertUtils.convert(LocalTime.MAX, Timestamp.class));
    builder.setTestInstant(ProtoConvertUtils.convert(Instant.MAX, Timestamp.class));    
    builder.setTestDuration(ProtoConvertUtils.convert(Duration.between(Instant.MAX, Instant.MIN), com.google.protobuf.Duration.class));
    builder.setTestOffsetDateTime(ProtoConvertUtils.convert(OffsetDateTime.MAX.toLocalDateTime(), Timestamp.class));
    builder.setTestOffsetTime(ProtoConvertUtils.convert(OffsetTime.MAX.toLocalTime(), Timestamp.class));
    builder.setTestZonedDateTime(ProtoConvertUtils.convert(OffsetDateTime.MAX.toZonedDateTime().toLocalDateTime(), Timestamp.class));
    return builder.build();
  }
}
