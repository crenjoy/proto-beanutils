
package com.crenjoy.proto.mapper.bean.test;

import java.util.Objects;

/**
 * Basic2 Test Bean.
 *
 * @author CGD
 *
 */
public class Basic2TestBean {

  String testString = "";
  int testInt32;
  boolean testBool;
  float testFloat;

  public String getTestString() {
    return testString;
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

  public Integer getTestInt32() {
    return testInt32;
  }

  public void setTestInt32(Integer testInt32) {
    this.testInt32 = testInt32;
  }

  public Boolean getTestBool() {
    return testBool;
  }

  public void setTestBool(Boolean testBool) {
    this.testBool = testBool;
  }

  public Float getTestFloat() {
    return testFloat;
  }

  public void setTestFloat(Float testFloat) {
    this.testFloat = testFloat;
  }

  @Override
  public int hashCode() {
    return Objects.hash(testBool, testFloat, testInt32, testString);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Basic2TestBean other = (Basic2TestBean) obj;
    return Objects.equals(testBool, other.testBool) && Objects.equals(testFloat, other.testFloat)
        && Objects.equals(testInt32, other.testInt32)
        && Objects.equals(testString, other.testString);
  }

}
