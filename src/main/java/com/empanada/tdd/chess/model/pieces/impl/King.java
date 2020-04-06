package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.DiagonalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class King extends AbstractPiece {

  private static final String name = "King";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    super.addValidMove(Movement.of(HorizontalMove.withSteps(forward(1))));
    super.addValidMove(Movement.of(HorizontalMove.withSteps(backward(1))));
    super.addValidMove(Movement.of(VerticalMove.withSteps(forward(1))));
    super.addValidMove(Movement.of(VerticalMove.withSteps(backward(1))));
    super.addValidMove(Movement.of(DiagonalMove.withSteps(forward(1))));
    super.addValidMove(Movement.of(DiagonalMove.withSteps(backward(1))));
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
