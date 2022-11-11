 
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.BasicTestBeanList;
import com.crenjoy.proto.mapper.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.mapper.bean.test.BasicTestIntBeanList;
import com.crenjoy.proto.mapper.bean.test.BeanMapListBuilder;
import com.crenjoy.proto.mapper.message.test.BeanMapListMsgBuilder;

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
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Empty Msg Map --> Empty Bean Map
  @Test
  @Order(2)
  public void testMapEmpty() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapEmpty();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Full Msg Map --> Full Bean Map
  @Test
  @Order(3)
  public void testMapFull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapFull().getTestStrMapMap());
  }

  // Default Msg Map --> Default Bean Map
  @Test
  @Order(4)
  public void testMapException() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapDefault();
    BasicTestMessageMap expected = ProtoMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapDefault().getTestStrMapMap());
  }

  // Null List --> Empty List.
  @Test
  @Order(5)
  public void testListNull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListEmpty().getTestStrListList());
  }

  // Empty List --> Empty List.
  @Test
  @Order(6)
  public void testListEmpty() {
    BasicTestBeanList actual = BeanMapListBuilder.getListEmpty();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListEmpty().getTestStrListList());
  }

  // Full List --> Full List.
  @Test
  @Order(7)
  public void testListFull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListFull();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListFull().getTestStrListList());
  }

  // Default List --> Default List.
  @Test
  @Order(8)
  public void testListDefault() {
    BasicTestBeanList actual = BeanMapListBuilder.getListDefault();
    BasicTestMessageList expected = ProtoMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListDefault().getTestStrListList());
  }

  // Null Bean Map Update
  @Test
  @Order(9)
  public void testUpdateMapNull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapNull();
    BasicTestMessageMap expected = BeanMapListMsgBuilder.getMapNull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());

    actual = BeanMapListBuilder.getMapFull();
    expected = BeanMapListMsgBuilder.getMapNull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapFull().getTestStrMapMap());

  }

  // Full Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapFull() {
    BasicTestBeanMap actual = BeanMapListBuilder.getMapNull();
    BasicTestMessageMap expected = BeanMapListMsgBuilder.getMapFull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());

    actual = BeanMapListBuilder.getMapEmpty();
    expected = BeanMapListMsgBuilder.getMapFull();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Empty Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapEmpty() {

    BasicTestBeanMap actual2 = BeanMapListBuilder.getMapFull();
    BasicTestMessageMap expected2 = BeanMapListMsgBuilder.getMapEmpty();
    expected2 = ProtoMapListMapper.INSTANCE.updateMap(expected2, actual2);
    Assertions.assertEquals(expected2.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapFull().getTestStrMapMap());

    BasicTestBeanMap actual = BeanMapListBuilder.getMapEmpty();
    BasicTestMessageMap expected = BeanMapListMsgBuilder.getMapEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListMsgBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Null Bean List Update
  @Test
  @Order(9)
  public void testUpdateListNull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = BeanMapListMsgBuilder.getListNull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListEmpty().getTestStrListList());

    actual = BeanMapListBuilder.getListFull();
    expected = BeanMapListMsgBuilder.getListNull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListFull().getTestStrListList());

  }

  // Full Bean List Update
  @Test
  @Order(10)
  public void testUpdateListFull() {
    BasicTestBeanList actual = BeanMapListBuilder.getListNull();
    BasicTestMessageList expected = BeanMapListMsgBuilder.getListFull();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListMsgBuilder.getListEmpty().getTestStrListList());

  }

  // Empty Bean List Update
  @Test
  @Order(10)
  public void testUpdateListEmpty() {
    BasicTestBeanList actual = BeanMapListBuilder.getListFull();
    BasicTestMessageList expected = BeanMapListMsgBuilder.getListEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected, actual);

    BasicTestBeanList actual1 = BeanMapListBuilder.getListEmpty();
    BasicTestMessageList expected1 = BeanMapListMsgBuilder.getListEmpty();
    expected = ProtoMapListMapper.INSTANCE.updateList(expected1, actual1);
    Assertions.assertEquals(expected1.getTestStrListList(),
        BeanMapListMsgBuilder.getListEmpty().getTestStrListList());
  }
  
  // IntList
  @Test
  @Order(11)
  public void testIntList() {
    BasicTestIntBeanList actual = BeanMapListBuilder.getIntListFull();
    BasicTestIntMessageList expected = ProtoMapListMapper.INSTANCE.toIntList(actual);
    Assertions.assertEquals(expected.getTestIntListList(),
        BeanMapListMsgBuilder.getIntListFull().getTestIntListList());
  }
  
  // Full Bean Int List Update
  @Test
  @Order(12)
  public void testUpdateIntListFull() {
    BasicTestIntBeanList actual = BeanMapListBuilder.getIntListFull();
    BasicTestIntMessageList expected = BeanMapListMsgBuilder.getIntListNull();
    expected = ProtoMapListMapper.INSTANCE.updateIntList(expected, actual);
    Assertions.assertEquals(expected.getTestIntListList(),
        BeanMapListMsgBuilder.getIntListFull().getTestIntListList());

  }

}
