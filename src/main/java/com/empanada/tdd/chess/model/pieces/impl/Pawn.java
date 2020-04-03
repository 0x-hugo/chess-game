package com.empanada.tdd.chess.model.pieces.impl;

import java.util.Arrays;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Pawn extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    final Movement oneMove = Movement.of(Arrays.asList(VerticalMove.withSteps(1)));
    final Movement twoMove = Movement.of(Arrays.asList(VerticalMove.withSteps(2)));

    addValidMove(oneMove);
    addValidMove(twoMove);
  }

}
