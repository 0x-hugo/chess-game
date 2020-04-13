package com.empanada.tdd.chess.model.table.impl;

import java.util.Arrays;

import org.springframework.util.Assert;

import com.empanada.tdd.chess.shared.exceptions.CoordinateException;

public class Axis {

  private int positionInDomain = 0;
  Object[] domain;

  public static Axis of(Object[] validAxes, Object objPosition) {
    final int position = positionInArray(validAxes, objPosition);
    return new Axis(validAxes, position);
  }

  private static int positionInArray(Object[] validAxes, final Object objPosition) {
    final int a = Arrays.asList(validAxes).indexOf(objPosition);
    if (a == -1)
      throw new CoordinateException(
          "invalid position " + objPosition + " in array:[" + Arrays.toString(validAxes) + "]");
    return a;
  }

  private Axis(Object[] validAxes, Integer position) {
    this.domain = validAxes;
    this.positionInDomain = position;
  }

  public Object getValueInDomain() {
    final Object valueInDomain = Arrays.asList(domain).get(this.positionInDomain);
    Assert.notNull(valueInDomain, "position " + positionInDomain + " of " + Arrays.toString(domain) + " is not valid ");
    return valueInDomain;
  }

  boolean isValid() {
    return (positionInDomain >= 0 && positionInDomain < Arrays.asList(domain).size());
  }

  public void increment(int i) {
    this.positionInDomain += i;
  }

  public void decrement(int i) {
    this.positionInDomain -= i;
  }

  @Override
  public String toString() {
    return this.getValueInDomain().toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.deepHashCode(domain);
    result = prime * result + positionInDomain;
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
    final Axis otherAxis = (Axis) obj;
    return (this.domain == otherAxis.domain && this.positionInDomain == otherAxis.positionInDomain);
  }

}
