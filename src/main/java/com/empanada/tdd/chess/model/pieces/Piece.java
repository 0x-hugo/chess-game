package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.ChessCoordinate;

public abstract class Piece {

  public abstract String draw();

  public abstract boolean canMove(ChessCoordinate chessPosition, ChessCoordinate destination);

}
