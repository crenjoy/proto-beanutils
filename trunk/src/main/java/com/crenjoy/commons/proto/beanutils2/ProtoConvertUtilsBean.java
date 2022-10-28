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

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.BigDecimalConverter;

/**
 * Proto ConvertUtilsBean.
 *
 * @author CGD
 *
 */
public class ProtoConvertUtilsBean extends ConvertUtilsBean {

  /**
   * Get singleton instance
   * 
   * @return The singleton instance
   */
  protected static ProtoConvertUtilsBean getInstance() {
    return (ProtoConvertUtilsBean) ProtoBeanUtilsBean.getInstance().getConvertUtils();
  }

  @Override
  public void deregister() {
    super.deregister();
    registerDateTime();
    registerOther();
  }

  /**
   * Register DateTime
   */
  protected void registerDateTime() {
    register(new InstantConverter(), Instant.class);
    register(new LocalDateConverter(), LocalDate.class);
    register(new LocalDateTimeConverter(), LocalDateTime.class);
    register(new LocalTimeConverter(), LocalTime.class);
    register(new OffsetDateTimeConverter(), OffsetDateTime.class);
    register(new OffsetTimeConverter(), OffsetTime.class);
    register(new TimestampConverter(), Timestamp.class);
    register(new ZonedDateTimeConverter(), ZonedDateTime.class);
  }

  /**
   * Register Other
   */
  protected void registerOther() {
    BigDecimalConverter db = new BigDecimalConverter(BigDecimal.ZERO);
    register(db, BigDecimal.class);
    // Enum <-> String/Integer
    register(new EnumConverter<>(), Enum.class);
    // ByteString <-> byte[]
    register(new ByteStringConverter(), ByteString.class);
    register(new ByteArrayConverter(), byte[].class);
    // Time Duration <-> Proto Duration
    register(new DurationConverter(), java.time.Duration.class);
    register(new DurationProtoConverter(), com.google.protobuf.Duration.class);
  }

  @Override
  public Converter lookup(Class<?> clazz) {
    // Enum Converter
    if (null != clazz && clazz.isEnum()) {
      return (Converter) lookup(Enum.class);
    }
    return super.lookup(clazz);
  }

  @Override
  public Converter lookup(Class<?> sourceType, Class<?> targetType) {
    // Enum Converter
    if (null != sourceType && sourceType.isEnum()) {
      return (Converter) lookup(Enum.class);
    }
    if (null != targetType && targetType.isEnum()) {
      return (Converter) lookup(Enum.class);
    }
    return super.lookup(sourceType, targetType);
  }

}
