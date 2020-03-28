package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.Piece;

public interface Table {

  void init();

  ChessPosition getCellAt(ChessCoordinate position);

  ChessPosition getCellAt(Character x, Integer y);

  Piece getPieceAt(ChessCoordinate position);

  void killPiece(ChessCoordinate position);

  void movePiece(ChessCoordinate origin, ChessCoordinate destination);

}
