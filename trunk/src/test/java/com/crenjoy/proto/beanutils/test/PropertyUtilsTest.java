
package com.crenjoy.proto.beanutils.test;

import com.crenjoy.proto.mapper.message.test.Basic1TestMsgBuilder;
import crenjoy.protobuf.Basic1TestMessage;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * PropertyUtils Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PropertyUtilsTest {

  private Log log = LogFactory.getLog(PropertyUtilsTest.class);

  @Test
  @Order(1)
  public void testDescribe()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Map<String, Object> desMap = PropertyUtils.describe(Basic1TestMsgBuilder.getMin());
    log.info(desMap);
  }

  @Test
  @Order(2)
  public void testGetProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object obj = PropertyUtils.getProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(obj);
  }

  @Test
  @Order(3)
  public void testGetPropertyDescriptor()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor des = PropertyUtils.getPropertyDescriptor(Basic1TestMsgBuilder.getMin(),
        "testDouble");
    log.info(des);
  }

  @Test
  @Order(4)
  public void testGetPropertyDescriptors()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor[] dess = PropertyUtils.getPropertyDescriptors(Basic1TestMessage.class);
    for (PropertyDescriptor des : dess) {
      log.info(des);
    }
  }

  @Test
  @Order(5)
  public void testGetPropertyDescriptorsByBean()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor[] dess = PropertyUtils.getPropertyDescriptors(Basic1TestMsgBuilder.getMax());
    for (PropertyDescriptor des : dess) {
      log.info(des);
    }
  }

  @Test
  @Order(6)
  public void testGetPropertyEditorClass()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Class<?> clazz = PropertyUtils.getPropertyEditorClass(Basic1TestMsgBuilder.getMax(),
        "testDouble");
    log.info(clazz);
  }

  @Test
  @Order(7)
  public void testGetPropertyType()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Class<?> clazz = PropertyUtils.getPropertyType(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(clazz);
  }

  @Test
  @Order(8)
  public void testGetSimpleProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object obj = PropertyUtils.getSimpleProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(obj);
  }

  @Test
  @Order(9)
  public void testWriteProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    boolean write = PropertyUtils.isWriteable(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(write);
    if (write) {
      PropertyUtils.setProperty(Basic1TestMsgBuilder.getMin(), "testDouble", 11.23f);
    }
    log.info(PropertyUtils.getProperty(Basic1TestMsgBuilder.getMin(), "testDouble"));
  }

  @Test
  @Order(10)
  public void testWriteSimpleProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

    boolean write = PropertyUtils.isWriteable(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(write);
    if (write) {
      PropertyUtils.setSimpleProperty(Basic1TestMsgBuilder.getMin(), "testDouble", 11.23f);
    }

    Object obj = PropertyUtils.getSimpleProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    log.info(obj);
  }

  @Test
  @Order(11)
  public void testWriteMessageProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage.Builder builder = Basic1TestMsgBuilder.getMax().toBuilder();
    PropertyDescriptor des = PropertyUtils.getPropertyDescriptor(builder, "testDouble");
    log.info(des);
    boolean write = PropertyUtils.isWriteable(builder, "testDouble");
    log.info(write);
    if (write) {
      PropertyUtils.setSimpleProperty(builder, "testDouble", 11.23f);
    }
    Object obj = PropertyUtils.getSimpleProperty(builder, "testDouble");
    log.info(obj);
  }

}
