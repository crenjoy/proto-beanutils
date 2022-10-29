package com.crenjoy.proto.beanutils.bean.test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Basic Test Bean.
 *
 * @author CGD
 *
 */
public class Basic1TestBean {

  Double testDouble;
  Float testFloat;
  Integer testInt32;
  Long testInt64;
  Integer testUint32;
  Long testUint64;
  Integer testSint32;
  Long testSint64;
  Integer testFixed32;
  Long testFixed64;
  Integer testSfixed32;
  Long testSfixed64;
  Boolean testBool;
  String testString;
  byte[] testBytes;

  public Double getTestDouble() {
    return testDouble;
  }

  public void setTestDouble(Double testDouble) {
    this.testDouble = testDouble;
  }

  public Float getTestFloat() {
    return testFloat;
  }

  public void setTestFloat(Float testFloat) {
    this.testFloat = testFloat;
  }

  public Integer getTestInt32() {
    return testInt32;
  }

  public void setTestInt32(Integer testInt32) {
    this.testInt32 = testInt32;
  }

  public Long getTestInt64() {
    return testInt64;
  }

  public void setTestInt64(Long testInt64) {
    this.testInt64 = testInt64;
  }

  public Integer getTestUint32() {
    return testUint32;
  }

  public void setTestUint32(Integer testUint32) {
    this.testUint32 = testUint32;
  }

  public Long getTestUint64() {
    return testUint64;
  }

  public void setTestUint64(Long testUint64) {
    this.testUint64 = testUint64;
  }

  public Integer getTestSint32() {
    return testSint32;
  }

  public void setTestSint32(Integer testSint32) {
    this.testSint32 = testSint32;
  }

  public Long getTestSint64() {
    return testSint64;
  }

  public void setTestSint64(Long testSint64) {
    this.testSint64 = testSint64;
  }

  public Integer getTestFixed32() {
    return testFixed32;
  }

  public void setTestFixed32(Integer testFixed32) {
    this.testFixed32 = testFixed32;
  }

  public Long getTestFixed64() {
    return testFixed64;
  }

  public void setTestFixed64(Long testFixed64) {
    this.testFixed64 = testFixed64;
  }

  public Integer getTestSfixed32() {
    return testSfixed32;
  }

  public void setTestSfixed32(Integer testSfixed32) {
    this.testSfixed32 = testSfixed32;
  }

  public Long getTestSfixed64() {
    return testSfixed64;
  }

  public void setTestSfixed64(Long testSfixed64) {
    this.testSfixed64 = testSfixed64;
  }

  public Boolean getTestBool() {
    return testBool;
  }

  public void setTestBool(Boolean testBool) {
    this.testBool = testBool;
  }

  public String getTestString() {
    return testString;
  }

  public void setTestString(String testString) {
    this.testString = testString;
  }

  public byte[] getTestBytes() {
    return testBytes;
  }

  public void setTestBytes(byte[] testBytes) {
    this.testBytes = testBytes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(testBytes);
    result = prime * result + Objects.hash(testBool, testDouble, testFixed32, testFixed64,
        testFloat, testInt32, testInt64, testSfixed32, testSfixed64, testSint32, testSint64,
        testString, testUint32, testUint64);
    return result;
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
    Basic1TestBean other = (Basic1TestBean) obj;
    return Objects.equals(testBool, other.testBool) && Arrays.equals(testBytes, other.testBytes)
        && Objects.equals(testDouble, other.testDouble)
        && Objects.equals(testFixed32, other.testFixed32)
        && Objects.equals(testFixed64, other.testFixed64)
        && Objects.equals(testFloat, other.testFloat) && Objects.equals(testInt32, other.testInt32)
        && Objects.equals(testInt64, other.testInt64)
        && Objects.equals(testSfixed32, other.testSfixed32)
        && Objects.equals(testSfixed64, other.testSfixed64)
        && Objects.equals(testSint32, other.testSint32)
        && Objects.equals(testSint64, other.testSint64)
        && Objects.equals(testString, other.testString)
        && Objects.equals(testUint32, other.testUint32)
        && Objects.equals(testUint64, other.testUint64);
  }

  
}
