package com.empanada.tdd.chess.model.pieces;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.table.Coordinate;

public abstract class AbstractPiece implements Piece {

  Logger logger = LogManager.getLogger(AbstractPiece.class.getName());

  private final List<Movement> movements;

  public AbstractPiece() {
    movements = new ArrayList<>();
  }

  @Override
  public boolean hasValidMovements(Coordinate origin, Coordinate destination) {
    for (final Movement movement : movements) {
      if (movement.isValid(origin, destination))
        return true;
    }

    logger.debug("Cannot move " + getName() + " from "
        + "[" + origin.getHorizontal().toString() + origin.getVertical().toString() + "]"
        + " to "
        + "[" + destination.getHorizontal().toString() + destination.getVertical().toString() + "]");
    return false;
  }

  protected AbstractPiece addValidMove(Movement move) {
    movements.add(move);
    return this;
  }

  public abstract String draw();

  protected static int forward(int i) {
    return i;
  }

  protected static int backward(int i) {
    return 0 - i;
  }
}
