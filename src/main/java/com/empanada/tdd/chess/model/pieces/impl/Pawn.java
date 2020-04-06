package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Pawn extends AbstractPiece {

  private static final String name = "Pawn";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    addValidMove(Movement.of(VerticalMove.withSteps(1)));
    addValidMove(Movement.of(VerticalMove.withSteps(2)));
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
