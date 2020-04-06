package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.impl.ChessCoordinate;

public class HorizontalMove implements Move {
  private int stepsAllowed = DEFAULT_STEPS;
  private boolean isAny = false;

  private HorizontalMove(int steps) {
    stepsAllowed = steps;
  }

  private HorizontalMove(boolean isAny) {
    this.isAny = isAny;
  }

  public HorizontalMove(boolean isAny, int stepsToJumpPerIteration) {
    this.isAny = isAny;
    this.stepsAllowed = stepsToJumpPerIteration;
  }

  public static HorizontalMove withSteps(int steps) {
    return new HorizontalMove(steps);
  }

  public static HorizontalMove withAnySteps() {
    return new HorizontalMove(true);
  }

  // TODO: To refactor into a builder
  public static HorizontalMove withAnyStepsWithJumps(int stepsToJumpPerIteration) {
    return new HorizontalMove(true, stepsToJumpPerIteration);
  }

  @Override
  public void apply(Coordinate coordinate) {
    coordinate.incrementHorizontal(stepsAllowed);
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
