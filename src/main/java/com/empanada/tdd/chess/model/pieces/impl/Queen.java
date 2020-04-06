package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.DiagonalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Queen extends AbstractPiece {

  private static final String name = "Queen";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    addValidMove(Movement.of(HorizontalMove.withAnySteps()));
    addValidMove(Movement.of(VerticalMove.withAnySteps()));
    addValidMove(Movement.of(DiagonalMove.withAnySteps()));
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
