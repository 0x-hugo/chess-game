package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.MovementBuilder;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Pawn extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    final MovementBuilder builder = new MovementBuilder();
    final Movement pawnMove = builder.use(HorizontalMove.withSteps(-1))
        .and().use(VerticalMove.withSteps(0))
        .create();

    addValidMove(pawnMove);
  }

}
