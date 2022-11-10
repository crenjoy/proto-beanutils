
package com.crenjoy.proto.mapper.bean.test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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

  @Override
  public String toString() {
    return "NestedTestBean [testString=" + testString + ", testDouble=" + testDouble + ", testBool="
        + testBool + ", testBasicBean=" + testBasicBean + ", testStrMap=" + testStrMap
        + ", testBasicMap=" + testBasicMap + ", testStrList=" + testStrList + ", testBasicList="
        + testBasicList + ", testMessageList=" + testMessageList + ", testMessageMap="
        + testMessageMap + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(testBasicBean, testBasicList, testBasicMap, testBool, testDouble,
        testMessageList, testMessageMap, testStrList, testStrMap, testString);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    NestedTestBean other = (NestedTestBean) obj;
    return Objects.equals(testBasicBean, other.testBasicBean)
        && Objects.equals(testBasicList, other.testBasicList)
        && Objects.equals(testBasicMap, other.testBasicMap) && testBool == other.testBool
        && Double.doubleToLongBits(testDouble) == Double.doubleToLongBits(other.testDouble)
        && Objects.equals(testMessageList, other.testMessageList)
        && Objects.equals(testMessageMap, other.testMessageMap)
        && Objects.equals(testStrList, other.testStrList)
        && Objects.equals(testStrMap, other.testStrMap)
        && Objects.equals(testString, other.testString);
  }

}
