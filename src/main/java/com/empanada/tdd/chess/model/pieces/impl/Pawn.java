package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.Piece;

public class Pawn extends Piece {

  @Override
  public String draw() {
    return null;
  }

  @Override
  public boolean canMove(ChessCoordinate origin, ChessCoordinate destination) {
//    if (origin.sameVerticalAs(destination)) {
//      if (origin.forward(destination) == 1)
//        return true;
//      if (origin.forward(destination) == 2)
//        return isPieceToEat();
//    }
    return true;
  }

}
