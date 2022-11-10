
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
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class ConvertTestBean {

  LocalDateTime testLocalDateTime;
  LocalDate testLocalDate;
  LocalTime testLocalTime;
  Instant testInstant;
  Duration testDuration;
  OffsetDateTime testOffsetDateTime;
  OffsetTime testOffsetTime;
  ZonedDateTime testZonedDateTime;
  TestEnum testStrEnum;
  TestEnum testIntEnum;
  TestEnum testEnum;
  BigDecimal testBigDecimal;
  BigDecimal testDoubleBigDecimal;
  BigInteger testBigInteger;
  UUID testUuid;

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

  public TestEnum getTestStrEnum() {
    return testStrEnum;
  }

  public void setTestStrEnum(TestEnum testStrEnum) {
    this.testStrEnum = testStrEnum;
  }

  public TestEnum getTestIntEnum() {
    return testIntEnum;
  }

  public void setTestIntEnum(TestEnum testIntEnum) {
    this.testIntEnum = testIntEnum;
  }

  public TestEnum getTestEnum() {
    return testEnum;
  }

  public void setTestEnum(TestEnum testEnum) {
    this.testEnum = testEnum;
  }

  public BigDecimal getTestBigDecimal() {
    return testBigDecimal;
  }

  public void setTestBigDecimal(BigDecimal testBigDecimal) {
    this.testBigDecimal = testBigDecimal;
  }

  public BigDecimal getTestDoubleBigDecimal() {
    return testDoubleBigDecimal;
  }

  public void setTestDoubleBigDecimal(BigDecimal testDoubleBigDecimal) {
    this.testDoubleBigDecimal = testDoubleBigDecimal;
  }

  public BigInteger getTestBigInteger() {
    return testBigInteger;
  }

  public void setTestBigInteger(BigInteger testBigInteger) {
    this.testBigInteger = testBigInteger;
  }

  public UUID getTestUuid() {
    return testUuid;
  }

  public void setTestUuid(UUID testUuid) {
    this.testUuid = testUuid;
  }

  @Override
  public String toString() {
    return "ConvertTestBean [testLocalDateTime=" + testLocalDateTime + ", testLocalDate="
        + testLocalDate + ", testLocalTime=" + testLocalTime + ", testInstant=" + testInstant
        + ", testDuration=" + testDuration + ", testOffsetDateTime=" + testOffsetDateTime
        + ", testOffsetTime=" + testOffsetTime + ", testZonedDateTime=" + testZonedDateTime
        + ", testStrEnum=" + testStrEnum + ", testIntEnum=" + testIntEnum + ", testEnum=" + testEnum
        + ", testBigDecimal=" + testBigDecimal + ", testDoubleBigDecimal=" + testDoubleBigDecimal
        + ", testBigInteger=" + testBigInteger + ", testUuid=" + testUuid + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(testBigDecimal, testBigInteger, testDoubleBigDecimal, testDuration,
        testEnum, testInstant, testIntEnum, testLocalDate, testLocalDateTime, testLocalTime,
        testOffsetDateTime, testOffsetTime, testStrEnum, testUuid, testZonedDateTime);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ConvertTestBean other = (ConvertTestBean) obj;
    return Objects.equals(testBigDecimal, other.testBigDecimal)
        && Objects.equals(testBigInteger, other.testBigInteger)
        && Objects.equals(testDoubleBigDecimal, other.testDoubleBigDecimal)
        && Objects.equals(testDuration, other.testDuration) && testEnum == other.testEnum
        && Objects.equals(testInstant, other.testInstant) && testIntEnum == other.testIntEnum
        && Objects.equals(testLocalDate, other.testLocalDate)
        && Objects.equals(testLocalDateTime, other.testLocalDateTime)
        && Objects.equals(testLocalTime, other.testLocalTime)
        && Objects.equals(testOffsetDateTime, other.testOffsetDateTime)
        && Objects.equals(testOffsetTime, other.testOffsetTime) && testStrEnum == other.testStrEnum
        && Objects.equals(testUuid, other.testUuid)
        && Objects.equals(testZonedDateTime, other.testZonedDateTime);
  }

}
