
package com.crenjoy.proto.mapper.message.test;

import crenjoy.protobuf.BasicTestIntMessageList;
import crenjoy.protobuf.BasicTestMessageList;
import crenjoy.protobuf.BasicTestMessageMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Bean Map List Builder.
 *
 * @author CGD
 *
 */
public class BeanMapListMsgBuilder {

  protected BeanMapListMsgBuilder() {

  }

  public static BasicTestMessageMap getMapNull() {
    return BasicTestMessageMap.newBuilder().build();
  }

  public static BasicTestMessageMap getMapEmpty() {
    return BasicTestMessageMap.newBuilder().putAllTestStrMap(Collections.emptyMap()).build();
  }

  /** Full Map . */
  public static BasicTestMessageMap getMapFull() {
    Map<String, String> maps = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("a", "a----a");
        put("b", "b----b");
        put("c", "c----c");
      }
    };
    BasicTestMessageMap map = BasicTestMessageMap.newBuilder().putAllTestStrMap(maps).build();
    return map;
  }

  /** Default Map . */
  public static BasicTestMessageMap getMapDefault() {
    Map<String, String> maps = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("a", "a----a");
        put("b", "b----b");
        put("c", "c----c");
        put("d", "");
        put("", "IS NULL");
      }
    };
    BasicTestMessageMap map = BasicTestMessageMap.newBuilder().putAllTestStrMap(maps).build();
    return map;
  }

  public static BasicTestIntMessageList getIntListNull() {
    return BasicTestIntMessageList.newBuilder().build();
  }

  public static BasicTestIntMessageList getIntListFull() {
    List<Integer> list = Arrays.asList(1, 2, 3);
    return BasicTestIntMessageList.newBuilder().addAllTestIntList(list).build();
  }

  public static BasicTestMessageList getListNull() {
    return BasicTestMessageList.newBuilder().build();
  }

  public static BasicTestMessageList getListEmpty() {
    return BasicTestMessageList.newBuilder().addAllTestStrList(Collections.emptyList()).build();
  }

  public static BasicTestMessageList getListFull() {
    List<String> list = Arrays.asList("a", "b", "c");
    return BasicTestMessageList.newBuilder().addAllTestStrList(list).build();
  }

  public static BasicTestMessageList getListDefault() {
    List<String> list = Arrays.asList("a", "b", "c", "");
    return BasicTestMessageList.newBuilder().addAllTestStrList(list).build();
  }
}
