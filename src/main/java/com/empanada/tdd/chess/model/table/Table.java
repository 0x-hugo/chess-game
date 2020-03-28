package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.ChessPosition;
import com.empanada.tdd.chess.model.pieces.Piece;

public interface Table {

  void init();

  Cell getCellAt(ChessPosition position);

  Cell getCellAt(Character x, Integer y);

  Piece getPieceAt(ChessPosition position);

  void killPiece(ChessPosition position);

  void movePiece(ChessPosition origin, ChessPosition destiny);

}
