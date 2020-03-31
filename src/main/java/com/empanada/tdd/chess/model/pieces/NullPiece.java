package com.empanada.tdd.chess.model.pieces;

public class NullPiece extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
  }

}
