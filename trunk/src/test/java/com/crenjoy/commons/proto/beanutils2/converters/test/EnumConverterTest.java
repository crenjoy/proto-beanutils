package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.commons.proto.beanutils2.ProtoConvertUtils;

import org.junit.jupiter.api.Test;

/**
 * Test Enum .
 *
 * @author CGD
 *
 */
public class EnumConverterTest {

  @Test
  public void testEnumToStr() {
    String str = (String) ProtoConvertUtils.convert(PizzaStatus.READY, String.class);
    assertEquals(str, PizzaStatus.READY.name());
    str = (String) ProtoConvertUtils.convert(PizzaStatus.ORDERED, String.class);
    assertEquals(str, PizzaStatus.ORDERED.name());
  }

  @Test
  public void testEnumToInt() {
    Integer i = (Integer) ProtoConvertUtils.convert(PizzaStatus.READY, Integer.class);
    assertEquals(i, PizzaStatus.READY.ordinal());

    i = (Integer) ProtoConvertUtils.convert(PizzaStatus.ORDERED, Integer.class);
    assertEquals(i, PizzaStatus.ORDERED.ordinal());
  }

  @Test
  public void testStrToEnum() {
    PizzaStatus ps = (PizzaStatus) ProtoConvertUtils.convert("READY", PizzaStatus.class);
    assertEquals(ps, PizzaStatus.READY);

    ps = (PizzaStatus) ProtoConvertUtils.convert("ORDERED", PizzaStatus.class);
    assertEquals(ps, PizzaStatus.ORDERED);
  }

  @Test
  public void testIntToEnum() {
    PizzaStatus ps = (PizzaStatus) ProtoConvertUtils.convert(1, PizzaStatus.class);
    assertEquals(ps, PizzaStatus.READY);

    ps = (PizzaStatus) ProtoConvertUtils.convert(0, PizzaStatus.class);
    assertEquals(ps, PizzaStatus.ORDERED);
  }

  public enum PizzaStatus {
    ORDERED, READY, DELIVERED;
  }

}
