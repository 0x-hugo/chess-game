package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.messaging.Coordinate;

public interface Movement {

  void apply(Coordinate origin, Coordinate destination);
}
