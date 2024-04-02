package com.crenjoy.proto.beanutils.converters.test;

import com.crenjoy.proto.beanutils.ProtoConvertUtils;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * UUIDConverterTest Test.
 *
 * @author CGD
 *
 */
public class UuidConverterTest {

  @Test
  public void testUuid() {
    UUID uuid = (UUID) ProtoConvertUtils.convert("", UUID.class);
    Assertions.assertEquals(null, uuid);
  }

}
