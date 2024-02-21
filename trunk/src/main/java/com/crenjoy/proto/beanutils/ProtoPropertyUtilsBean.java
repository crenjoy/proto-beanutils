package com.crenjoy.proto.beanutils;

import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 * ProtoPropertyUtils bean.
 *
 * @author cgd
 */
public class ProtoPropertyUtilsBean extends PropertyUtilsBean {


  /**
   * Return the ProtoPropertyUtils bean instance.
   *
   * @return The ProtoPropertyUtils bean instance
   */
  protected static ProtoPropertyUtilsBean getInstance() {
    return (ProtoPropertyUtilsBean) ProtoBeanUtilsBean.getInstance().getPropertyUtils();
  }


}
