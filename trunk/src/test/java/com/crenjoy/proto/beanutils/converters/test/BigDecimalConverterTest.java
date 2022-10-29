
package com.crenjoy.proto.beanutils.converters.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * BigDecimalConverter Test.
 *
 * @author CGD
 *
 */
public class BigDecimalConverterTest {

  @Test
  public void testToString() {
    String dbStr = (String) ProtoConvertUtils.convert(BigDecimal.ZERO, String.class);
    Assertions.assertEquals(dbStr, "0");

    dbStr = (String) ProtoConvertUtils.convert(BigDecimal.TEN, String.class);
    Assertions.assertEquals(dbStr, "10");
  }

  @Test
  public void testToBigDecimal() {
    BigDecimal db = (BigDecimal) ProtoConvertUtils.convert("", BigDecimal.class);
    Assertions.assertEquals(db, BigDecimal.ZERO);
  }

}
