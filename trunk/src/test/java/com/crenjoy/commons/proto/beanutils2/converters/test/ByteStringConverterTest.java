package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;
import com.crenjoy.commons.proto.beanutils2.converters.ByteArrayConverter;
import com.crenjoy.commons.proto.beanutils2.converters.ByteStringConverter;
import com.google.protobuf.ByteString;

import org.apache.commons.beanutils2.ConvertUtils;
import org.apache.commons.beanutils2.Converter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * ByteStringConverter Test.
 *
 * @author CGD
 *
 */
public class ByteStringConverterTest {

  @BeforeAll
  public static void register() {
    ProtoConvertUtils.init();
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testToByteString() {
    Converter c = ConvertUtils.lookup(ByteString.class);
    assertEquals(c.getClass(), ByteStringConverter.class);
    c = ConvertUtils.lookup(byte[].class, ByteString.class);
    assertEquals(c.getClass(), ByteStringConverter.class);

    byte[] bytes = "1234567890".getBytes();
    ByteString bs = (ByteString) ConvertUtils.convert(bytes, ByteString.class);
    assertArrayEquals(bytes, bs.toByteArray());
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void testFromByteString() {
    Converter c = ConvertUtils.lookup(byte[].class);
    assertEquals(c.getClass(), ByteArrayConverter.class);
    c = ConvertUtils.lookup(ByteString.class, byte[].class);
    assertEquals(c.getClass(), ByteArrayConverter.class);

    byte[] bytes = "0123456789".getBytes();

    byte[] bs = (byte[]) ConvertUtils.convert(ByteString.copyFrom(bytes), byte[].class);
    assertArrayEquals(bytes, bs);

  }

}
