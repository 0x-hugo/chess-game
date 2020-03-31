package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.Movement;

public class VerticalMovement implements Movement {
  private int stepsAllowed = 0;

  public VerticalMovement(int i) {
    stepsAllowed = i;
  }

  @Override
  public void apply(Coordinate origin, Coordinate destination) {

  }

}
