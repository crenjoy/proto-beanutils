package com.crenjoy.commons.beanutils2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.Constants;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.beanutils2.converters.InstantConverter;
import org.apache.commons.beanutils2.converters.LocalDateConverter;
import org.apache.commons.beanutils2.converters.LocalDateTimeConverter;
import org.apache.commons.beanutils2.converters.OffsetDateTimeConverter;
import org.apache.commons.beanutils2.converters.ZonedDateTimeConverter;
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
public class DateTimeStrTest {

  private Log log = LogFactory.getLog(DateTimeStrTest.class);

  @BeforeAll
  public static void register() {
    InstantConverter c1 = new InstantConverter();
    c1.setZoneId(ZoneId.of("+0"));
    c1.setPatterns(Constants.getInstant());
    ConvertUtils.register(c1, Instant.class);

    LocalDateTimeConverter c2 = new LocalDateTimeConverter();
    c2.setPatterns(Constants.getLocalDateTime());
    ConvertUtils.register(c2, LocalDateTime.class);

    LocalDateConverter c3 = new LocalDateConverter();
    c3.setPatterns(Constants.getLocalDate());
    ConvertUtils.register(c3, LocalDate.class);

    ZonedDateTimeConverter c4 = new ZonedDateTimeConverter();
    c4.setPatterns(Constants.getZonedDateTime());
    ConvertUtils.register(c4, ZonedDateTime.class);

    OffsetDateTimeConverter c5 = new OffsetDateTimeConverter();
    c5.setPatterns(Constants.getOffsetDateTime());
    ConvertUtils.register(c5, OffsetDateTime.class);
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
    // assertEquals(instant.toString(), instantStr);

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
    // assertEquals(datetime.toString(), datetimeStr);

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
    assertEquals(localDate.toString(), dateStr);

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
    assertEquals(localTime.toString(), localTimeStr);

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
    // assertEquals(zonedDt.toString(), zonedDtStr);

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
    // assertEquals(offsetDateTime.toString(), offsetDateTimeStr);

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
    assertEquals(offsetTime.toString(), offsetTimeStr);

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

    // java.util.Date
    Date date = new Date();
    assertEquals(date.toString(), ConvertUtils.convert(date));
    log.info("Date: " + ConvertUtils.convert(date));

    // Calendar
    Calendar cal = Calendar.getInstance();
    assertEquals(cal.toString(), ConvertUtils.convert(cal));
    log.info("Calendar: " + ConvertUtils.convert(cal));

    // java.sql.Date
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    assertEquals(sqlDate.toString(), ConvertUtils.convert(sqlDate));
    log.info("SqlDate: " + ConvertUtils.convert(sqlDate));

    // java.sql.Time
    java.sql.Time sqlTime = new java.sql.Time(date.getTime());
    assertEquals(sqlTime.toString(), ConvertUtils.convert(sqlTime));
    log.info("SqlTime: " + ConvertUtils.convert(sqlTime));

    // java.sql.timestamp
    java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
    assertEquals(timestamp.toString(), ConvertUtils.convert(timestamp));
    log.info("Timestamp: " + ConvertUtils.convert(timestamp));

    // java.time.Instant
    Instant instant = Instant.now();
    assertEquals(instant.toString(), ConvertUtils.convert(instant));
    log.info("Instant: " + ConvertUtils.convert(instant));

    // java.time.LocalDateTime
    LocalDateTime datetime = LocalDateTime.now();
    assertEquals(datetime.toString(), ConvertUtils.convert(datetime));
    log.info("LocalDateTime: " + ConvertUtils.convert(datetime));

    // java.time.LocalDate
    LocalDate localDate = LocalDate.now();
    assertEquals(localDate.toString(), ConvertUtils.convert(localDate));
    log.info("LocalDate: " + ConvertUtils.convert(localDate));

    // java.time.LocalTime
    LocalTime localTime = LocalTime.now();
    assertEquals(localTime.toString(), ConvertUtils.convert(localTime));
    log.info("LocalTime: " + ConvertUtils.convert(localTime));

    // java.time.ZonedDateTime
    ZonedDateTime zonedDt = ZonedDateTime.now();
    assertEquals(zonedDt.toString(), ConvertUtils.convert(zonedDt));
    log.info("ZonedDateTime: " + ConvertUtils.convert(zonedDt));

    // java.time.OffsetDateTime
    OffsetDateTime offsetDateTime = OffsetDateTime.now();
    assertEquals(offsetDateTime.toString(), ConvertUtils.convert(offsetDateTime));
    log.info("OffsetDateTime: " + ConvertUtils.convert(offsetDateTime));

  }

}
