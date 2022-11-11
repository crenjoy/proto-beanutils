
package com.crenjoy.proto.mapper.bean.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Objects;

public class GoogleTestBean {

  LocalDateTime testLocalDateTime;
  LocalDate testLocalDate;
  LocalTime testLocalTime;
  Instant testInstant;
  Duration testDuration;
  OffsetDateTime testOffsetDateTime;
  OffsetTime testOffsetTime;
  ZonedDateTime testZonedDateTime;

  public LocalDateTime getTestLocalDateTime() {
    return testLocalDateTime;
  }

  public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
    this.testLocalDateTime = testLocalDateTime;
  }

  public LocalDate getTestLocalDate() {
    return testLocalDate;
  }

  public void setTestLocalDate(LocalDate testLocalDate) {
    this.testLocalDate = testLocalDate;
  }

  public LocalTime getTestLocalTime() {
    return testLocalTime;
  }

  public void setTestLocalTime(LocalTime testLocalTime) {
    this.testLocalTime = testLocalTime;
  }

  public Instant getTestInstant() {
    return testInstant;
  }

  public void setTestInstant(Instant testInstant) {
    this.testInstant = testInstant;
  }

  public Duration getTestDuration() {
    return testDuration;
  }

  public void setTestDuration(Duration testDuration) {
    this.testDuration = testDuration;
  }

  public OffsetDateTime getTestOffsetDateTime() {
    return testOffsetDateTime;
  }

  public void setTestOffsetDateTime(OffsetDateTime testOffsetDateTime) {
    this.testOffsetDateTime = testOffsetDateTime;
  }

  public OffsetTime getTestOffsetTime() {
    return testOffsetTime;
  }

  public void setTestOffsetTime(OffsetTime testOffsetTime) {
    this.testOffsetTime = testOffsetTime;
  }

  public ZonedDateTime getTestZonedDateTime() {
    return testZonedDateTime;
  }

  public void setTestZonedDateTime(ZonedDateTime testZonedDateTime) {
    this.testZonedDateTime = testZonedDateTime;
  }

  @Override
  public String toString() {
    return "GoogleTestBean [testLocalDateTime=" + testLocalDateTime + ", testLocalDate="
        + testLocalDate + ", testLocalTime=" + testLocalTime + ", testInstant=" + testInstant
        + ", testDuration=" + testDuration + ", testOffsetDateTime=" + testOffsetDateTime
        + ", testOffsetTime=" + testOffsetTime + ", testZonedDateTime=" + testZonedDateTime + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(testDuration, testInstant, testLocalDate, testLocalDateTime, testLocalTime,
        testOffsetDateTime, testOffsetTime, testZonedDateTime);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GoogleTestBean other = (GoogleTestBean) obj;
    return Objects.equals(testDuration, other.testDuration)
        && Objects.equals(testInstant, other.testInstant)
        && Objects.equals(testLocalDate, other.testLocalDate)
        && Objects.equals(testLocalDateTime, other.testLocalDateTime)
        && Objects.equals(testLocalTime, other.testLocalTime)
        && Objects.equals(testOffsetDateTime, other.testOffsetDateTime)
        && Objects.equals(testOffsetTime, other.testOffsetTime)
        && Objects.equals(testZonedDateTime, other.testZonedDateTime);
  }

}
