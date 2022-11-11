package com.crenjoy.proto.beanutils.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

/**
 * 时间转换扩展.
 *
 * @author CGD
 *
 */
public class DateTimeConverterTest {

  private Log log = LogFactory.getLog(DateTimeConverterTest.class);

  /**
   * 测试Parse大小写敏感.
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
    String instantStr = (String) ProtoConvertUtils.convert(instant, String.class);
    log.info("Instant: " + instantStr);
    assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant), instantStr);

    // parse Instant
    Instant instantParsed = (Instant) ProtoConvertUtils.convert(instantStr, Instant.class);
    assertEquals(instant, instantParsed);
  }

  @Test
  public void testParseLocalDateTime() {
    // java.time.LocalDateTime
    LocalDateTime datetime = LocalDateTime.now();
    String datetimeStr = (String) ProtoConvertUtils.convert(datetime, String.class);
    log.info("LocalDateTime: " + datetimeStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(datetime), datetimeStr);

    // parse LocalDateTime
    LocalDateTime datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert(datetimeStr,
        LocalDateTime.class);
    assertEquals(datetime, datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022-10-24 16:56:39.203",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56, 39, 203000000), datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022-10-24 16:56:39",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56, 39), datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022/10/24 16:56:00",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56), datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022-10-24 16:00",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 00), datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022/10/24 16:56",
        LocalDateTime.class);
    assertEquals(LocalDateTime.of(2022, 10, 24, 16, 56), datetimeParsed);

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022-10-24", LocalDateTime.class);
    assertEquals(LocalDate.of(2022, 10, 24), datetimeParsed.toLocalDate());

    datetimeParsed = (LocalDateTime) ProtoConvertUtils.convert("2022/10/24", LocalDateTime.class);
    assertEquals(LocalDate.of(2022, 10, 24), datetimeParsed.toLocalDate());
  }

  @Test
  public void testParseLocalDate() {
    // java.time.LocalDate
    LocalDate localDate = LocalDate.now();
    String dateStr = (String) ProtoConvertUtils.convert(localDate, String.class);
    log.info("LocalDate: " + dateStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate), dateStr);

    // parse LocalDate
    LocalDate dateParsed = (LocalDate) ProtoConvertUtils.convert(dateStr, LocalDate.class);
    assertEquals(dateParsed, dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022-10-24", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022/10/24", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022年10月24日", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 24), dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022-10", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022/10", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

    dateParsed = (LocalDate) ProtoConvertUtils.convert("2022年10月", LocalDate.class);
    assertEquals(LocalDate.of(2022, 10, 1), dateParsed);

  }

  @Test
  public void testParseLocalTime() {
    // java.time.LocalTime
    LocalTime localTime = LocalTime.now();
    String localTimeStr = (String) ProtoConvertUtils.convert(localTime, String.class);
    log.info("LocalTime: " + localTimeStr);
    assertEquals(DateTimeFormatter.ISO_LOCAL_TIME.format(localTime), localTimeStr);

    // parse LocalTime
    LocalTime dateParsed = (LocalTime) ProtoConvertUtils.convert(localTimeStr, LocalTime.class);
    assertEquals(dateParsed, dateParsed);

    dateParsed = (LocalTime) ProtoConvertUtils.convert("22:40:46.107", LocalTime.class);
    assertEquals(LocalTime.of(22, 40, 46, 107000000), dateParsed);

    dateParsed = (LocalTime) ProtoConvertUtils.convert("22:40:46", LocalTime.class);
    assertEquals(LocalTime.of(22, 40, 46), dateParsed);

    dateParsed = (LocalTime) ProtoConvertUtils.convert("22:40", LocalTime.class);
    assertEquals(LocalTime.of(22, 40), dateParsed);
  }

  @Test
  public void testParseZonedDateTime() {
    // java.time.ZonedDateTime
    ZonedDateTime zonedDt = ZonedDateTime.now();
    String zonedDtStr = (String) ProtoConvertUtils.convert(zonedDt, String.class);
    log.info("ZonedDateTime: " + zonedDtStr);
    assertEquals(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDt), zonedDtStr);

    // parse ZonedDateTime
    ZonedDateTime dateParsed = (ZonedDateTime) ProtoConvertUtils.convert(zonedDtStr,
        ZonedDateTime.class);
    assertEquals(dateParsed, dateParsed);

  }

  @Test
  public void testParseOffsetDateTime() {
    // java.time.OffsetDateTime
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    String offsetDateTimeStr = (String) ProtoConvertUtils.convert(offsetDateTime, String.class);
    log.info("OffsetDateTime: " + offsetDateTimeStr);
    assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime), offsetDateTimeStr);

    // parse OffsetDateTime
    OffsetDateTime dateParsed = (OffsetDateTime) ProtoConvertUtils.convert(offsetDateTimeStr,
        OffsetDateTime.class);
    assertEquals(dateParsed, dateParsed);
  }

  @Test
  public void testParseOffsetTime() {
    // java.time.OffsetTime
    OffsetTime offsetTime = OffsetTime.now();
    String offsetTimeStr = (String) ProtoConvertUtils.convert(offsetTime, String.class);
    log.info("OffsetTime: " + offsetTimeStr);
    assertEquals(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime), offsetTimeStr);

    // parse OffsetTime
    OffsetTime dateParsed = (OffsetTime) ProtoConvertUtils.convert(offsetTimeStr, OffsetTime.class);
    assertEquals(dateParsed, dateParsed);
  }

  /**
   * 日期类型默认通过ConvertUtils转换为String检查是否一致.
   */
  @Test
  public void testConvertString() throws IllegalAccessException, InvocationTargetException {
    // java.time.Instant

    Instant instant = Instant.now();
    assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant),
        ProtoConvertUtils.convert(instant, String.class));
    log.info("Instant: " + ProtoConvertUtils.convert(instant, String.class));

    // java.time.LocalDateTime
    LocalDateTime datetime = LocalDateTime.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(datetime),
        ProtoConvertUtils.convert(datetime, String.class));
    log.info("LocalDateTime: " + ProtoConvertUtils.convert(datetime, String.class));

    // java.time.LocalDate
    LocalDate localDate = LocalDate.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_DATE.format(localDate),
        ProtoConvertUtils.convert(localDate, String.class));
    log.info("LocalDate: " + ProtoConvertUtils.convert(localDate, String.class));

    // java.time.LocalTime
    LocalTime localTime = LocalTime.now();
    assertEquals(DateTimeFormatter.ISO_LOCAL_TIME.format(localTime),
        ProtoConvertUtils.convert(localTime, String.class));
    log.info("LocalTime: " + ProtoConvertUtils.convert(localTime, String.class));

    // java.time.ZonedDateTime
    ZonedDateTime zonedDt = ZonedDateTime.now();
    assertEquals(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(zonedDt),
        ProtoConvertUtils.convert(zonedDt, String.class));
    log.info("ZonedDateTime: " + ProtoConvertUtils.convert(zonedDt, String.class));

    // java.time.OffsetDateTime
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime),
        ProtoConvertUtils.convert(offsetDateTime, String.class));
    log.info("OffsetDateTime: " + ProtoConvertUtils.convert(offsetDateTime, String.class));

    // java.time.OffsetTime
    OffsetTime offsetTime = OffsetTime.now();
    assertEquals(DateTimeFormatter.ISO_OFFSET_TIME.format(offsetTime),
        ProtoConvertUtils.convert(offsetTime, String.class));
    log.info("OffsetTime: " + ProtoConvertUtils.convert(offsetTime, String.class));

  }

}
