package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;

import java.math.BigDecimal;

import org.apache.commons.beanutils2.ConvertUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * BigDecimalConverter Test.
 *
 * @author CGD
 *
 */
public class BigDecimalConverterTest {

  @BeforeAll
  public static void register() {
    ProtoConvertUtils.init();
  }

  @Test
  public void testToString() {
    String dbStr = (String) ConvertUtils.convert(BigDecimal.ZERO, String.class);
    assertEquals(dbStr, "0");

    dbStr = (String) ConvertUtils.convert(BigDecimal.TEN, String.class);
    assertEquals(dbStr, "10");
  }

  @Test
  public void testToBigDecimal() {
    BigDecimal db = (BigDecimal) ConvertUtils.convert("", BigDecimal.class);
    assertEquals(db, BigDecimal.ZERO);
  }

}
