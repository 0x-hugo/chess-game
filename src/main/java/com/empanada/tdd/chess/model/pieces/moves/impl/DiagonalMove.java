package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.table.Coordinate;

public class DiagonalMove implements Move {
  private int stepsAllowed = 0;

  private DiagonalMove(int steps) {
    stepsAllowed = steps;
  }

  public static DiagonalMove withSteps(int steps) {
    return new DiagonalMove(steps);
  }

  public static DiagonalMove withAnySteps() {
    return new DiagonalMove(ANY_STEPS);
  }

  @Override
  public void apply(Coordinate coordinate) {
    coordinate.incrementHorizontal(stepsAllowed);
    coordinate.incrementVertical(stepsAllowed);
  }

}
