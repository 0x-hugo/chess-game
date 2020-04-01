package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.messaging.Coordinate;

public interface Move {

  /**
   * It modifies arguments. Do a safe copy
   */
  void apply(Coordinate origin, Coordinate destination);
}
