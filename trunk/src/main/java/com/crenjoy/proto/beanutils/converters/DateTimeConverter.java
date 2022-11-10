
package com.crenjoy.proto.beanutils.converters;

import com.crenjoy.proto.beanutils.DateTimeParse;
import com.google.protobuf.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.converters.AbstractConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Only Java8 New Date Time Converter.
 * <ul>
 * <li>{@code com.google.protobuf.Timestamp}</li>
 * <li>{@code java.time.Instant}</li>
 * <li>{@code java.time.LocalDateTime}</li>
 * <li>{@code java.time.ZonedDateTime}</li>
 * <li>{@code java.time.OffsetDateTime}</li>
 * <li>{@code java.time.LocalDate}</li>
 * <li>{@code java.time.LocalTime}</li>
 * <li>{@code java.time.OffsetTime}</li>
 * <li>{@code java.lang.Long}</li>
 * <li>{@code java.util.Date}</li>
 * <li>{@code java.util.Calendar}</li>
 * <li>{@code java.sql.Date}</li>
 * <li>{@code java.sql.Time}</li>
 * <li>{@code java.sql.Timestamp}</li>
 * </ul>
 *
 * @author CGD
 *
 * @param <D> The default value type.
 */
public abstract class DateTimeConverter<D> extends AbstractConverter {

  // DateTimeFormatter Thread Safely.
  private DateTimeFormatter[] formatters;
  private Locale locale;
  private ZoneId zoneId;

  private transient Log log;

  public DateTimeConverter() {
  }

  public DateTimeConverter(final D defaultValue) {
    super(defaultValue);
  }

  public DateTimeConverter(final D defaultValue, DateTimeFormatter[] formatters) {
    super(defaultValue);
    this.formatters = formatters;
  }

