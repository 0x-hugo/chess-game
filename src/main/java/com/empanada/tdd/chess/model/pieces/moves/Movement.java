package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.messaging.Coordinate;

public interface Movement {

  boolean canMove(Coordinate origin, Coordinate destination);
}
