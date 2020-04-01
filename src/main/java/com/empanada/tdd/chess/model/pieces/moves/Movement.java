package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

import com.empanada.tdd.chess.messaging.Coordinate;

/**
 * Chain of moves validations
 */
public class Movement {

  private final List<Move> moves;

  public static Movement of(List<Move> moves) {
    final List<Move> copy = new ArrayList<>(moves);
    return new Movement(copy);
  }

  private Movement(List<Move> moves) {
    this.moves = moves;
  }

  public boolean isValid(Coordinate origin, Coordinate destination) {
    final Coordinate startPos = origin;
    final Coordinate endPos = destination;
    moves.forEach(movement -> movement.apply(startPos, endPos));
    return startPos.equals(endPos);
  }

}
