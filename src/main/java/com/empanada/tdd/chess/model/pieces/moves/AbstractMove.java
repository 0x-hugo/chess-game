package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.messaging.Coordinate;

/**
 * Chain of movements to validate per each piece before a move
 */
public abstract class AbstractMove implements Movement {

  private AbstractMove nextMove;

  public AbstractMove addValidMove(AbstractMove nextMove) {
    AbstractMove lastMove = this;

    while (lastMove.nextMove != null) {
      lastMove = lastMove.nextMove;
    }

    lastMove.nextMove = nextMove;

    return this;
  }

  protected boolean isValid(Coordinate origin, Coordinate destination) {
    if (nextMove == null)
      return true;

    return nextMove.canMove(origin, destination);
  }

}
