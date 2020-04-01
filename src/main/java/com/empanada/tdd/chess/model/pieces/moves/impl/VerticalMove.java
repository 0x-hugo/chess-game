package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.Move;

public class VerticalMove implements Move {
  private int stepsAllowed = 0;

  public VerticalMove(int i) {
    stepsAllowed = i;
  }

  @Override
  public void apply(Coordinate origin, Coordinate destination) {

  }

}
