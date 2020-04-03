package com.empanada.tdd.chess.model.pieces.impl;

import java.util.ArrayList;
import java.util.List;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Bishop extends AbstractPiece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    final List<Move> moves = new ArrayList<>();
    moves.add(VerticalMove.withSteps(5));
    addValidMove(Movement.of(moves));

  }
}
