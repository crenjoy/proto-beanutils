
package com.crenjoy.proto.beanutils.converters.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OffsetDateTimeTest {

  @Test
  public void convertMin() {
    OffsetDateTime actual = OffsetDateTime.MIN;
    String str = ProtoConvertUtils.convert(actual, String.class);
    OffsetDateTime expected = ProtoConvertUtils.convert(str, OffsetDateTime.class);
    Assertions.assertEquals(expected, actual);
  }
  
  
  @Test
  public void convertMax() {
    OffsetDateTime actual = OffsetDateTime.MAX;
    String str = ProtoConvertUtils.convert(actual, String.class);
    OffsetDateTime expected = ProtoConvertUtils.convert(str, OffsetDateTime.class);
    Assertions.assertEquals(expected, actual);
  }
  

}
