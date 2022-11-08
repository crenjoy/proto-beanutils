
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
    Basic2TestBean bt = new Basic2TestBean();
    bt.setTestBool(true);
    bt.setTestFloat(Float.MAX_VALUE);
    bt.setTestInt32(Integer.MAX_VALUE);
    bt.setTestString("");
    list.add(bt);
    Basic2TestBean bt1 = new Basic2TestBean();
    bt1.setTestBool(false);
    bt1.setTestFloat(Float.MIN_VALUE);
    bt1.setTestInt32(Integer.MIN_VALUE);
    bt1.setTestString("");
    list.add(bt1);
    Basic2TestBean bt2 = new Basic2TestBean();
    bt2.setTestBool(true);
    bt2.setTestFloat(0f);
    bt2.setTestInt32(0);
    bt2.setTestString("123");
    list.add(bt2);
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
    Basic2TestBean bt = new Basic2TestBean();
    bt.setTestBool(true);
    bt.setTestFloat(Float.MAX_VALUE);
    bt.setTestInt32(Integer.MAX_VALUE);
    bt.setTestString("");
    map.put("Max", bt);
    Basic2TestBean bt1 = new Basic2TestBean();
    bt1.setTestBool(false);
    bt1.setTestFloat(Float.MIN_VALUE);
    bt1.setTestInt32(Integer.MIN_VALUE);
    bt1.setTestString("");
    map.put("Min", bt1);
    Basic2TestBean bt2 = new Basic2TestBean();
    bt2.setTestBool(true);
    bt2.setTestFloat(0f);
    bt2.setTestInt32(0);
    bt2.setTestString("123");
    map.put("Zero", bt2);
    bean.setTestBasicMap(map);
    return bean;
  }

}