  @Override
  protected <R> R convertToType(final Class<R> targetType, final Object value) throws Throwable {
    final Class<?> sourceType = value.getClass();
    // Handle SubClass Type
    if (targetType.isAssignableFrom(sourceType)) {
      return targetType.cast(value);
    }

    // Handle Timestamp
    if (value instanceof Timestamp) {
      final Timestamp timestamp = (Timestamp) value;
      return toDate(targetType, timestamp.getSeconds(), timestamp.getNanos());
    }

    // Handle Instant
    if (value instanceof Instant) {
      final Instant temp = (Instant) value;
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle LocalDateTime
    if (value instanceof LocalDateTime) {
      final Instant temp = ((LocalDateTime) value).atZone(getZoneId()).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle ZonedDateTime
    if (value instanceof ZonedDateTime) {
      final Instant temp = ((ZonedDateTime) value).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano(),
          ((ZonedDateTime) value).getZone());
    }

    // Handle OffsetDateTime
    if (value instanceof OffsetDateTime) {
      final Instant temp = ((OffsetDateTime) value).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano(),
          ((OffsetDateTime) value).getOffset());
    }

    // Handle LocalDate
    if (value instanceof LocalDate) {
      final Instant temp = ((LocalDate) value).atStartOfDay(getZoneId()).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle LocalTime
    if (value instanceof LocalTime) {
      final Instant temp = ((LocalTime) value).atDate(LocalDate.of(1970, 1, 1)).atZone(getZoneId())
          .toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle LocalTime
    if (value instanceof OffsetTime) {
      final Instant temp = ((OffsetTime) value).atDate(LocalDate.of(1970, 1, 1)).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano(),
          ((OffsetTime) value).getOffset());
    }

    // Handle Long
    if (value instanceof Long) {
      final Long longObj = (Long) value;
      return toDate(targetType, longObj.longValue());
    }

    // Handle java.sql.Timestamp
    if (value instanceof java.sql.Timestamp) {
      final java.sql.Timestamp timestamp = (java.sql.Timestamp) value;
      return toDate(targetType, timestamp.getTime() / 1000, timestamp.getNanos());
    }

    // Handle Date (includes java.sql.Time)
    if (value instanceof Date) {
      final Date date = (Date) value;
      return toDate(targetType, date.getTime());
    }

    // Handle java.sql.Date
    if (value instanceof java.sql.Date) {
      final java.sql.Date date = (java.sql.Date) value;
      return toDate(targetType, date.getTime());
    }

    // Convert all other types to String & handle
    final String stringValue = toTrim(value);
    if (stringValue.isEmpty()) {
      return handleMissing(targetType);
    }

    // Parse the DateTime
    if (formatters != null && formatters.length > 0) {
      final TemporalAccessor temporalAccessor = parse(sourceType, targetType, stringValue);
      return convertToType(targetType, temporalAccessor);
    }

    final String msg = toString(getClass()) + " does not support default String to '"
        + toString(targetType) + "' conversion.";
    if (getLog().isWarnEnabled()) {
      getLog().warn("    " + msg);
      getLog().warn("    (N.B. Re-configure Converter or use alternative implementation)");
    }
    throw new ConversionException(msg);
  }

  private TemporalAccessor parse(final Class<?> sourceType, final Class<?> targetType,
      final String value) throws Exception {
    Exception firstEx = null;
    for (final DateTimeFormatter format : formatters) {
      try {
        final TemporalAccessor temporalAccessor = DateTimeParse.parse(value, format);
        return temporalAccessor;
      } catch (final Exception ex) {
        if (firstEx == null) {
          firstEx = ex;
        }
      }
    }
    if (formatters.length > 1) {
      throw new ConversionException(
          "Error converting '" + toString(sourceType) + "' to '" + toString(targetType) + "'");
    }
    throw firstEx;
  }

  /**
   * DateTime to String.
   */
  protected String convertToString(final Object value) {
    TemporalAccessor date = null;
    if (value instanceof Timestamp) {
      // com.google.protobuf.Timestamp.
      final Timestamp timestamp = (Timestamp) value;
      date = toDate(Instant.class, timestamp.getSeconds(), timestamp.getNanos());
    } else if (value instanceof TemporalAccessor) {
      // Instant、LocalDateTime、LocalDate、LocalTime、ZonedDateTime、OffsetDateTime、OffsetTime.
      date = (TemporalAccessor) value;
    } else {
      // Date、java.sql.Date、java.sql.Time、java.sql.Timestamp、Calendar.
      try {
        date = convertToType(LocalDateTime.class, value);
      } catch (Throwable e) {
        getLog().debug(value + " to LocalDateTime Error : ", e);
      }
    }

    String result = null;
    if (date != null && formatters != null && formatters.length > 0) {
      DateTimeFormatter format = formatters[0];
      result = format.format(date);
      if (getLog().isDebugEnabled()) {
        getLog().debug("    Converted  to String using format '" + result + "'");
      }
    } else {
      result = value.toString();
      if (getLog().isDebugEnabled()) {
        getLog().debug("    Converted  to String using toString() '" + result + "'");
      }
    }
    return result;
  }

  /**
   * Convert value By MilliSeconds.
   *
   * @param <T>          target value type
   * @param type         targetType
   * @param milliSeconds 毫秒
   * @return target value
   */
  private <T> T toDate(final Class<T> type, final long milliSeconds) {
    return toDate(type, milliSeconds / 1000,
        Long.valueOf(milliSeconds % 1000).intValue() * 1000000);
  }

  private <T> T toDate(final Class<T> type, final long seconds, final int nanos) {
    return toDate(type, seconds, nanos, getZoneId());
  }

  /**
   * Convert value By Seconds and Nanos.
   *
   * @param <T>     target value type
   * @param type    targetType
   * @param seconds 秒
   * @param nanos   纳秒
   * @return target value
   */
  private <T> T toDate(final Class<T> type, final long seconds, final int nanos,
      final ZoneId zoneId) {
    // com.google.protobuf.Timestamp
    if (type.equals(Timestamp.class)) {
      final Timestamp timestamp = Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos)
          .build();
      return type.cast(timestamp);
    }

    final Instant instant = Instant.ofEpochSecond(seconds, nanos);
    // java.time.Instant
    if (type.equals(Instant.class)) {
      return type.cast(instant);
    }

    // java.time.LocalDateTime
    if (type.equals(LocalDateTime.class)) {
      final LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
      return type.cast(localDateTime);
    }

    // java.time.ZonedDateTime
    if (type.equals(ZonedDateTime.class)) {
      final ZonedDateTime zonedDateTime = instant.atZone(zoneId);
      return type.cast(zonedDateTime);
    }

    // java.time.OffsetDateTime
    if (type.equals(OffsetDateTime.class)) {
      final OffsetDateTime offsetDateTime = instant.atZone(zoneId).toOffsetDateTime();
      return type.cast(offsetDateTime);
    }

    // java.time.LocalDate
    if (type.equals(LocalDate.class)) {
      final LocalDate localDate = instant.atZone(zoneId).toLocalDate();
      return type.cast(localDate);
    }

    // java.time.LocalTime
    if (type.equals(LocalTime.class)) {
      final LocalTime localTime = instant.atZone(zoneId).toLocalTime();
      return type.cast(localTime);
    }

    // java.time.OffsetTime
    if (type.equals(OffsetTime.class)) {
      final OffsetTime offsetTime = instant.atZone(zoneId).toOffsetDateTime().toOffsetTime();
      return type.cast(offsetTime);
    }

    // milliseconds
    long value = seconds * 1000 + nanos / 1000000;

    // java.util.Date
    if (type.equals(Date.class)) {
      return type.cast(new Date(value));
    }

    // java.sql.Date
    if (type.equals(java.sql.Date.class)) {
      return type.cast(new java.sql.Date(value));
    }

    // java.sql.Time
    if (type.equals(java.sql.Time.class)) {
      return type.cast(new java.sql.Time(value));
    }

    // java.sql.Timestamp
    if (type.equals(java.sql.Timestamp.class)) {
      java.sql.Timestamp stamp = new java.sql.Timestamp(seconds * 1000);
      stamp.setNanos(nanos);
      return type.cast(stamp);
    }

    final String msg = toString(getClass()) + " cannot handle conversion to '" + toString(type)
        + "'";
    if (getLog().isWarnEnabled()) {
      getLog().warn("    " + msg);
    }
    throw new ConversionException(msg);
  }

  /**
   * Converts the given object to a lower-case string.
   *
   * @param value the input string.
   * @return the given string trimmed and converter to lower-case.
   */
  protected static String toString(final Object value) {
    return Objects.requireNonNull(value, "value").toString();
  }

  /**
   * Converts the given object to a lower-case string.
   *
   * @param value the input string.
   * @return the given string trimmed and converter to lower-case.
   */
  protected static String toTrim(final Object value) {
    return toString(value).trim();
  }

  protected Log getLog() {
    if (log == null) {
      log = LogFactory.getLog(getClass());
    }
    return log;
  }

  public DateTimeFormatter[] getFormatters() {
    return formatters;
  }

  public void setFormatters(DateTimeFormatter[] formatters) {
    this.formatters = formatters;
  }

  public void setFormatter(DateTimeFormatter formatter) {
    Objects.requireNonNull(formatter);
    this.formatters = new DateTimeFormatter[] { formatter };
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public ZoneId getZoneId() {
    return zoneId == null ? ZoneId.systemDefault() : zoneId;
  }

  public void setZoneId(ZoneId zoneId) {
    this.zoneId = zoneId;
  }

}
