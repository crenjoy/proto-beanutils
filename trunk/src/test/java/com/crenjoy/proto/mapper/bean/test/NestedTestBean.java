
package com.crenjoy.proto.mapper.bean.test;

import java.util.List;
import java.util.Map;

/**
 * 嵌套.
 * 
 * @author CGD
 *
 */
public class NestedTestBean {

  String testString = "";
  double testDouble;
  boolean testBool;
  Basic2TestBean testBasicBean;
  Map<String, String> testStrMap;
  Map<String, Basic2TestBean> testBasicMap;
  List<String> testStrList;
  List<Basic2TestBean> testBasicList;
  TestBeanList testMessageList;
  TestBeanMap testMessageMap;

  public String getTestString() {
    return testString;
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

  public double getTestDouble() {
    return testDouble;
  }

  public void setTestDouble(double testDouble) {
    this.testDouble = testDouble;
  }

  public boolean isTestBool() {
    return testBool;
  }

  public void setTestBool(boolean testBool) {
    this.testBool = testBool;
  }

  public Basic2TestBean getTestBasicBean() {
    return testBasicBean;
  }

  public void setTestBasicBean(Basic2TestBean testBasicBean) {
    this.testBasicBean = testBasicBean;
  }

  public Map<String, String> getTestStrMap() {
    return testStrMap;
  }

  public void setTestStrMap(Map<String, String> testStrMap) {
    this.testStrMap = testStrMap;
  }

  public Map<String, Basic2TestBean> getTestBasicMap() {
    return testBasicMap;
  }

  public void setTestBasicMap(Map<String, Basic2TestBean> testBasicMap) {
    this.testBasicMap = testBasicMap;
  }

  public List<String> getTestStrList() {
    return testStrList;
  }

  public void setTestStrList(List<String> testStrList) {
    this.testStrList = testStrList;
  }

  public List<Basic2TestBean> getTestBasicList() {
    return testBasicList;
  }

  public void setTestBasicList(List<Basic2TestBean> testBasicList) {
    this.testBasicList = testBasicList;
  }

  public TestBeanList getTestMessageList() {
    return testMessageList;
  }

  public void setTestMessageList(TestBeanList testMessageList) {
    this.testMessageList = testMessageList;
  }

  public TestBeanMap getTestMessageMap() {
    return testMessageMap;
  }

  public void setTestMessageMap(TestBeanMap testMessageMap) {
    this.testMessageMap = testMessageMap;
  }

}
