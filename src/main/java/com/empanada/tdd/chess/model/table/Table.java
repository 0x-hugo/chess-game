package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.shared.ExecutionResult;

public interface Table {

  void init();

  AbstractPiece getPieceAt(ChessCoordinate position);

  void killPiece(ChessCoordinate position);

  void eat(ChessCoordinate origin, ChessCoordinate destination);

  ExecutionResult move(Command command);

}
