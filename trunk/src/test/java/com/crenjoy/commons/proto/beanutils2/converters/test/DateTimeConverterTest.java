package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 时间转换扩展
 *
 * @author CGD
 *
 */
public class DateTimeConverterTest {

  private Log log = LogFactory.getLog(DateTimeConverterTest.class);

  @BeforeAll
  public static void register() {
    ProtoConvertUtils.init();
  }

  /**
   * 测试Parse大小写敏感
   */
  @Test
  public void testCaseSensitive() {
    DateTimeFormatter dtf = new DateTimeFormatterBuilder().parseCaseInsensitive()
        .appendLocalized(null, FormatStyle.SHORT).toFormatter().withLocale(Locale.US);
    LocalTime lt = LocalTime.parse("11:44 am", dtf);
    log.info("LocalTime: " + lt);
  }

  @Test
  public void testParseInstant() {
    // java.time.Instant
    Instant instant = Instant.now();
    String instantStr = (String) ConvertUtils.convert(instant, String.class);
    log.info("Instant: " + instantStr);
    assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant), instantStr);

    // parse Instant
    Instant instantParsed = (Instant) ConvertUtils.convert(instantStr, Instant.class);
    assertEquals(instant, instantParsed);
  }

  @Test
  public void testParseLocalDateTime() {
    // java.time.LocalDateTime
    LocalDateTime datetime = LocalDateTime.now();
    String datetimeStr = (String) ConvertUtils.convert(datetime, String.class);
    log.info("LocalDateTime: " + datetimeStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(datetime), datetimeStr);

    // parse LocalDateTime
    LocalDateTime datetimeParsed = (LocalDateTime) ConvertUtils.convert(datetimeStr,
        LocalDateTime.class);
    assertEquals(datetime, datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022-10-24 16:56:39.203",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56, 39, 203000000), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022-10-24 16:56:39",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56, 39), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022/10/24 16:56:00",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022-10-24 16:00", LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 00), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022/10/24 16:56", LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022-10-24", LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 0, 0), datetimeParsed);

    datetimeParsed = (LocalDateTime) ConvertUtils.convert("2022/10/24", LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 0, 0), datetimeParsed);
  }

  @Test
  public void testParseLocalDate() {
    // java.time.LocalDate
    LocalDate localDate = LocalDate.now();
    String dateStr = (String) ConvertUtils.convert(localDate, String.class);
    log.info("LocalDate: " + dateStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate), dateStr);

    // parse LocalDate
    LocalDate dateParsed = (LocalDate) ConvertUtils.convert(dateStr, LocalDate.class);
    assertEquals(dateParsed, dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022-10-24", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022/10/24", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022年10月24日", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022-10", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022/10", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

    dateParsed = (LocalDate) ConvertUtils.convert("2022年10月", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

  }

  @Test
  public void testParseLocalTime() {
    // java.time.LocalTime
    LocalTime localTime = LocalTime.now();
    String localTimeStr = (String) ConvertUtils.convert(localTime, String.class);
    log.info("LocalTime: " + localTimeStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_TIME.format(localTime), localTimeStr);

    // parse LocalTime
    LocalTime dateParsed = (LocalTime) ConvertUtils.convert(localTimeStr, LocalTime.class);
    assertEquals(dateParsed, dateParsed);

    dateParsed = (LocalTime) ConvertUtils.convert("22:40:46.107", LocalTime.class);
    assertEquals(LocalTime.of(22, 40, 46, 107000000), dateParsed);

    dateParsed = (LocalTime) ConvertUtils.convert("22:40:46", LocalTime.class);
    assertEquals(LocalTime.of(22, 40, 46), dateParsed);

    dateParsed = (LocalTime) ConvertUtils.convert("22:40", LocalTime.class);
    assertEquals(LocalTime.of(22, 40), dateParsed);
  }

  @Test
  public void testParseZonedDateTime() {
    // java.time.ZonedDateTime
    ZonedDateTime zonedDt = ZonedDateTime.now();
    String zonedDtStr = (String) ConvertUtils.convert(zonedDt, String.class);
    log.info("ZonedDateTime: " + zonedDtStr);
    assertEquals(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDt), zonedDtStr);

    // parse ZonedDateTime
    ZonedDateTime dateParsed = (ZonedDateTime) ConvertUtils.convert(zonedDtStr,
        ZonedDateTime.class);
    assertEquals(dateParsed, dateParsed);

  }

  @Test
  public void testParseOffsetDateTime() {
    // java.time.OffsetDateTime
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    String offsetDateTimeStr = (String) ConvertUtils.convert(offsetDateTime, String.class);
    log.info("OffsetDateTime: " + offsetDateTimeStr);
    assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime), offsetDateTimeStr);

    // parse OffsetDateTime
    OffsetDateTime dateParsed = (OffsetDateTime) ConvertUtils.convert(offsetDateTimeStr,
        OffsetDateTime.class);
    assertEquals(dateParsed, dateParsed);
  }

  @Test
  public void testParseOffsetTime() {
    // java.time.OffsetTime
    OffsetTime offsetTime = OffsetTime.now();
    String offsetTimeStr = (String) ConvertUtils.convert(offsetTime, String.class);
    log.info("OffsetTime: " + offsetTimeStr);
    assertEquals(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime), offsetTimeStr);

    // parse OffsetTime
    OffsetTime dateParsed = (OffsetTime) ConvertUtils.convert(offsetTimeStr, OffsetTime.class);
    assertEquals(dateParsed, dateParsed);
  }

  /**
   * 日期类型默认通过ConvertUtils转换为String检查是否一致
   * 
   * @throws IllegalAccessException
   * @throws InvocationTargetException
   */
  @Test
  public void testConvertString() throws IllegalAccessException, InvocationTargetException {
    // java.time.Instant

    Instant instant = Instant.now();
    assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant),
        ConvertUtils.convert(instant, String.class));
    log.info("Instant: " + ConvertUtils.convert(instant, String.class));

    // java.time.LocalDateTime
    LocalDateTime datetime = LocalDateTime.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(datetime),
        ConvertUtils.convert(datetime, String.class));
    log.info("LocalDateTime: " + ConvertUtils.convert(datetime, String.class));

    // java.time.LocalDate
    LocalDate localDate = LocalDate.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate),
        ConvertUtils.convert(localDate, String.class));
    log.info("LocalDate: " + ConvertUtils.convert(localDate, String.class));

    // java.time.LocalTime
    LocalTime localTime = LocalTime.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_TIME.format(localTime),
        ConvertUtils.convert(localTime, String.class));
    log.info("LocalTime: " + ConvertUtils.convert(localTime, String.class));

    // java.time.ZonedDateTime
    ZonedDateTime zonedDt = ZonedDateTime.now();
    assertEquals(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDt),
        ConvertUtils.convert(zonedDt, String.class));
    log.info("ZonedDateTime: " + ConvertUtils.convert(zonedDt, String.class));

    // java.time.OffsetDateTime
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime),
        ConvertUtils.convert(offsetDateTime, String.class));
    log.info("OffsetDateTime: " + ConvertUtils.convert(offsetDateTime, String.class));

    // java.time.OffsetTime
    OffsetTime offsetTime = OffsetTime.now();
    assertEquals(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime),
        ConvertUtils.convert(offsetTime, String.class));
    log.info("OffsetTime: " + ConvertUtils.convert(offsetTime, String.class));

  }

}
