package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.model.table.impl.Axis;

public interface Coordinate {

  Axis getHorizontal();

  Axis getVertical();

  void incrementHorizontal(int i);

  void incrementVertical(int i);

  boolean isValid();

  void setX();

  void setY();

}
