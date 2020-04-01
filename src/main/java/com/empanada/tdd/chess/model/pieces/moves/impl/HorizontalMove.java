package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.Move;

public class HorizontalMove implements Move {
  private int stepsAllowed = 0;

  public HorizontalMove(int i) {
    stepsAllowed = i;
  }

  @Override
  public void apply(Coordinate origin, Coordinate destination) {

  }

}
