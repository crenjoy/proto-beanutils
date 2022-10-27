package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.DurationUtils;
import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;
import com.crenjoy.commons.proto.beanutils2.converters.DurationConverter;
import com.crenjoy.commons.proto.beanutils2.converters.DurationProtoConverter;
import com.google.protobuf.util.Durations;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.beanutils2.Converter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * DurationConverter Test.
 *
 * @author CGD
 *
 */
public class DurationConverterTest {

  @BeforeAll
  public static void register() {
    ProtoConvertUtils.init();
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testDurationParse() {
    Converter c = ConvertUtils.lookup(String.class, java.time.Duration.class);
    assertEquals(c.getClass(), DurationConverter.class);

    java.time.Duration actual = DurationUtils.toTime(Durations.MAX_VALUE);
    java.time.Duration expected = (java.time.Duration) ConvertUtils
        .convert("PT87660000H0.999999999S", java.time.Duration.class);
    assertEquals(expected, actual);

    actual = DurationUtils.toTime(Durations.MIN_VALUE);
    expected = (java.time.Duration) ConvertUtils.convert("PT-87660000H-0.999999999S",
        java.time.Duration.class);
    assertEquals(expected, actual);

  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testProtoDurationParse() {
    Converter c = ConvertUtils.lookup(String.class, com.google.protobuf.Duration.class);
    assertEquals(c.getClass(), DurationProtoConverter.class);

    com.google.protobuf.Duration actual = Durations.MAX_VALUE;
    com.google.protobuf.Duration expected = (com.google.protobuf.Duration) ConvertUtils
        .convert("PT87660000H0.999999999S", com.google.protobuf.Duration.class);
    assertEquals(expected, actual);

    actual = Durations.MIN_VALUE;
    expected = (com.google.protobuf.Duration) ConvertUtils.convert("PT-87660000H-0.999999999S",
        com.google.protobuf.Duration.class);
    assertEquals(expected, actual);

  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testDurationToString() {
    Converter c = ConvertUtils.lookup(java.time.Duration.class, String.class);
    assertEquals(c.getClass(), DurationConverter.class);

    com.google.protobuf.Duration p = Durations.MAX_VALUE;
    String a = (String) ConvertUtils.convert(DurationUtils.toTime(p), String.class);
    assertEquals(a, "PT87660000H0.999999999S");
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testProtoDurationToString() {
    Converter c = ConvertUtils.lookup(com.google.protobuf.Duration.class, String.class);
    assertEquals(c.getClass(), DurationProtoConverter.class);

    com.google.protobuf.Duration p = Durations.MAX_VALUE;
    String a = (String) ConvertUtils.convert(p, String.class);
    assertEquals(a, "PT87660000H0.999999999S");
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testDuration() {
    Converter c = ConvertUtils.lookup(java.time.Duration.class);
    assertEquals(c.getClass(), DurationConverter.class);
    c = ConvertUtils.lookup(com.google.protobuf.Duration.class, java.time.Duration.class);
    assertEquals(c.getClass(), DurationConverter.class);

    com.google.protobuf.Duration actual = Durations.ZERO;
    java.time.Duration expected = (java.time.Duration) ConvertUtils.convert(actual,
        java.time.Duration.class);
    assertEquals(expected, DurationUtils.toTime(actual));

    actual = Durations.MAX_VALUE;
    expected = (java.time.Duration) ConvertUtils.convert(actual, java.time.Duration.class);
    assertEquals(expected, DurationUtils.toTime(actual));

    actual = Durations.MIN_VALUE;
    expected = (java.time.Duration) ConvertUtils.convert(actual, java.time.Duration.class);
    assertEquals(expected, DurationUtils.toTime(actual));

  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testProtoDuration() {
    Converter c = ConvertUtils.lookup(com.google.protobuf.Duration.class);
    assertEquals(c.getClass(), DurationProtoConverter.class);
    c = ConvertUtils.lookup(java.time.Duration.class, com.google.protobuf.Duration.class);
    assertEquals(c.getClass(), DurationProtoConverter.class);

    // Zero
    com.google.protobuf.Duration actual = Durations.ZERO;

    java.time.Duration t = DurationUtils.toTime(actual);
    com.google.protobuf.Duration expected = (com.google.protobuf.Duration) ConvertUtils.convert(t,
        com.google.protobuf.Duration.class);
    assertEquals(expected, actual);

    // Max
    actual = Durations.MAX_VALUE;

    t = DurationUtils.toTime(actual);
    expected = (com.google.protobuf.Duration) ConvertUtils.convert(t,
        com.google.protobuf.Duration.class);
    assertEquals(expected, actual);

    // min
    actual = Durations.MIN_VALUE;

    t = DurationUtils.toTime(actual);
    expected = (com.google.protobuf.Duration) ConvertUtils.convert(t,
        com.google.protobuf.Duration.class);
    assertEquals(expected, actual);
  }

}
