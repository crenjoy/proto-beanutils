
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.TestBeanBuilder;
import com.crenjoy.proto.mapper.bean.test.TestBeanList;
import com.crenjoy.proto.mapper.bean.test.TestBeanMap;
import com.crenjoy.proto.mapper.message.test.TestMessageBuilder;

import crenjoy.protobuf.Basic2TestMessage;
import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProtoTestMapListMapperTest {

  @Test
  @Order(1)
  public void testMapNull() {
    TestBeanMap actual = TestBeanBuilder.getMapNull();
    TestMessageMap expected = ProtoTestMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestBasicMapMap().size(), 0);
  }

  @Test
  @Order(2)
  public void testMapFull() {
    TestBeanMap actual = TestBeanBuilder.getMapFull();
    TestMessageMap expected = ProtoTestMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestBasicMapMap().size(),
        TestMessageBuilder.getMapFull().getTestBasicMapMap().size());
    for (Map.Entry<String, Basic2TestMessage> entry : TestMessageBuilder.getMapFull()
        .getTestBasicMapMap().entrySet()) {
      Basic2TestMessage bean = expected.getTestBasicMapMap().get(entry.getKey());
      Assertions.assertEquals(bean, entry.getValue());
    }
  }

  @Test
  @Order(3)
  public void testUpdateMapNull() {
    TestBeanMap actual = TestBeanBuilder.getMapNull();
    TestMessageMap expected = TestMessageBuilder.getMapFull();
    expected = ProtoTestMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestBasicMapMap().size(), 0);
  }

  @Test
  @Order(4)
  public void testUpdateMapFull() {
    TestBeanMap actual = TestBeanBuilder.getMapFull();
    TestMessageMap expected = TestMessageBuilder.getMapNull();
    expected = ProtoTestMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestBasicMapMap().size(),
        TestMessageBuilder.getMapFull().getTestBasicMapMap().size());
    for (Map.Entry<String, Basic2TestMessage> entry : TestMessageBuilder.getMapFull()
        .getTestBasicMapMap().entrySet()) {
      Basic2TestMessage bean = expected.getTestBasicMapMap().get(entry.getKey());
      Assertions.assertEquals(bean, entry.getValue());
    }
  }

  @Test
  @Order(5)
  public void testListNull() {
    TestBeanList actual = TestBeanBuilder.getListNull();
    TestMessageList expected = ProtoTestMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestBasicListList().size(), 0);
  }

  @Test
  @Order(6)
  public void testListFull() {
    TestBeanList actual = TestBeanBuilder.getListFull();
    TestMessageList expected = ProtoTestMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestBasicListList().size(),
        TestMessageBuilder.getListFull().getTestBasicListList().size());

    for (int i = 0; i < expected.getTestBasicListList().size(); i++) {
      Basic2TestMessage bean1 = TestMessageBuilder.getListFull().getTestBasicListList().get(i);
      Assertions.assertTrue(expected.getTestBasicListList().contains(bean1));
    }
  }

  @Test
  @Order(7)
  public void testUpdateListNull() {
    TestBeanList actual = TestBeanBuilder.getListNull();
    TestMessageList expected = TestMessageBuilder.getListFull();
    expected=ProtoTestMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestBasicListList().size(), 0);
  }

  @Test
  @Order(8)
  public void testUpdateListFull() {
    TestBeanList actual = TestBeanBuilder.getListFull();
    TestMessageList expected = TestMessageBuilder.getListNull();
    expected=ProtoTestMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestBasicListList().size(),
        TestMessageBuilder.getListFull().getTestBasicListList().size());
    for (int i = 0; i < expected.getTestBasicListList().size(); i++) {
      Basic2TestMessage bean1 = TestMessageBuilder.getListFull().getTestBasicListList().get(i);
      Assertions.assertTrue(expected.getTestBasicListList().contains(bean1));
    }
  }

}
