package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.model.pieces.MoveDecorator;

public class MoveDiagonal extends MoveDecorator {

  private int stepsAllowed = 0;

  public MoveDiagonal(Move possibleMove, int stepsAllowed) {
    super(possibleMove);
    this.stepsAllowed = stepsAllowed;
  }

  public MoveDiagonal(Move move) {
    super(move);
  }

  @Override
  public MoveDecorator add(Move possibleMove) {
    return null;
  }

  @Override
  public MoveDecorator allowed(int stepsAllowed) {
    return null;
  }

  @Override
  public MoveDecorator onlyIf(boolean condition) {
    return null;
  }

  @Override
  public void setupRules() {
  }

}
