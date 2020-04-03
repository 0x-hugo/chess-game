package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;

public class King extends AbstractPiece {

  private final String name = "King";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {

  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }

}
