package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.Movement;

public class HorizontalMovement implements Movement {
  private int stepsAllowed = 0;

  public HorizontalMovement(int i) {
    stepsAllowed = i;
  }

  @Override
  public void apply(Coordinate origin, Coordinate destination) {

  }

}
