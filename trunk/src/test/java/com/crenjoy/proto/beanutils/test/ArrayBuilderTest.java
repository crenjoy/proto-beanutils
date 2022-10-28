package com.crenjoy.proto.beanutils.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crenjoy.proto.beanutils.ArrayBuilder;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;

/**
 * ArrayBuilder Test
 *
 * @author CGD
 *
 */
public class ArrayBuilderTest {

  private Log log = LogFactory.getLog(ArrayBuilderTest.class);

  @Test
  public void test() {
    String[] t0 = new ArrayBuilder<String>().builder(new String[0]);
    log.info(Arrays.toString(t0));
    assertEquals(t0.length, 0);

    String[] t1 = new ArrayBuilder<String>(new String[] { "1", "2", "3" }).builder(new String[0]);
    log.info(Arrays.toString(t1));
    assertEquals(t1.length, 3);

    String[] t2 = new ArrayBuilder<String>(t1).concat(new String[] { "4", "5" })
        .builder(new String[0]);
    log.info(Arrays.toString(t2));
    assertEquals(t2.length, 5);

    String[] t3 = new ArrayBuilder<String>(t1).concat(new String[] { "4", "5" })
        .concat(new String[] { "6", "7", "8" }).builder(new String[0]);
    log.info(Arrays.toString(t3));
    assertEquals(t3.length, 8);

  }

}
