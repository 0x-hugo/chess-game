package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.shared.exceptions.CoordinateException;

public class HorizontalMove implements Move {
  private int stepsAllowed = 0;

  private HorizontalMove(int steps) {
    stepsAllowed = steps;
  }

  public static HorizontalMove withSteps(int steps) {
    return new HorizontalMove(steps);
  }

  public static HorizontalMove withAnySteps() {
    return new HorizontalMove(ANY_STEPS);
  }

  @Override
  public void apply(Coordinate position) throws CoordinateException {
    position.incrementHorizontal(stepsAllowed);
  }

}
