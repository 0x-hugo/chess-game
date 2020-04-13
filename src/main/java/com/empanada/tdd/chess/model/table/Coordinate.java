package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.model.table.impl.Axis;

//TODO: to refactor into a real abstraction
public interface Coordinate {

  Axis getHorizontal();

  Axis getVertical();

  Object[] getDomainHorizontal();

  Object[] getDomainVertical();

  void incrementHorizontal(int i);

  void incrementVertical(int i);

  boolean isValid();

}
