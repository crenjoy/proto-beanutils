package com.crenjoy.proto.beanutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组Builder.
 *
 * @author CGD
 *
 * @param <T> 数组类型
 */
public class ArrayBuilder<T> {

  private List<T> list;

  public ArrayBuilder() {
    list = new ArrayList<>();
  }

  public ArrayBuilder(T[] t) {
    list = new ArrayList<>();
    list.addAll(Arrays.asList(t));
  }

  public ArrayBuilder<T> concat(T[] c) {
    list.addAll(Arrays.asList(c));
    return this;
  }

  public T[] builder(T[] t) {
    return list.toArray(t);
  }

  public Object[] builder() {
    return list.toArray();
  }

}
