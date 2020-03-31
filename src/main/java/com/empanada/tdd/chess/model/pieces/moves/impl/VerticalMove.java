package com.empanada.tdd.chess.model.pieces.moves.impl;

import com.empanada.tdd.chess.model.pieces.Move;
import com.empanada.tdd.chess.model.pieces.moves.MoveBuilder;

public class VerticalMove extends MoveBuilder {

  private int stepsAllowed = 0;

  public VerticalMove(Move possibleMove, int stepsAllowed) {
    super(possibleMove);
    this.stepsAllowed = stepsAllowed;
  }

  @Override
  public MoveBuilder add(Move possibleMove) {
    return null;
  }

  @Override
  public MoveBuilder allowed(int stepsAllowed) {
    return null;
  }

  @Override
  public MoveBuilder onlyIf(boolean condition) {
    return null;
  }

  @Override
  public void setupRules() {
  }
}
