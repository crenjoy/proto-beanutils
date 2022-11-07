
package com.crenjoy.proto.beanutils.bean.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/**
 * Bean Map List Builder.
 *
 * @author CGD
 *
 */
public class BeanMapListBuilder {

  public static BasicTestBeanMap getMapNull() {
    return new BasicTestBeanMap();
  }

  /** Empty Map. */
  public static BasicTestBeanMap getMapEmpty() {
    BasicTestBeanMap map = new BasicTestBeanMap();
    map.testStrMap = Collections.emptyMap();
    return map;
  }

  /** Full Map. */
  public static BasicTestBeanMap getMapFull() {
    BasicTestBeanMap map = new BasicTestBeanMap();
    map.testStrMap = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("a", "a----a");
        put("b", "b----b");
        put("c", "c----c");
      }
    };
    return map;
  }
  
  /** Default Map. */
  public static BasicTestBeanMap getMapDefault() {
    BasicTestBeanMap map = new BasicTestBeanMap();
    map.testStrMap = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;

      {
        put("a", "a----a");
        put("b", "b----b");
        put("c", "c----c");
        put("d", "");
        put("", "IS NULL");
      }
    };
    return map;
  }

  /** Exception Map. */
  public static BasicTestBeanMap getMapException() {
    BasicTestBeanMap map = new BasicTestBeanMap();
    map.testStrMap = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;

      {
        put("a", "a----a");
        put("b", "b----b");
        put("c", "c----c");
        put("d", null);
        put(null, "IS NULL");
      }
    };
    return map;
  }

  public static BasicTestBeanList getListNull() {
    return new BasicTestBeanList();
  }

  /** Empty List. */
  public static BasicTestBeanList getListEmpty() {
    BasicTestBeanList list = new BasicTestBeanList();
    list.testStrList = Collections.emptyList();
    return list;
  }

  /** Full List. */
  public static BasicTestBeanList getListFull() {
    BasicTestBeanList list = new BasicTestBeanList();
    list.testStrList = Arrays.asList("a", "b", "c");
    return list;
  }
  
  /** Default List. */
  public static BasicTestBeanList getListDefault() {
    BasicTestBeanList list = new BasicTestBeanList();
    list.testStrList = Arrays.asList("a", "b", "c", "");
    return list;
  }

  /** Exception List. */
  public static BasicTestBeanList getListException() {
    BasicTestBeanList list = new BasicTestBeanList();
    list.testStrList = Arrays.asList("a", "b", "c", null);
    return list;
  }
}
