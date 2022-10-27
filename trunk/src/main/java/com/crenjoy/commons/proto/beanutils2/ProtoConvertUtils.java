package com.crenjoy.commons.proto.beanutils2;

import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.beanutils2.BeanUtilsBean;
import org.apache.commons.beanutils2.ConvertUtils;

/**
 * ProtoConvert.
 * 
 * @author CGD
 *
 */
public class ProtoConvertUtils extends ConvertUtils {

  public static void init() {
    initLocale();

    if (!(BeanUtilsBean.getInstance().getConvertUtils() instanceof ProtoConvertUtilsBean)) {
      BeanUtilsBean.setInstance(new BeanUtilsBean(new ProtoConvertUtilsBean()));
    }

  }

  public static void initLocale() {
    Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
    final TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
    TimeZone.setDefault(timeZone);
  }

}
