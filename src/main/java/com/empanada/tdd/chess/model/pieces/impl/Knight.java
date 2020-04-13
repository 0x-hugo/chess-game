package com.empanada.tdd.chess.model.pieces.impl;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Knight extends AbstractPiece {

  private static final String name = "Knight";

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    addValidMove(Movement.of(VerticalMove.withSteps(forward(2)), HorizontalMove.withSteps(forward(1))));
    addValidMove(Movement.of(VerticalMove.withSteps(forward(2)), HorizontalMove.withSteps(backward(1))));
    addValidMove(Movement.of(VerticalMove.withSteps(backward(2)), HorizontalMove.withSteps(forward(1))));
    addValidMove(Movement.of(VerticalMove.withSteps(backward(2)), HorizontalMove.withSteps(backward(1))));
    addValidMove(Movement.of(HorizontalMove.withSteps(forward(2)), VerticalMove.withSteps(forward(1))));
    addValidMove(Movement.of(HorizontalMove.withSteps(forward(2)), VerticalMove.withSteps(backward(1))));
    addValidMove(Movement.of(HorizontalMove.withSteps(backward(2)), VerticalMove.withSteps(forward(1))));
    addValidMove(Movement.of(HorizontalMove.withSteps(backward(2)), VerticalMove.withSteps(backward(1))));
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return getName();
  }

}
