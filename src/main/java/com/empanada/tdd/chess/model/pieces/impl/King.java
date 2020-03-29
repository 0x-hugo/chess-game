package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.Piece;

public class King extends Piece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public boolean canMove(ChessCoordinate chessPosition, ChessCoordinate destination) {
    return true;
  }

}
