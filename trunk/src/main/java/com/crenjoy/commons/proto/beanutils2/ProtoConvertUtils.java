package com.crenjoy.commons.proto.beanutils2;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.beanutils2.converters.BigDecimalConverter;
import org.apache.commons.beanutils2.converters.InstantConverter;
import org.apache.commons.beanutils2.converters.LocalDateConverter;
import org.apache.commons.beanutils2.converters.LocalDateTimeConverter;
import org.apache.commons.beanutils2.converters.OffsetDateTimeConverter;
import org.apache.commons.beanutils2.converters.ZonedDateTimeConverter;

/**
 * ProtoConvert
 * 
 * @author CGD
 *
 */
public class ProtoConvertUtils extends ConvertUtils {

  public static void init() {
    initLocale();
    initBigDecimal();
    initDateConverter();
  }

  public static void initLocale() {
    Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
    final TimeZone timeZone = TimeZone.getTimeZone("GTM+8");
    TimeZone.setDefault(timeZone);
  }

  public static void initBigDecimal() {
    BigDecimalConverter db = new BigDecimalConverter(BigDecimal.ZERO);
    ConvertUtils.register(db, java.math.BigDecimal.class);
  }

  public static void initDateConverter() {
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

}
