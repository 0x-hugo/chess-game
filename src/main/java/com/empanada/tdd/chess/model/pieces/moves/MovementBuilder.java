package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

/**
 * It defines each movement for the piece. DO NOT USE THIS BUILDER until its
 * working
 */
public class MovementBuilder {
  protected List<Move> moves;

  public static MovementBuilder of() {
    return new MovementBuilder();
  }

  public MovementBuilder() {
    this.moves = new ArrayList<>();
  }

  public Movement create() {
    return Movement.of(moves);
  }

  public MovementBuilder use(Move verticalMove) {
    moves.add(verticalMove);
    return this;
  }

  public MovementBuilder and() {
    return this;
  }
}
