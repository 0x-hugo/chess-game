package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.model.pieces.moves.DiagonalMove;
import com.empanada.tdd.chess.model.pieces.moves.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.VerticalMove;

public class King extends Piece implements DiagonalMove, VerticalMove, HorizontalMove {

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
    return 1;
  }

  @Override
  public int maxBackward() {
    return 1;
  }

}
