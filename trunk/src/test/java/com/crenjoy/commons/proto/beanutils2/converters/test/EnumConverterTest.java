package com.crenjoy.commons.proto.beanutils2.converters.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.beanutils2.ConvertUtils;
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
    String str = (String) ConvertUtils.convert(PizzaStatus.READY, String.class);
    assertEquals(str, PizzaStatus.READY.name());
    str = (String) ConvertUtils.convert(PizzaStatus.ORDERED, String.class);
    assertEquals(str, PizzaStatus.ORDERED.name());
  }

  @Test
  public void testEnumToInt() {
    Integer i = (Integer) ConvertUtils.convert(PizzaStatus.READY, Integer.class);
    assertEquals(i, PizzaStatus.READY.ordinal());

    i = (Integer) ConvertUtils.convert(PizzaStatus.ORDERED, Integer.class);
    assertEquals(i, PizzaStatus.ORDERED.ordinal());
  }

  @Test
  public void testStrToEnum() {
    PizzaStatus ps = (PizzaStatus) ConvertUtils.convert("READY", PizzaStatus.class);
    assertEquals(ps, PizzaStatus.READY);

    ps = (PizzaStatus) ConvertUtils.convert("ORDERED", PizzaStatus.class);
    assertEquals(ps, PizzaStatus.ORDERED);
  }

  @Test
  public void testIntToEnum() {
    PizzaStatus ps = (PizzaStatus) ConvertUtils.convert(1, PizzaStatus.class);
    assertEquals(ps, PizzaStatus.READY);

    ps = (PizzaStatus) ConvertUtils.convert(0, PizzaStatus.class);
    assertEquals(ps, PizzaStatus.ORDERED);
  }

  public enum PizzaStatus {
    ORDERED, READY, DELIVERED;
  }

}
