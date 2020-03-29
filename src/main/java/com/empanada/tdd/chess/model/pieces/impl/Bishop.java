package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.model.pieces.moves.DiagonalMove;

public class Bishop extends Piece implements DiagonalMove {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public boolean canMove(ChessCoordinate chessPosition, ChessCoordinate destination) {
    return true;
  }

  @Override
  public int maxForward() {
    return 0;
  }

  @Override
  public int maxBackward() {
    return 0;
  }

}
