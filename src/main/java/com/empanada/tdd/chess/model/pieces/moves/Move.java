package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.model.table.Coordinate;

public interface Move {

  int ANY_STEPS = 0;

  /**
   * It modifies arguments. Do a safe copy
   */
  void apply(Coordinate coordinate);

}
