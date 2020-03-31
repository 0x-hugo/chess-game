package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMovement;
import com.empanada.tdd.chess.model.pieces.moves.MovementBuilder;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMovement;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMovement;

public class Pawn extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    final MovementBuilder builder = new MovementBuilder();
    final AbstractMovement pawnMove = builder.use(new HorizontalMovement(-1))
        .and().use(new VerticalMovement(0))
        .create();

    addValidMove(pawnMove);
  }

}
