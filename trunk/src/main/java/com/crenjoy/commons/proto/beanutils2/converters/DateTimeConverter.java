package com.crenjoy.commons.proto.beanutils2.converters;

import com.crenjoy.commons.proto.beanutils2.DateTimeParse;
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
import java.util.Locale;
import java.util.Objects;

import org.apache.commons.beanutils2.ConversionException;
import org.apache.commons.beanutils2.converters.AbstractConverter;
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
 * </ul>
 * 
 * @author CGD
 *
 * @param <D> The default value type.
 */
public abstract class DateTimeConverter<D> extends AbstractConverter<D> {

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
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle OffsetDateTime
    if (value instanceof OffsetDateTime) {
      final Instant temp = ((OffsetDateTime) value).toInstant();
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
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
      return toDate(targetType, temp.getEpochSecond(), temp.getNano());
    }

    // Handle Long
    if (value instanceof Long) {
      final Long longObj = (Long) value;
      return toDate(targetType, longObj.longValue());
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
   * DateTime to String
   */
  protected String convertToString(final Object value) {
    TemporalAccessor date = null;
    // com.google.protobuf.Timestamp
    if (value instanceof Timestamp) {
      final Timestamp timestamp = (Timestamp) value;
      date = toDate(Instant.class, timestamp.getSeconds(), timestamp.getNanos());
    } else {
      date = (TemporalAccessor) value;
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

  /**
   * Convert value By Seconds and Nanos.
   *
   * @param <T>     target value type
   * @param type    targetType
   * @param seconds 秒
   * @param nanos   纳秒
   * @return target value
   */
  private <T> T toDate(final Class<T> type, final long seconds, final int nanos) {
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
      final LocalDateTime localDateTime = instant.atZone(getZoneId()).toLocalDateTime();
      return type.cast(localDateTime);
    }

    // java.time.ZonedDateTime
    if (type.equals(ZonedDateTime.class)) {
      final ZonedDateTime zonedDateTime = instant.atZone(getZoneId());
      return type.cast(zonedDateTime);
    }

    // java.time.OffsetDateTime
    if (type.equals(OffsetDateTime.class)) {
      final OffsetDateTime offsetDateTime = instant.atZone(getZoneId()).toOffsetDateTime();
      return type.cast(offsetDateTime);
    }

    // java.time.LocalDate
    if (type.equals(LocalDate.class)) {
      final LocalDate localDate = instant.atZone(getZoneId()).toLocalDate();
      return type.cast(localDate);
    }

    // java.time.LocalTime
    if (type.equals(LocalTime.class)) {
      final LocalTime localTime = instant.atZone(getZoneId()).toLocalTime();
      return type.cast(localTime);
    }

    // java.time.OffsetTime
    if (type.equals(OffsetTime.class)) {
      final OffsetTime offsetTime = instant.atZone(getZoneId()).toOffsetDateTime().toOffsetTime();
      return type.cast(offsetTime);
    }

    final String msg = toString(getClass()) + " cannot handle conversion to '" + toString(type)
        + "'";
    if (getLog().isWarnEnabled()) {
      getLog().warn("    " + msg);
    }
    throw new ConversionException(msg);
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
