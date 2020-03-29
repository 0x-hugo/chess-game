package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.ChessCoordinate;

public class NullPiece extends Piece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public boolean canMove(ChessCoordinate chessPosition, ChessCoordinate destination) {
    return false;
  }

}
