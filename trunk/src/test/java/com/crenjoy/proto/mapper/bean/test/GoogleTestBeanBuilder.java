
package com.crenjoy.proto.mapper.bean.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GoogleTestBeanBuilder {

  public static GoogleTestBean getNull() {
    return new GoogleTestBean();
  }

  public static GoogleTestBean getEmpty() {
    GoogleTestBean bean = new GoogleTestBean();
    bean.setTestLocalDateTime(LocalDateTime.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    bean.setTestLocalDate(LocalDate.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    bean.setTestLocalTime(LocalTime.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    bean.setTestInstant(Instant.EPOCH);
    bean.setTestDuration(Duration.ZERO);
    bean.setTestOffsetDateTime(OffsetDateTime.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    bean.setTestOffsetTime(OffsetTime.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    bean.setTestZonedDateTime(ZonedDateTime.ofInstant(Instant.EPOCH,ZoneId.systemDefault()));
    return bean;
  }

  public static GoogleTestBean getMin() {
    GoogleTestBean bean = new GoogleTestBean();
    bean.setTestLocalDateTime(LocalDateTime.MIN);
    bean.setTestLocalDate(LocalDate.MIN);
    bean.setTestLocalTime(LocalTime.MIN);
    bean.setTestInstant(Instant.MIN);
    bean.setTestDuration(Duration.between(Instant.MIN, Instant.MAX));
    bean.setTestOffsetDateTime(LocalDateTime.MIN.atZone(ZoneId.systemDefault()).toOffsetDateTime());
    bean.setTestOffsetTime(LocalTime.MIN.atOffset( OffsetDateTime.now().getOffset()));
    bean.setTestZonedDateTime(LocalDateTime.MIN.atZone(ZoneId.systemDefault()));
    return bean;
  }

  public static GoogleTestBean getMax() {
    GoogleTestBean bean = new GoogleTestBean();
    bean.setTestLocalDateTime(LocalDateTime.MAX);
    bean.setTestLocalDate(LocalDate.MAX);
    bean.setTestLocalTime(LocalTime.MAX);
    bean.setTestInstant(Instant.MAX);
    bean.setTestDuration(Duration.between(Instant.MAX, Instant.MIN));
    bean.setTestOffsetDateTime(LocalDateTime.MAX.atZone(ZoneId.systemDefault()).toOffsetDateTime());
    bean.setTestOffsetTime(LocalTime.MAX.atOffset( OffsetDateTime.now().getOffset()));
    bean.setTestZonedDateTime(LocalDateTime.MAX.atZone(ZoneId.systemDefault()));
    return bean;
  }

}
