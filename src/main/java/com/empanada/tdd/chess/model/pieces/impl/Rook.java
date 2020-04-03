package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.MovementBuilder;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Rook extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    MovementBuilder builder = new MovementBuilder();
    builder = builder.use(HorizontalMove.withSteps(0));
    builder = builder.and();
    builder = builder.use(VerticalMove.withSteps(0));
    final Movement rookMove = builder.create();

    super.addValidMove(rookMove);
  }

}
