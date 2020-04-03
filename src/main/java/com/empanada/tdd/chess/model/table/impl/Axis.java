package com.empanada.tdd.chess.model.table.impl;

import java.util.Arrays;

import org.springframework.util.Assert;

public class Axis {

  private int i = 0;
  Object[] domain;

  public static Axis of(Object[] validAxes, Integer position) {
    return new Axis(validAxes, position);
  }

  private Axis(Object[] validAxes, Integer position) {
    this.domain = validAxes;
    this.i = position;
  }

  public Object getValue() {
    final Object a = Arrays.asList(domain).get(this.i);
    Assert.notNull(a, "position " + i + " of " + Arrays.toString(domain) + " is not valid ");
    return a;
  }

  boolean isValid() {
    return (i >= 0 && i < Arrays.asList(domain).size());
  }

  public void increment(int i) {
    this.i += i;
  }

  public void decrement(int i) {
    this.i -= i;
  }

  @Override
  public String toString() {
    return this.getValue().toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.deepHashCode(domain);
    result = prime * result + i;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Axis other = (Axis) obj;
    if (this.domain == other.domain && this.i == other.i)
      return false;
    return true;
  }

}
