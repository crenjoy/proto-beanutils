
package com.crenjoy.proto.mapper;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;

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
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

/**
 * target POJO Bean.
 *
 * @author CGD
 *
 */
//@Mapper(collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface BeanMapper {
  /**
   * ByteString To byte[].
   */
  default byte[] toByteArray(ByteString value) {
    return ProtoConvertUtils.convert(value, byte[].class);
  }

  /** ProtocolStringList is List String SubClass. */
  default List<String> toListString(ProtocolStringList value) {
    return (List<String>) value;
  }
  
  /** String to BigDecimal.  */
  default BigDecimal toBigDecimal(String value) {
    if (StringUtils.isBlank(value)) {
      return null;
    }
    return ProtoConvertUtils.convert(value, BigDecimal.class);
  }
  
  /** String to BigInteger.  */
  default BigInteger toBigInteger(String value) {
    if (StringUtils.isBlank(value)) {
      return null;
    }
    return ProtoConvertUtils.convert(value, BigInteger.class);
  }
  
  /** String to UUID .  */
  default UUID toUUID(String value) {
    if (StringUtils.isBlank(value)) {
      return null;
    }
    return ProtoConvertUtils.convert(value, UUID.class);
  }

  // ------------- Date Convert ---------------  
  default LocalDateTime toLocalDateTime(Object value) {
    return ProtoConvertUtils.convert(value, LocalDateTime.class);
  }
  
  default LocalDate toLocalDate(Object value) {
    return ProtoConvertUtils.convert(value, LocalDate.class);
  }
  
  default LocalTime toLocalTime(Object value) {
    return ProtoConvertUtils.convert(value, LocalTime.class);
  }
  
  default Instant toInstant(Object value) {
    return ProtoConvertUtils.convert(value, Instant.class);
  }
  
  default Duration toDuration(Object value) {
    return ProtoConvertUtils.convert(value, Duration.class);
  }
  
  default OffsetDateTime toOffsetDateTime(Object value) {
    return ProtoConvertUtils.convert(value, OffsetDateTime.class);
  }

  default OffsetTime toOffsetTime(Object value) {
    return ProtoConvertUtils.convert(value, OffsetTime.class);
  }
  
  default ZonedDateTime toZonedDateTime(Object value) {
    return ProtoConvertUtils.convert(value, ZonedDateTime.class);
  }
 
}
