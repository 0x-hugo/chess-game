package com.empanada.tdd.chess.model.pieces.moves;

import com.empanada.tdd.chess.model.pieces.Move;

/**
 * It defines each movement for the piece
 */
public abstract class MoveBuilder {
  protected Movement move;

  public MoveBuilder(Movement move) {
    super();
    this.move = move;
  }

  public abstract void setupRules();

  public abstract MoveBuilder add(Move possibleMove);

  public abstract MoveBuilder allowed(int stepsAllowed);

  public abstract MoveBuilder onlyIf(boolean condition);

  protected boolean eatOther() {
    return true;
  }

  protected int any() {
    return -1;
  }
}
