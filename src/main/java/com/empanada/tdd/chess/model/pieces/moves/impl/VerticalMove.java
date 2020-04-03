package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.table.Coordinate;

public class VerticalMove implements Move {
  private int stepsAllowed = 0;

  private VerticalMove(int i) {
    stepsAllowed = i;
  }

  public static VerticalMove withSteps(int steps) {
    return new VerticalMove(steps);
  }

  public static VerticalMove withAnySteps() {
    return new VerticalMove(ANY_STEPS);
  }

  @Override
  public void apply(Coordinate coordinate) {
    coordinate.incrementVertical(stepsAllowed);
  }

}
