package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

/**
 * It defines each movement for the piece
 */
public class MovementBuilder {
  protected List<Movement> moves;

  public static MovementBuilder of() {
    return new MovementBuilder();
  }

  public MovementBuilder() {
    this.moves = new ArrayList<>();
  }

  public AbstractMovement create() {
    return AbstractMovement.of(moves);
  }

  public MovementBuilder use(Movement verticalMove) {
    moves.add(verticalMove);
    return this;
  }

  public MovementBuilder and() {
    return this;
  }
}
