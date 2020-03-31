package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.AbstractPiece;

public class Knight extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public boolean canMove(Coordinate origin, Coordinate destination) {
    return true;
  }

  @Override
  public void setUpValidMoves() {
  }

}
