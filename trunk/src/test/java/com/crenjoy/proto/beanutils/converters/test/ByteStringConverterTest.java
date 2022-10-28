package com.crenjoy.proto.beanutils.converters.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import com.crenjoy.proto.beanutils.converters.ByteArrayConverter;
import com.crenjoy.proto.beanutils.converters.ByteStringConverter;
import com.google.protobuf.ByteString;

import org.apache.commons.beanutils.Converter;
import org.junit.jupiter.api.Test;

/**
 * ByteStringConverter Test.
 *
 * @author CGD
 *
 */
public class ByteStringConverterTest {

  @Test
  public void testToByteString() {
    Converter c = ProtoConvertUtils.lookup(ByteString.class);
    assertEquals(c.getClass(), ByteStringConverter.class);
    c = ProtoConvertUtils.lookup(byte[].class, ByteString.class);
    assertEquals(c.getClass(), ByteStringConverter.class);

    byte[] bytes = "1234567890".getBytes();
    ByteString bs = (ByteString) ProtoConvertUtils.convert(bytes, ByteString.class);
    assertArrayEquals(bytes, bs.toByteArray());
  }

  @Test
  public void testFromByteString() {
    Converter c = ProtoConvertUtils.lookup(byte[].class);
    assertEquals(c.getClass(), ByteArrayConverter.class);
    c = ProtoConvertUtils.lookup(ByteString.class, byte[].class);
    assertEquals(c.getClass(), ByteArrayConverter.class);

    byte[] bytes = "0123456789".getBytes();

    byte[] bs = (byte[]) ProtoConvertUtils.convert(ByteString.copyFrom(bytes), byte[].class);
    assertArrayEquals(bytes, bs);

  }

}
