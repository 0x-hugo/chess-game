package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.ChessCoordinate;

public abstract class Piece {

  private ChessCoordinate position;

  private Piece piece;

  public abstract String draw();

  public boolean canMove(ChessCoordinate origin, ChessCoordinate destination) {
    return true;
  }

}
