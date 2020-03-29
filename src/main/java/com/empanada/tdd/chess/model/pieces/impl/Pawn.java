package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.Piece;

public class Pawn extends Piece {

  @Override
  public String draw() {
    return null;
  }

//  @Override
//  public RuleStatus validMove(ChessCoordinate origin, ChessCoordinate destination) {
////    if (origin.sameVerticalAs(destination)) {
////      if (origin.forward(destination) == 1)
////        return true;
////      if (origin.forward(destination) == 2)
////        return isPieceToEat();
////    }
//    return RuleStatus.valid();
//  }
//
//  @Override
//  public void setupRules() {
//    if (possibleMove == null)
//      possibleMove = MoveVertical.allowed(1)
//          .add(MoveDiagonal.allowed(1).onlyIf(eatOther()));
//  }

}
