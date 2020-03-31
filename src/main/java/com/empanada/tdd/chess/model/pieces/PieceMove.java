package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.Coordinate;
import com.empanada.tdd.chess.model.pieces.moves.AbstractMove;

public abstract class PieceMove {

  AbstractMove moves;

  public abstract boolean canMove(Coordinate origin, Coordinate destination);

  public abstract void setUpValidMoves();

}
