package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.impl.ChessCoordinate;

public class VerticalMove implements Move {
  private int stepsAllowed = DEFAULT_STEPS;
  private boolean isAny = false;

  private VerticalMove(int steps) {
    stepsAllowed = steps;
  }

  private VerticalMove(boolean isAny) {
    this.isAny = isAny;
  }

  public VerticalMove(boolean isAny, int stepsToJumpPerIteration) {
    this.isAny = isAny;
    this.stepsAllowed = stepsToJumpPerIteration;
  }

  public static VerticalMove withSteps(int steps) {
    return new VerticalMove(steps);
  }

  public static VerticalMove withAnySteps() {
    return new VerticalMove(true);
  }

  // TODO: To refactor into a builder
  public static VerticalMove withAnyStepsWithJumps(int stepsToJumpPerIteration) {
    return new VerticalMove(true, stepsToJumpPerIteration);
  }

  @Override
  public void apply(Coordinate coordinate) {
    coordinate.incrementVertical(stepsAllowed);

  }

  @Override
  public boolean hasAnyStepsAllowed() {
    return isAny;
  }

  @Override
  public boolean isValid(Coordinate origin, Coordinate destination) {
    final Coordinate endPositionAfterMovement = copyOf(origin);

    if (isAny) {
      while (endPositionAfterMovement.isValid()) {
        if (endPositionAfterMovement.equals(destination))
          return true;
        apply(endPositionAfterMovement);
      }
    } else {
      apply(endPositionAfterMovement);
    }

    return endPositionAfterMovement.equals(destination);
  }

  private Coordinate copyOf(Coordinate position) {
    return ChessCoordinate.of(
        (Character) position.getHorizontal().getValueInDomain(),
        (Integer) position.getVertical().getValueInDomain());
  }

}
