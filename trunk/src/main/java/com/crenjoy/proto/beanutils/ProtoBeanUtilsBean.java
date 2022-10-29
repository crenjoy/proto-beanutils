package com.crenjoy.proto.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ContextClassLoaderLocal;
import org.apache.commons.beanutils.PropertyUtilsBean;

/**
 * <p>
 * JavaBean property population methods.
 * </p>
 *
 * <p>
 * This class provides implementations for the utility methods in
 * {@link BeanUtils}. Different instances can be used to isolate caches between
 * classloaders and to vary the value converters registered.
 * </p>
 *
 * @see BeanUtils
 * @since 1.7
 */
public class ProtoBeanUtilsBean extends BeanUtilsBean {

  /**
   * Contains {@code BeanUtilsBean} instances indexed by context classloader.
   */
  private static final ContextClassLoaderLocal<ProtoBeanUtilsBean> PROTO_BEANS_BY_CLASSLOADER = new ContextClassLoaderLocal<ProtoBeanUtilsBean>() {
    // Creates the default instance used when the context classloader is unavailable
    @Override
    protected ProtoBeanUtilsBean initialValue() {
      return new ProtoBeanUtilsBean();
    }
  };

  /**
   * Gets the instance which provides the functionality for {@link BeanUtils}.
   * This is a pseudo-singleton - an single instance is provided per (thread)
   * context classloader. This mechanism provides isolation for web apps deployed
   * in the same container.
   *
   * @return The (pseudo-singleton) BeanUtils bean instance
   */
  public static ProtoBeanUtilsBean getInstance() {
    return PROTO_BEANS_BY_CLASSLOADER.get();
  }

  /**
   * Sets the instance which provides the functionality for {@link BeanUtils}.
   * This is a pseudo-singleton - an single instance is provided per (thread)
   * context classloader. This mechanism provides isolation for web apps deployed
   * in the same container.
   *
   * @param newInstance The (pseudo-singleton) BeanUtils bean instance
   */
  public static void setInstance(final ProtoBeanUtilsBean newInstance) {
    PROTO_BEANS_BY_CLASSLOADER.set(newInstance);
  }

  /**
   * <p>
   * Constructs an instance using new property and conversion instances.
   * </p>
   */
  public ProtoBeanUtilsBean() {
    super(new ProtoConvertUtilsBean(), new PropertyUtilsBean());
  }

}
