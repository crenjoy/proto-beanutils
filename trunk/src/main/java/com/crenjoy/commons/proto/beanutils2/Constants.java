package com.crenjoy.commons.proto.beanutils2;

/**
 * 日期格式.
 *
 * @author CGD
 *
 */
public class Constants {

  public static String[] getInstant() {
    return new String[] { "yyyy-MM-dd'T'HH:mm:ss.nX" };
  }
  
  public static String[] getZonedDateTime() {
    return new String[] {"yyyy-MM-dd'T'HH:mm:ss.nxxx'['VV']'" };
  }
  
  public static String[] getOffsetDateTime() {
    return new String[] {"yyyy-MM-dd'T'HH:mm:ss.nxxx" };
  }

  public static String[] getLocalDateTime() {
    String[] patterns = new String[] { "yyyy-MM-dd'T'HH:mm:ss.n", "yyyy-MM-dd HH:mm:ss.SSS",
        "yyyy/MM/dd HH:mm:ss SSS", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd HH:mm",
        "yyyy/MM/dd HH:mm" };
    return new ArrayBuilder<String>(patterns).concat(getLocalDate()).builder(new String[0]);
  }

  public static String[] getLocalDate() {
    return new String[] { "yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日", "yyyy-MM", "yyyy/MM",
        "yyyy年MM月" };
  }

  public static String[] getLocalTime() {
    return new String[] { "HH:mm:ss.SSS", "HH:mm:ss", "HH:mm" };
  }

}
