
package com.crenjoy.proto.beanutils.bean.test;

import java.util.Arrays;
import java.util.Objects;

/**
 * Basic Test Bean.
 *
 * @author CGD
 *
 */
public class Basic1Test2Bean {

  double testDouble;
  float testFloat;
  int testInt32;
  long testInt64;
  int testUint32;
  long testUint64;
  int testSint32;
  long testSint64;
  int testFixed32;
  long testFixed64;
  int testSfixed32;
  long testSfixed64;
  boolean testBool;
  String testString;
  byte[] testBytes;

  public double getTestDouble() {
    return testDouble;
  }

  public void setTestDouble(double testDouble) {
    this.testDouble = testDouble;
  }

  public float getTestFloat() {
    return testFloat;
  }

  public void setTestFloat(float testFloat) {
    this.testFloat = testFloat;
  }

  public int getTestInt32() {
    return testInt32;
  }

  public void setTestInt32(int testInt32) {
    this.testInt32 = testInt32;
  }

  public long getTestInt64() {
    return testInt64;
  }

  public void setTestInt64(long testInt64) {
    this.testInt64 = testInt64;
  }

  public int getTestUint32() {
    return testUint32;
  }

  public void setTestUint32(int testUint32) {
    this.testUint32 = testUint32;
  }

  public long getTestUint64() {
    return testUint64;
  }

  public void setTestUint64(long testUint64) {
    this.testUint64 = testUint64;
  }

  public int getTestSint32() {
    return testSint32;
  }

  public void setTestSint32(int testSint32) {
    this.testSint32 = testSint32;
  }

  public long getTestSint64() {
    return testSint64;
  }

  public void setTestSint64(long testSint64) {
    this.testSint64 = testSint64;
  }

  public int getTestFixed32() {
    return testFixed32;
  }

  public void setTestFixed32(int testFixed32) {
    this.testFixed32 = testFixed32;
  }

  public long getTestFixed64() {
    return testFixed64;
  }

  public void setTestFixed64(long testFixed64) {
    this.testFixed64 = testFixed64;
  }

  public int getTestSfixed32() {
    return testSfixed32;
  }

  public void setTestSfixed32(int testSfixed32) {
    this.testSfixed32 = testSfixed32;
  }

  public long getTestSfixed64() {
    return testSfixed64;
  }

  public void setTestSfixed64(long testSfixed64) {
    this.testSfixed64 = testSfixed64;
  }

  public boolean isTestBool() {
    return testBool;
  }

  public void setTestBool(boolean testBool) {
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
    Basic1Test2Bean other = (Basic1Test2Bean) obj;
    return testBool == other.testBool && Arrays.equals(testBytes, other.testBytes)
        && Double.doubleToLongBits(testDouble) == Double.doubleToLongBits(other.testDouble)
        && testFixed32 == other.testFixed32 && testFixed64 == other.testFixed64
        && Float.floatToIntBits(testFloat) == Float.floatToIntBits(other.testFloat)
        && testInt32 == other.testInt32 && testInt64 == other.testInt64
        && testSfixed32 == other.testSfixed32 && testSfixed64 == other.testSfixed64
        && testSint32 == other.testSint32 && testSint64 == other.testSint64
        && Objects.equals(testString, other.testString) && testUint32 == other.testUint32
        && testUint64 == other.testUint64;
  }

}
