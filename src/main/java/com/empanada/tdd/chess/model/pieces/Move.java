package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.Coordinate;

public interface Move {

  boolean canMove(Coordinate origin, Coordinate destination);

  void setUpValidMoves();
}
