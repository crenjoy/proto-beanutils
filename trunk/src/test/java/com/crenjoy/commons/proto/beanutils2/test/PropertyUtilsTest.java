package com.crenjoy.commons.proto.beanutils2.test;

import com.crenjoy.commons.proto.beanutils2.message.test.Basic1TestMsgBuilder;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import crenjoy.protobuf.Basic1TestMessage;

/**
 * PropertyUtils Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PropertyUtilsTest {

  @Test
  @Order(1)
  public void testDescribe()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Map<String, Object> desMap = PropertyUtils.describe(Basic1TestMsgBuilder.getMin());
    System.out.println(desMap);
  }

  @Test
  @Order(2)
  public void testGetProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object obj = PropertyUtils.getProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(obj);
  }

  @Test
  @Order(3)
  public void testGetPropertyDescriptor()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor des = PropertyUtils.getPropertyDescriptor(Basic1TestMsgBuilder.getMin(),
        "testDouble");
    System.out.println(des);
  }

  @Test
  @Order(4)
  public void testGetPropertyDescriptors()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor[] dess = PropertyUtils.getPropertyDescriptors(Basic1TestMessage.class);
    for (PropertyDescriptor des : dess) {
      System.out.println(des);
    }
  }

  @Test
  @Order(5)
  public void testGetPropertyDescriptorsByBean()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    PropertyDescriptor[] dess = PropertyUtils.getPropertyDescriptors(Basic1TestMsgBuilder.getMax());
    for (PropertyDescriptor des : dess) {
      System.out.println(des);
    }
  }

  @Test
  @Order(6)
  public void testGetPropertyEditorClass()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Class<?> clazz = PropertyUtils.getPropertyEditorClass(Basic1TestMsgBuilder.getMax(),
        "testDouble");
    System.out.println(clazz);
  }

  @Test
  @Order(7)
  public void testGetPropertyType()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Class<?> clazz = PropertyUtils.getPropertyType(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(clazz);
  }

  @Test
  @Order(8)
  public void testGetSimpleProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Object obj = PropertyUtils.getSimpleProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(obj);
  }

  @Test
  @Order(9)
  public void testWriteProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    boolean write = PropertyUtils.isWriteable(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(write);
    if (write) {
      PropertyUtils.setProperty(Basic1TestMsgBuilder.getMin(), "testDouble", 11.23f);
    }
    System.out.println(PropertyUtils.getProperty(Basic1TestMsgBuilder.getMin(), "testDouble"));
  }

  @Test
  @Order(10)
  public void testWriteSimpleProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

    boolean write = PropertyUtils.isWriteable(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(write);
    if (write) {
      PropertyUtils.setSimpleProperty(Basic1TestMsgBuilder.getMin(), "testDouble", 11.23f);
    }

    Object obj = PropertyUtils.getSimpleProperty(Basic1TestMsgBuilder.getMax(), "testDouble");
    System.out.println(obj);
  }

  @Test
  @Order(11)
  public void testWriteMessageProperty()
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    Basic1TestMessage.Builder builder = Basic1TestMsgBuilder.getMax().toBuilder();
    PropertyDescriptor des = PropertyUtils.getPropertyDescriptor(builder, "testDouble");
    System.out.println(des);
    boolean write = PropertyUtils.isWriteable(builder, "testDouble");
    System.out.println(write);
    if (write) {
      PropertyUtils.setSimpleProperty(builder, "testDouble", 11.23f);
    }
    Object obj = PropertyUtils.getSimpleProperty(builder, "testDouble");
    System.out.println(obj);
  }

}
