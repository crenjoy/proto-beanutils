package com.crenjoy.proto.beanutils;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;

import java.text.ParsePosition;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;

import org.apache.commons.beanutils.ConversionException;

/**
 * Date Time Format Parse Text.
 *
 * @author CGD
 *
 */
public class DateTimeParse {

  public static DateTimeFormatter[] getInstantFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_INSTANT };
  }

  public static DateTimeFormatter[] getZonedDateTimeFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_ZONED_DATE_TIME };
  }

  public static DateTimeFormatter[] getOffsetDateTimeFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_OFFSET_DATE_TIME };
  }

  public static DateTimeFormatter[] getOffsetTimeFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_OFFSET_TIME };
  }

  public static DateTimeFormatter[] getLocalDateTimeFormatters() {
    DateTimeFormatter[] patterns = new DateTimeFormatter[] { DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"),
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss SSS"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm") };
    return new ArrayBuilder<DateTimeFormatter>(patterns).concat(getLocalDateFormatters())
        .builder(new DateTimeFormatter[0]);
  }

  public static DateTimeFormatter[] getLocalDateFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_LOCAL_DATE,
        DateTimeFormatter.ofPattern("yyyy/MM/dd"), DateTimeFormatter.ofPattern("yyyy年MM月dd日"),
        DateTimeFormatter.ofPattern("yyyy-MM"), DateTimeFormatter.ofPattern("yyyy/MM"),
        DateTimeFormatter.ofPattern("yyyy年MM月") };
  }

  public static DateTimeFormatter[] getLocalTimeFormatters() {
    return new DateTimeFormatter[] { DateTimeFormatter.ISO_LOCAL_TIME,
        DateTimeFormatter.ofPattern("HH:mm:ss.SSS"), DateTimeFormatter.ofPattern("HH:mm:ss"),
        DateTimeFormatter.ofPattern("HH:mm") };
  }

  /**
   * Text Parse DateTime.
   * <ul>
   * <li>{@code java.time.ZonedDateTime}</li>
   * <li>{@code java.time.OffsetDateTime}</li>
   * <li>{@code java.time.OffsetTime}</li>
   * <li>{@code java.time.Instant}</li>
   * <li>{@code java.time.LocalDateTime}</li>
   * <li>{@code java.time.LocalDate}</li>
   * <li>{@code java.time.LocalTime}</li>
   * </ul>
   * 
   * @param value  text
   * @param format DateTimeFormatter
   * @return DateTime.
   */
  public static TemporalAccessor parse(final String value, final DateTimeFormatter format) {
    final ParsePosition pos = new ParsePosition(0);
    final TemporalAccessor parsedDate = format.parse(value, pos);
    if (pos.getErrorIndex() >= 0 || pos.getIndex() != value.length() || parsedDate == null) {
      String msg = "Error converting '" + value + "' using Formatter '" + format + "'";
      throw new ConversionException(msg);
    }

    TemporalAccessor temporal = fromZonedDateTime(parsedDate);
    if (null == temporal) {
      temporal = fromOffsetDateTime(parsedDate);
    }
    if (null == temporal) {
      temporal = fromOffsetTime(parsedDate);
    }
    if (null == temporal) {
      temporal = fromLocalDateTime(parsedDate);
    }
    if (null == temporal) {
      temporal = fromLocalDate(parsedDate);
    }
    if (null == temporal) {
      temporal = fromLocalTime(parsedDate);
    }
    if (null == temporal) {
      temporal = fromInstant(parsedDate);
    }
    if (null == temporal) {
      // parse yyyy-MM.
      LocalDate ldt = LocalDate.of(1970, 1, 1);
      if (parsedDate.isSupported(ChronoField.YEAR)) {
        ldt = ldt.withYear(parsedDate.get(ChronoField.YEAR));
      }
      if (parsedDate.isSupported(ChronoField.MONTH_OF_YEAR)) {
        ldt = ldt.withMonth(parsedDate.get(ChronoField.MONTH_OF_YEAR));
      }
      return ldt;
    }

    return temporal;
  }

  /**
   * ZonedDateTime.from(temporal).
   */
  public static ZonedDateTime fromZonedDateTime(TemporalAccessor temporal) {
    if (checkZonedDateTime(temporal)) {
      return ZonedDateTime.from(temporal);
    }
    return null;
  }

  /**
   * Check ZonedDateTime from TemporalAccessor.
   */
  public static boolean checkZonedDateTime(TemporalAccessor temporal) {
    if (temporal instanceof ZonedDateTime) {
      return true;
    }
    if (temporal.query(TemporalQueries.zone()) == null) {
      return false;
    }
    if (temporal.isSupported(INSTANT_SECONDS)) {
      return true;
    }
    return checkLocalDateTime(temporal);
  }

  /**
   * OffsetDateTime.from(temporal).
   */
  public static OffsetDateTime fromOffsetDateTime(TemporalAccessor temporal) {
    if (checkOffsetDateTime(temporal)) {
      return OffsetDateTime.from(temporal);
    }
    return null;
  }

  /**
   * Check OffsetDateTime from TemporalAccessor.
   */
  public static boolean checkOffsetDateTime(TemporalAccessor temporal) {
    if (temporal instanceof OffsetDateTime) {
      return true;
    }
    if (temporal.query(TemporalQueries.offset()) == null) {
      return false;
    }
    if (temporal.isSupported(INSTANT_SECONDS)) {
      return true;
    }
    return checkLocalDateTime(temporal);
  }

  /**
   * OffsetTime.from(temporal).
   */
  public static OffsetTime fromOffsetTime(TemporalAccessor temporal) {
    if (checkOffsetTime(temporal)) {
      return OffsetTime.from(temporal);
    }
    return null;
  }

  /**
   * Check OffsetTime from TemporalAccessor.
   */
  public static boolean checkOffsetTime(TemporalAccessor temporal) {
    if (temporal instanceof OffsetTime) {
      return true;
    }
    if (temporal.query(TemporalQueries.offset()) == null) {
      return false;
    }
    if (temporal.query(TemporalQueries.localDate()) != null) {
      return false;
    }
    if (temporal.query(TemporalQueries.localTime()) == null) {
      return false;
    }
    return true;
  }

  /**
   * LocalDateTime.from(temporal).
   */
  public static LocalDateTime fromLocalDateTime(TemporalAccessor temporal) {
    if (checkLocalDateTime(temporal)) {
      return LocalDateTime.from(temporal);
    }
    return null;
  }

  /**
   * Check LocalDateTime from TemporalAccessor.
   */
  public static boolean checkLocalDateTime(TemporalAccessor temporal) {
    if (temporal instanceof LocalDateTime) {
      return true;
    }
    if (temporal.query(TemporalQueries.localDate()) == null) {
      return false;
    }
    if (temporal.query(TemporalQueries.localTime()) == null) {
      return false;
    }
    return true;
  }

  /**
   * LocalDate.from(temporal).
   */
  public static LocalDate fromLocalDate(TemporalAccessor temporal) {
    if (checkLocalDate(temporal)) {
      return LocalDate.from(temporal);
    }
    return null;
  }

  /**
   * Check LocalDate from TemporalAccessor.
   */
  public static boolean checkLocalDate(TemporalAccessor temporal) {
    if (temporal instanceof LocalDate) {
      return true;
    }
    if (temporal.query(TemporalQueries.localDate()) == null) {
      return false;
    }
    if (temporal.query(TemporalQueries.localTime()) != null) {
      return false;
    }
    return true;
  }

  /**
   * LocalTime.from(temporal).
   */
  public static LocalTime fromLocalTime(TemporalAccessor temporal) {
    if (checkLocalTime(temporal)) {
      return LocalTime.from(temporal);
    }
    return null;
  }

  /**
   * Check LocalTime from TemporalAccessor.
   */
  public static boolean checkLocalTime(TemporalAccessor temporal) {
    if (temporal instanceof LocalTime) {
      return true;
    }
    if (temporal.query(TemporalQueries.localDate()) != null) {
      return false;
    }
    if (temporal.query(TemporalQueries.localTime()) == null) {
      return false;
    }
    return true;
  }

  /**
   * Instant.from(temporal).
   */
  public static Instant fromInstant(TemporalAccessor temporal) {
    if (checkInstant(temporal)) {
      return Instant.from(temporal);
    }
    return null;
  }

  /**
   * Check Instant from TemporalAccessor.
   */
  public static boolean checkInstant(TemporalAccessor temporal) {
    if (temporal instanceof Instant) {
      return true;
    }
    return temporal.isSupported(INSTANT_SECONDS);
  }

}
