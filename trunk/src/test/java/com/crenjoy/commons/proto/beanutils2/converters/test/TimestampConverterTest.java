package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;
import com.google.protobuf.Timestamp;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * TimestampConverter Test.
 *
 * @author CGD
 *
 */
public class TimestampConverterTest {

  private Log log = LogFactory.getLog(DateTimeConverterTest.class);

  @BeforeAll
  public static void register() {
    ProtoConvertUtils.init();
  }

  @Test
  public void testParseTimestamp() {
    // com.google.protobuf.Timestamp
    Instant instant = Instant.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano()).build();

    String timestampStr = (String) ConvertUtils.convert(timestamp, String.class);
    log.info("Timestamp: " + timestampStr);
    assertEquals(DateTimeFormatter.ISO_INSTANT.format(instant), timestampStr);

    // parse Timestamp
    Timestamp timestampParsed = (Timestamp) ConvertUtils.convert(timestampStr, Timestamp.class);
    assertEquals(timestamp, timestampParsed);
  }
  
  @Test
  public void testFromZonedDateTime() {
    ZonedDateTime zdt1 = ZonedDateTime.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(zdt1.toInstant().getEpochSecond())
        .setNanos(zdt1.toInstant().getNano()).build();
    
    ZonedDateTime zdt =(ZonedDateTime) ConvertUtils.convert(timestamp, ZonedDateTime.class);
    assertEquals(zdt1, zdt);
  }

  @Test
  public void testToZonedDateTime() {
 // com.google.protobuf.Timestamp
    Instant instant = Instant.now();
    Timestamp timestamp = Timestamp.newBuilder().setSeconds(instant.getEpochSecond())
        .setNanos(instant.getNano()).build();
    // Timestamp to ZonedDateTime
    ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
    ZonedDateTime zdt2 = (ZonedDateTime) ConvertUtils.convert(timestamp, ZonedDateTime.class);
    assertEquals(zdt, zdt2);
    log.info("ZonedDateTime: " + zdt);
  }

}