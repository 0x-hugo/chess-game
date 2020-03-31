package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

import com.empanada.tdd.chess.messaging.Coordinate;

/**
 * Chain of movements to validate per each piece before a move
 */
public class AbstractMove {

  private final List<Movement> movements;

  public static AbstractMove of(List<Movement> movements) {
    final List<Movement> copy = new ArrayList<>(movements);
    return new AbstractMove(copy);
  }

  private AbstractMove(List<Movement> movements) {
    this.movements = movements;
  }

  public boolean isValid(Coordinate origin, Coordinate destination) {
    final Coordinate startPos = origin;
    final Coordinate endPos = destination;
    movements.forEach(movement -> movement.apply(startPos, endPos));
    return startPos.equals(endPos);
  }

}
