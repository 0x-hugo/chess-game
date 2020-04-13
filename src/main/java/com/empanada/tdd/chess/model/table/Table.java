package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.shared.ExecutionResult;

public interface Table {

  void init();

  Piece getPieceAt(Coordinate position);

  void killPiece(Coordinate position);

  void eat(Coordinate origin, Coordinate destination);

  ExecutionResult move(Coordinate origin, Coordinate destination);

  boolean isOutOfBounds(Coordinate position);

}
