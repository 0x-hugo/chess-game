package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.model.pieces.Piece;

public interface Table {

  void init();

  Cell getCellAt(Position position);

  Cell getCellAt(Character x, Integer y);

  Piece getPieceAt(Position position);

  void killPiece(Position position);

  void movePiece(Position origin, Position destiny);

}
