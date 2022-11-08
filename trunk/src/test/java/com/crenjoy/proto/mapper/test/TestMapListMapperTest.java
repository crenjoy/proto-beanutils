
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.Basic2TestBean;
import com.crenjoy.proto.mapper.bean.test.TestBeanBuilder;
import com.crenjoy.proto.mapper.bean.test.TestBeanList;
import com.crenjoy.proto.mapper.bean.test.TestBeanMap;
import com.crenjoy.proto.mapper.message.test.TestMessageBuilder;
import crenjoy.protobuf.TestMessageList;
import crenjoy.protobuf.TestMessageMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMapListMapperTest {

  @Test
  @Order(1)
  public void testMapNull() {
    TestMessageMap actual = TestMessageBuilder.getMapNull();
    TestBeanMap expected = TestMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestBasicMap().size(), 0);
  }

  @Test
  @Order(2)
  public void testMapFull() {
    TestMessageMap actual = TestMessageBuilder.getMapFull();
    TestBeanMap expected = TestMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestBasicMap().size(),
        TestBeanBuilder.getMapFull().getTestBasicMap().size());
    for (Map.Entry<String, Basic2TestBean> entry : TestBeanBuilder.getMapFull().getTestBasicMap()
        .entrySet()) {
      Basic2TestBean bean = expected.getTestBasicMap().get(entry.getKey());
      Assertions.assertEquals(bean, entry.getValue());
    }
  }

  @Test
  @Order(3)
  public void testUpdateMapNull() {
    TestMessageMap actual = TestMessageBuilder.getMapNull();
    TestBeanMap expected = TestBeanBuilder.getMapFull();
    TestMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestBasicMap().size(), 0);
  }

  @Test
  @Order(4)
  public void testUpdateMapFull() {
    TestMessageMap actual = TestMessageBuilder.getMapFull();
    TestBeanMap expected = TestBeanBuilder.getMapNull();
    TestMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestBasicMap().size(),
        TestBeanBuilder.getMapFull().getTestBasicMap().size());
    for (Map.Entry<String, Basic2TestBean> entry : TestBeanBuilder.getMapFull().getTestBasicMap()
        .entrySet()) {
      Basic2TestBean bean = expected.getTestBasicMap().get(entry.getKey());
      Assertions.assertEquals(bean, entry.getValue());
    }
  }

  @Test
  @Order(5)
  public void testListNull() {
    TestMessageList actual = TestMessageBuilder.getListNull();
    TestBeanList expected = TestMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestBasicList().size(), 0);
  }

  @Test
  @Order(6)
  public void testListFull() {
    TestMessageList actual = TestMessageBuilder.getListFull();
    TestBeanList expected = TestMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestBasicList().size(),
        TestBeanBuilder.getListFull().getTestBasicList().size());
    
    for(int i = 0 ;i< expected.getTestBasicList().size();i++) {
      Basic2TestBean bean1= TestBeanBuilder.getListFull().getTestBasicList().get(i);      
      Assertions.assertTrue(expected.getTestBasicList().contains(bean1));
    }
  }
  
  @Test
  @Order(7)
  public void testUpdateListNull() {
    TestMessageList actual = TestMessageBuilder.getListNull();
    TestBeanList expected = TestBeanBuilder.getListFull();
    TestMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestBasicList().size(), 0);
  }

  @Test
  @Order(8)
  public void testUpdateListFull() {
    TestMessageList actual = TestMessageBuilder.getListFull();
    TestBeanList expected = TestBeanBuilder.getListNull();
    TestMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestBasicList().size(),
        TestBeanBuilder.getListFull().getTestBasicList().size());
    for(int i = 0 ;i< expected.getTestBasicList().size();i++) {
      Basic2TestBean bean1= TestBeanBuilder.getListFull().getTestBasicList().get(i);      
      Assertions.assertTrue(expected.getTestBasicList().contains(bean1));
    }
  }

}
