package com.crenjoy.commons.proto.beanutils2;

import com.crenjoy.commons.proto.beanutils2.converters.ByteArrayConverter;
import com.crenjoy.commons.proto.beanutils2.converters.ByteStringConverter;
import com.crenjoy.commons.proto.beanutils2.converters.DurationConverter;
import com.crenjoy.commons.proto.beanutils2.converters.DurationProtoConverter;
import com.crenjoy.commons.proto.beanutils2.converters.EnumConverter;
import com.crenjoy.commons.proto.beanutils2.converters.InstantConverter;
import com.crenjoy.commons.proto.beanutils2.converters.LocalDateConverter;
import com.crenjoy.commons.proto.beanutils2.converters.LocalDateTimeConverter;
import com.crenjoy.commons.proto.beanutils2.converters.LocalTimeConverter;
import com.crenjoy.commons.proto.beanutils2.converters.OffsetDateTimeConverter;
import com.crenjoy.commons.proto.beanutils2.converters.OffsetTimeConverter;
import com.crenjoy.commons.proto.beanutils2.converters.TimestampConverter;
import com.crenjoy.commons.proto.beanutils2.converters.ZonedDateTimeConverter;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.beanutils2.converters.BigDecimalConverter;

/**
 * ProtoConvert.
 * 
 * @author CGD
 *
 */
public class ProtoConvertUtils extends ConvertUtils {

  public static void init() {
    initLocale();
    initDateConverter();
    initOtherConverter();
  }

  public static void initLocale() {
    Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
    final TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
    TimeZone.setDefault(timeZone);
  }

  public static void initDateConverter() {
    ConvertUtils.register(new InstantConverter(), Instant.class);
    ConvertUtils.register(new LocalDateConverter(), LocalDate.class);
    ConvertUtils.register(new LocalDateTimeConverter(), LocalDateTime.class);
    ConvertUtils.register(new LocalTimeConverter(), LocalTime.class);
    ConvertUtils.register(new OffsetDateTimeConverter(), OffsetDateTime.class);
    ConvertUtils.register(new OffsetTimeConverter(), OffsetTime.class);
    ConvertUtils.register(new TimestampConverter(), Timestamp.class);
    ConvertUtils.register(new ZonedDateTimeConverter(), ZonedDateTime.class);
  }

  public static void initOtherConverter() {
    BigDecimalConverter db = new BigDecimalConverter(BigDecimal.ZERO);
    ConvertUtils.register(db, BigDecimal.class);
    // Enum <-> String/Integer
    ConvertUtils.register(new EnumConverter<>(), Enum.class);
    // ByteString <-> byte[]
    ConvertUtils.register(new ByteStringConverter(), ByteString.class);
    ConvertUtils.register(new ByteArrayConverter(), byte[].class);
    // Time Duration <-> Proto Duration
    ConvertUtils.register(new DurationConverter(), java.time.Duration.class);
    ConvertUtils.register(new DurationProtoConverter(), com.google.protobuf.Duration.class);
  }

}
