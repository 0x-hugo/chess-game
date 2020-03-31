package com.empanada.tdd.chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMove;

public abstract class AbstractPiece implements Move {

  Logger logger = LogManager.getLogger(AbstractPiece.class.getName());

  private final List<AbstractMove> movements;

  public AbstractPiece() {
    movements = new ArrayList<>();
  }

  public boolean hasValidMovements(Coordinate origin, Coordinate destination) {
    for (final AbstractMove movement : movements) {
      if (movement.isValid(origin, destination))
        return true;
    }

    logger.debug("Cannot move from "
        + "[" + origin.getX().toString() + origin.getY().toString() + "]"
        + " to "
        + "[" + destination.getX() + destination.getY() + "]");
    return false;
  }

  protected AbstractPiece addValidMove(AbstractMove move) {
    movements.add(move);
    return this;
  }

  public abstract String draw();

}
