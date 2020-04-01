package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.Coordinate;

public interface Piece {

  void setUpValidMoves();

  boolean hasValidMovements(Coordinate origin, Coordinate destination);
}
