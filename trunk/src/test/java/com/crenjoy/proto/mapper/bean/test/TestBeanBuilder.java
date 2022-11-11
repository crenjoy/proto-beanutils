
package com.crenjoy.proto.mapper.bean.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestBeanBuilder {

  protected TestBeanBuilder() {

  }

  public static TestBeanList getListNull() {
    return new TestBeanList();
  }

  public static TestBeanList getListFull() {
    TestBeanList bean = new TestBeanList();
    List<Basic2TestBean> list = new ArrayList<>();
    list.add(new Basic2TestBean());

    list.add(Basic2TestBeanBuilder.getMax());
    list.add(Basic2TestBeanBuilder.getMin());
    list.add(Basic2TestBeanBuilder.getEmpty());
    bean.setTestBasicList(list);
    return bean;
  }

  public static TestBeanMap getMapNull() {
    return new TestBeanMap();
  }

  public static TestBeanMap getMapFull() {
    TestBeanMap bean = new TestBeanMap();
    Map<String, Basic2TestBean> map = new HashMap<>();
    map.put("Null", new Basic2TestBean());
    map.put("Max", Basic2TestBeanBuilder.getMax());
    map.put("Min", Basic2TestBeanBuilder.getMin());
    map.put("Zero", Basic2TestBeanBuilder.getEmpty());
    bean.setTestBasicMap(map);
    return bean;
  }

}
