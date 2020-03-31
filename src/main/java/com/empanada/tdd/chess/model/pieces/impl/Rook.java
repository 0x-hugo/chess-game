package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMovement;
import com.empanada.tdd.chess.model.pieces.moves.MovementBuilder;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMovement;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMovement;

public class Rook extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    MovementBuilder builder = new MovementBuilder();
    builder = builder.use(new HorizontalMovement(0));
    builder = builder.and();
    builder = builder.use(new VerticalMovement(0));
    final AbstractMovement rookMove = builder.create();

    super.addValidMove(rookMove);
  }

}
