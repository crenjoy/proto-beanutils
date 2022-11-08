
package com.crenjoy.proto.mapper.test;

import com.crenjoy.proto.mapper.bean.test.BasicTestBeanList;
import com.crenjoy.proto.mapper.bean.test.BasicTestBeanMap;
import com.crenjoy.proto.mapper.bean.test.BeanMapListBuilder;
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
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());
  }

  // Empty Msg Map --> Empty Bean Map
  @Test
  @Order(2)
  public void testMapEmpty() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapEmpty();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());
  }

  // Full Msg Map --> Full Bean Map
  @Test
  @Order(3)
  public void testMapFull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapFull();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapFull().getTestStrMap());
  }

  // Default Msg Map --> Default Bean Map
  @Test
  @Order(4)
  public void testMapException() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapDefault();
    BasicTestBeanMap expected = BeanMapListMapper.INSTANCE.toMap(actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapDefault().getTestStrMap());
  }

  // Null List --> Empty List.
  @Test
  @Order(5)
  public void testListNull() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListNull();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListEmpty().getTestStrList());
  }

  // Empty List --> Empty List.
  @Test
  @Order(6)
  public void testListEmpty() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListEmpty();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListEmpty().getTestStrList());
  }

  // Full List --> Full List.
  @Test
  @Order(7)
  public void testListFull() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListFull();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListFull().getTestStrList());
  }

  // Default List --> Default List.
  @Test
  @Order(8)
  public void testListDefault() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListDefault();
    BasicTestBeanList expected = BeanMapListMapper.INSTANCE.toList(actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListDefault().getTestStrList());
  }

  // Null Bean Map Update
  @Test
  @Order(9)
  public void testUpdateMapNull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapNull();
    BasicTestBeanMap expected = BeanMapListBuilder.getMapNull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());

    actual = ProtoMapListBuilder.getMapFull();
    expected = BeanMapListBuilder.getMapNull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapFull().getTestStrMap());

  }

  // Full Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapFull() {
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapNull();
    BasicTestBeanMap expected = BeanMapListBuilder.getMapFull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());

    actual = ProtoMapListBuilder.getMapEmpty();
    expected = BeanMapListBuilder.getMapFull();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());
  }

  // Empty Bean Map Update
  @Test
  @Order(10)
  public void testUpdateMapEmpty() {
    // UnsupportedOperationException
    // @Mapper(collectionMappingStrategy =
    // CollectionMappingStrategy.TARGET_IMMUTABLE)
    // Assertions.assertThrows(UnsupportedOperationException.class, () -> {
    BasicTestMessageMap actual2 = ProtoMapListBuilder.getMapFull();
    BasicTestBeanMap expected2 = BeanMapListBuilder.getMapEmpty();
    BeanMapListMapper.INSTANCE.updateMap(expected2, actual2);
    Assertions.assertEquals(expected2.getTestStrMap(),
        BeanMapListBuilder.getMapFull().getTestStrMap());
    // });
    BasicTestMessageMap actual = ProtoMapListBuilder.getMapEmpty();
    BasicTestBeanMap expected = BeanMapListBuilder.getMapEmpty();
    BeanMapListMapper.INSTANCE.updateMap(expected, actual);
    Assertions.assertEquals(expected.getTestStrMap(),
        BeanMapListBuilder.getMapEmpty().getTestStrMap());
  }

  // Null Bean List Update
  @Test
  @Order(9)
  public void testUpdateListNull() {
    BasicTestMessageList actual = ProtoMapListBuilder.getListNull();
    BasicTestBeanList expected = BeanMapListBuilder.getListNull();
    BeanMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListEmpty().getTestStrList());

    actual = ProtoMapListBuilder.getListFull();
    expected = BeanMapListBuilder.getListNull();
    BeanMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListFull().getTestStrList());

  }

  // Full Bean List Update
  @Test
  @Order(10)
  public void testUpdateListFull() {
    // UnsupportedOperationException
    // @Mapper(collectionMappingStrategy =
    // CollectionMappingStrategy.TARGET_IMMUTABLE)
    // Assertions.assertThrows(UnsupportedOperationException.class, () -> {
    BasicTestMessageList actual = ProtoMapListBuilder.getListNull();
    BasicTestBeanList expected = BeanMapListBuilder.getListFull();
    BeanMapListMapper.INSTANCE.updateList(expected, actual);
    Assertions.assertEquals(expected.getTestStrList(),
        BeanMapListBuilder.getListEmpty().getTestStrList());
    // });
  }

  // Empty Bean List Update
  @Test
  @Order(10)
  public void testUpdateListEmpty() {
    // UnsupportedOperationException
    // @Mapper(collectionMappingStrategy =
    // CollectionMappingStrategy.TARGET_IMMUTABLE)
    // Assertions.assertThrows(UnsupportedOperationException.class, () -> {
    BasicTestMessageList actual = ProtoMapListBuilder.getListFull();
    BasicTestBeanList expected = BeanMapListBuilder.getListEmpty();
    BeanMapListMapper.INSTANCE.updateList(expected, actual);
    // });
    BasicTestMessageList actual1 = ProtoMapListBuilder.getListEmpty();
    BasicTestBeanList expected1 = BeanMapListBuilder.getListEmpty();
    BeanMapListMapper.INSTANCE.updateList(expected1, actual1);
    Assertions.assertEquals(expected1.getTestStrList(),
        BeanMapListBuilder.getListEmpty().getTestStrList());
  }

}
