package com.empanada.tdd.chess.model.pieces;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.moves.Move;

public abstract class MoveDecorator implements Move {
  protected Move possibleMove;

  public MoveDecorator(Move move) {
    super();
    this.possibleMove = move;
  }

  public boolean canMove(ChessCoordinate origin, ChessCoordinate destination) {
    return true;
  }

  public abstract void setupRules();

  public abstract MoveDecorator add(Move possibleMove);

  public abstract MoveDecorator allowed(int stepsAllowed);

  public abstract MoveDecorator onlyIf(boolean condition);

  protected boolean eatOther() {
    return true;
  }

  protected int any() {
    return -1;
  }

//  public AbstractMove addMove(AbstractMove nextMove) {
//    AbstractMove lastMove = this;
//
//    while (lastMove.possibleMove != null) {
//      lastMove = lastMove.possibleMove;
//    }
//
//    lastMove.possibleMove = nextMove;
//
//    return this;
//  }
//
//  public RuleStatus validMove(ChessCoordinate origin, ChessCoordinate destination) {
//    if (possibleMove == null)
//      return RuleStatus.invalid("Invalid move.");
//
//    return possibleMove.validMove(origin, destination);
//  }

}
