package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.model.table.Coordinate;

public interface Move {

  int DEFAULT_STEPS = 1;

  /**
   * It modifies arguments. Do a safe copy
   */
  void apply(Coordinate coordinate);

  boolean hasAnyStepsAllowed();

  boolean isValid(Coordinate origin, Coordinate destination);

}
