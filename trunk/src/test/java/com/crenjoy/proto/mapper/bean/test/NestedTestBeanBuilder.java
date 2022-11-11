
package com.crenjoy.proto.mapper.bean.test;

import java.util.Collections;

public class NestedTestBeanBuilder {

  protected NestedTestBeanBuilder() {

  }

  public static NestedTestBean getNull() {
    return new NestedTestBean();
  }

  public static NestedTestBean getEmpty() {
    NestedTestBean bean = new NestedTestBean();
    bean.setTestString("");
    bean.setTestStrMap(Collections.emptyMap());
    bean.setTestBasicMap(Collections.emptyMap());
    bean.setTestStrList(Collections.emptyList());
    bean.setTestBasicList(Collections.emptyList());
    return bean;
  }

  public static NestedTestBean getMin() {
    NestedTestBean bean = new NestedTestBean();
    bean.setTestString("1234567890ABCDEF");
    bean.setTestDouble(Double.MIN_VALUE);
    bean.setTestBool(false);
    bean.setTestBasicBean(Basic2TestBeanBuilder.getMin());
    bean.setTestStrMap(BeanMapListBuilder.getMapDefault().getTestStrMap());
    bean.setTestBasicMap(TestBeanBuilder.getMapNull().getTestBasicMap());
    bean.setTestStrList(BeanMapListBuilder.getListDefault().getTestStrList());
    bean.setTestBasicList(TestBeanBuilder.getListNull().getTestBasicList());
    bean.setTestMessageList(TestBeanBuilder.getListNull());
    bean.setTestMessageMap(TestBeanBuilder.getMapNull());
    return bean;
  }

  public static NestedTestBean getMax() {
    NestedTestBean bean = new NestedTestBean();
    bean.setTestString("0000000000");
    bean.setTestDouble(Double.MAX_VALUE);
    bean.setTestBool(true);
    bean.setTestBasicBean(Basic2TestBeanBuilder.getMax());
    bean.setTestStrMap(BeanMapListBuilder.getMapFull().getTestStrMap());
    bean.setTestBasicMap(TestBeanBuilder.getMapFull().getTestBasicMap());
    bean.setTestStrList(BeanMapListBuilder.getListFull().getTestStrList());
    bean.setTestBasicList(TestBeanBuilder.getListFull().getTestBasicList());
    bean.setTestMessageList(TestBeanBuilder.getListFull());
    bean.setTestMessageMap(TestBeanBuilder.getMapFull());
    return bean;
  }

}
