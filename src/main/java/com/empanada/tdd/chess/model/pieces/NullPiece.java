package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.Coordinate;

public class NullPiece extends AbstractPiece {

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
