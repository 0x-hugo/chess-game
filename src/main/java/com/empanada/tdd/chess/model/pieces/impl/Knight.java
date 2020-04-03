package com.empanada.tdd.chess.model.pieces.impl;

import java.util.Arrays;
import java.util.List;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.moves.Move;
import com.empanada.tdd.chess.model.pieces.moves.Movement;
import com.empanada.tdd.chess.model.pieces.moves.impl.HorizontalMove;
import com.empanada.tdd.chess.model.pieces.moves.impl.VerticalMove;

public class Knight extends AbstractPiece {

  private final String name = "Knight";

  private final List<Move> upRight = Arrays.asList(VerticalMove.withSteps(2),
      HorizontalMove.withSteps(1));

  private final List<Move> upLeft = Arrays.asList(VerticalMove.withSteps(2),
      HorizontalMove.withSteps(-1));

  private final List<Move> downRight = Arrays.asList(VerticalMove.withSteps(-2),
      HorizontalMove.withSteps(1));

  private final List<Move> downLeft = Arrays.asList(VerticalMove.withSteps(-2),
      HorizontalMove.withSteps(-1));

  private final List<Move> rightUp = Arrays.asList(HorizontalMove.withSteps(2),
      VerticalMove.withSteps(1));

  private final List<Move> leftUp = Arrays.asList(HorizontalMove.withSteps(-2),
      VerticalMove.withSteps(1));

  private final List<Move> rightDown = Arrays.asList(HorizontalMove.withSteps(2),
      VerticalMove.withSteps(-1));

  private final List<Move> leftDown = Arrays.asList(HorizontalMove.withSteps(-2),
      VerticalMove.withSteps(-1));

  @Override
  public String draw() {
    return null;
  }

  @Override
  public void setUpValidMoves() {
    addValidMove(Movement.of(upRight));
    addValidMove(Movement.of(upLeft));
    addValidMove(Movement.of(downRight));
    addValidMove(Movement.of(downLeft));
    addValidMove(Movement.of(rightUp));
    addValidMove(Movement.of(rightDown));
    addValidMove(Movement.of(leftUp));
    addValidMove(Movement.of(leftDown));
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
