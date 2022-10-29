
package com.crenjoy.proto.beanutils.converters.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.google.protobuf.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TimestampConverter Test.
 *
 * @author CGD
 *
 */
public class TimestampConverterTest {

  private Log log = LogFactory.getLog(DateTimeConverterTest.class);

  @Test
  public void testParseTimestamp() {
    // com.google.protobuf.Timestamp
    Instant instant = Instant.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano()).build();

    String timestampStr = (String) ProtoConvertUtils.convert(timestamp, String.class);
    log.info("Timestamp: " + timestampStr);
    Assertions.assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant), timestampStr);

    // parse Timestamp
    Timestamp timestampParsed = (Timestamp) ProtoConvertUtils.convert(timestampStr,
        Timestamp.class);
    Assertions.assertEquals(timestamp, timestampParsed);
  }

  @Test
  public void testFromZonedDateTime() {
    ZonedDateTime zdt1 = ZonedDateTime.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(zdt1.toInstant().getEpochSecond())
        .setNanos(zdt1.toInstant().getNano()).build();

    Timestamp zdt = (Timestamp) ProtoConvertUtils.convert(zdt1, Timestamp.class);
    Assertions.assertEquals(timestamp, zdt);
  }

  @Test
  public void testToZonedDateTime() {
    // com.google.protobuf.Timestamp
    Instant instant = Instant.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano()).build();
    // Timestamp to ZonedDateTime
    ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
    ZonedDateTime zdt2 = (ZonedDateTime) ProtoConvertUtils.convert(timestamp, ZonedDateTime.class);
    Assertions.assertEquals(zdt, zdt2);
    log.info("ZonedDateTime: " + zdt);
  }

  @Test
  public void testFromDate() {
    Date date = new Date();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond())
        .setNanos(date.toInstant().getNano()).build();

    Timestamp zdt = (Timestamp) ProtoConvertUtils.convert(date, Timestamp.class);
    Assertions.assertEquals(timestamp, zdt);
  }

  @Test
  public void testToDate() {
    Date date = new Date();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(date.toInstant().getEpochSecond())
        .setNanos(date.toInstant().getNano()).build();

    Date zdt = (Date) ProtoConvertUtils.convert(timestamp, Date.class);
    Assertions.assertEquals(date, zdt);
  }

}
