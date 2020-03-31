package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMove;

public class DiagonalMove extends AbstractMove {

  @Override
  public boolean canMove(Coordinate origin, Coordinate destination) {
    if (!applyMoves(origin, destination))
      return false;

    return super.isValid(origin, destination);
  }

  private boolean applyMoves(Coordinate origin, Coordinate destination) {
    return false;
  }

}
