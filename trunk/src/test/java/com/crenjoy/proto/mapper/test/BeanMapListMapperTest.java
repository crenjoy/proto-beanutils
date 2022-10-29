
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.beanutils.bean.test.BasicTestBeanList;
import com.crenjoy.proto.beanutils.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.beanutils.bean.test.BeanMapListBuilder;
import com.crenjoy.proto.mapper.message.test.ProtoMapListBuilder;
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
public class BeanMapListMapperTest {

  // Null Msg Map --> Empty Bean Map
  @Test
  @Order(1)
  public void testMapNull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapNull();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Empty Msg Map --> Empty Bean Map
  @Test
  @Order(2)
  public void testMapEmpty() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapEmpty();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMapMap());
  }

  // Full Msg Map --> Full Bean Map
  @Test
  @Order(3)
  public void testMapFull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapFull();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapFull().getTestStrMapMap());
  }

  // Default Msg Map --> Default Bean Map
  @Test
  @Order(4)
  public void testMapException() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapDefault();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapDefault().getTestStrMapMap());
  }

  // Null List --> Empty List.
  @Test
  @Order(5)
  public void testListNull() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListNull();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListBuilder.getListEmpty().getTestStrListList());
  }

  // Empty List --> Empty List.
  @Test
  @Order(6)
  public void testListEmpty() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListEmpty();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListBuilder.getListEmpty().getTestStrListList());
  }

  // Full List --> Full List.
  @Test
  @Order(7)
  public void testListFull() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListFull();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListBuilder.getListFull().getTestStrListList());
  }

  // Default List --> Default List.
  @Test
  @Order(8)
  public void testListDefault() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListDefault();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrListList(),
        BeanMapListBuilder.getListDefault().getTestStrListList());
  }

  // Null Msg Map Update Empty Bean Map
  @Test
  @Order(9)
  public void testUpdateMapNull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapNull();
    BasicTestBeanMap expected = BeanMapListBuilder.getMapNull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMapMap());

    actual = ProtoMapListBuilder.getMapNull();
    expected = BeanMapListBuilder.getMapFull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMapMap());

  }

  // Full Msg Map Update Full Bean Map
  @Test
  @Order(9)
  public void testUpdateMapFull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapFull();
    BasicTestBeanMap expected = BeanMapListBuilder.getMapNull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMapMap(),
        BeanMapListBuilder.getMapFull().getTestStrMapMap());

    Assertions.assertThrows(UnsupportedOperationException.class, () -> {
      BasicTestMessageMap actual2 = ProtoMapListBuilder.getMapFull();
      BasicTestBeanMap expected2 = BeanMapListBuilder.getMapEmpty();
      BeanMapListMapper.INSTANCE.updateMap(expected2, actual2);
    });

  }

}
