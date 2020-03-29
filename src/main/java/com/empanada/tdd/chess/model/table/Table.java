package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.shared.ExecutionResult;

public interface Table {

  void init();

  Piece getPieceAt(ChessCoordinate position);

  void killPiece(ChessCoordinate position);

  void movePiece(ChessCoordinate origin, ChessCoordinate destination);

  ExecutionResult move(Command command);

  boolean canMove(ChessCoordinate origin, ChessCoordinate destination);

}
