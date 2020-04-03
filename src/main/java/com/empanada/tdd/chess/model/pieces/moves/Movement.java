package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.impl.ChessCoordinate;

/**
 * Chain of moves that modifies coordinates. If moves get you to the
 * destination, it is a valid movement.
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
    final Coordinate endPositionAfterMovement = copyOf(origin);
    moves.forEach(movement -> movement.apply(endPositionAfterMovement));
    return endPositionAfterMovement.equals(destination);
  }

  private Coordinate copyOf(Coordinate position) {
    return ChessCoordinate.of(
        (Character) position.getHorizontal().getValue(),
        (Integer) position.getVertical().getValue());
  }
}
