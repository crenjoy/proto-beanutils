
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.BasicTestBeanList;
import com.crenjoy.proto.mapper.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.mapper.bean.test.BasicTestIntBeanList;
import com.crenjoy.proto.mapper.bean.test.BeanMapListBuilder;
import com.crenjoy.proto.mapper.message.test.ProtoMapListBuilder;

import crenjoy.protobuf.BasicTestIntMessageList;
import crenjoy.protobuf.BasicTestMessageList;
import crenjoy.protobuf.BasicTestMessageMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Bean Map List Test.
 *
 * @author CGD
 *
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProtoMapListMapperTest {

  // Null Msg Map --> Empty Bean Map
  @Test
  @Order(1)
  public void testMapNull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapNull();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Empty Msg Map --> Empty Bean Map
  @Test
  @Order(2)
  public void testMapEmpty() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapEmpty();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Full Msg Map --> Full Bean Map
  @Test
  @Order(3)
  public void testMapFull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapFull().getTestStrMapMap());
  }

  // Default Msg Map --> Default Bean Map
  @Test
  @Order(4)
  public void testMapException() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapDefault();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapDefault().getTestStrMapMap());
  }

  // Null List --> Empty List.
  @Test
  @Order(5)
  public void testListNull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListEmpty().getTestStrListList());
  }

  // Empty List --> Empty List.
  @Test
  @Order(6)
  public void testListEmpty() {
    BasicTestBeanList actual = BeanMapListBuilder.getListEmpty();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListEmpty().getTestStrListList());
  }

  // Full List --> Full List.
  @Test
  @Order(7)
  public void testListFull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListFull();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListFull().getTestStrListList());
  }

  // Default List --> Default List.
  @Test
  @Order(8)
  public void testListDefault() {
    BasicTestBeanList actual = BeanMapListBuilder.getListDefault();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListDefault().getTestStrListList());
  }

  // Null Bean Map Update
  @Test
  @Order(9)
  public void testUpdateMapNull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapNull();
    BasicTestMessageMap expected = ProtoMapListBuilder.getMapNull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());

    actual = BeanMapListBuilder.getMapFull();
    expected = ProtoMapListBuilder.getMapNull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapFull().getTestStrMapMap());

  }

  // Full Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapFull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapNull();
    BasicTestMessageMap expected = ProtoMapListBuilder.getMapFull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());

    actual = BeanMapListBuilder.getMapEmpty();
    expected = ProtoMapListBuilder.getMapFull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Empty Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapEmpty() {

    BasicTestBeanMap actual2 = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap expected2 = ProtoMapListBuilder.getMapEmpty();
    expected2 = ProtoMapListMapper.INSTANCE.updateMap(expected2, actual2);
    Assertions.assertEquals(expected2.getTestStrMapMap(),
        ProtoMapListBuilder.getMapFull().getTestStrMapMap());

    BasicTestBeanMap actual = BeanMapListBuilder.getMapEmpty();
    BasicTestMessageMap expected = ProtoMapListBuilder.getMapEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        ProtoMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Null Bean List Update
  @Test
  @Order(9)
  public void testUpdateListNull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = ProtoMapListBuilder.getListNull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListEmpty().getTestStrListList());

    actual = BeanMapListBuilder.getListFull();
    expected = ProtoMapListBuilder.getListNull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListFull().getTestStrListList());

  }

  // Full Bean List Update
  @Test
  @Order(10)
  public void testUpdateListFull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = ProtoMapListBuilder.getListFull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        ProtoMapListBuilder.getListEmpty().getTestStrListList());

  }

  // Empty Bean List Update
  @Test
  @Order(10)
  public void testUpdateListEmpty() {
    BasicTestBeanList actual = BeanMapListBuilder.getListFull();
    BasicTestMessageList expected = ProtoMapListBuilder.getListEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);

    BasicTestBeanList actual1 = BeanMapListBuilder.getListEmpty();
    BasicTestMessageList expected1 = ProtoMapListBuilder.getListEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected1, actual1);
    Assertions.assertEquals(expected1.getTestStrListList(),
        ProtoMapListBuilder.getListEmpty().getTestStrListList());
  }
  
  // IntList
  @Test
  @Order(11)
  public void testIntList() {
    BasicTestIntBeanList actual = BeanMapListBuilder.getIntListFull();
    BasicTestIntMessageList expected = ProtoMapListMapper.INSTANCE.toIntList(actual);
    Assertions.assertEquals(expected.getTestIntListList(),
        ProtoMapListBuilder.getIntListFull().getTestIntListList());
  }
  
  // Full Bean Int List Update
  @Test
  @Order(12)
  public void testUpdateIntListFull() {
    BasicTestIntBeanList actual = BeanMapListBuilder.getIntListFull();
    BasicTestIntMessageList expected = ProtoMapListBuilder.getIntListNull();
    expected = ProtoMapListMapper.INSTANCE.updateIntList(expected, actual);
    Assertions.assertEquals(expected.getTestIntListList(),
        ProtoMapListBuilder.getIntListFull().getTestIntListList());

  }

}
