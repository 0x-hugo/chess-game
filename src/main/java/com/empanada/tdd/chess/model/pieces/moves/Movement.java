package com.empanada.tdd.chess.model.pieces.moves;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.impl.ChessCoordinate;

/**
 * If @param origin gets to @param destination by valid moves , it is a valid
 * movement.
 */
public class Movement {

  Logger logger = LogManager.getLogger(Movement.class.getName());

  // Chain of moves that modifies coordinates.
  private final List<Move> moves;
  private boolean repeatMovement = false;

  private static boolean anyMovement = true;
  private static boolean oneMovement = false;

  public static Movement of(List<Move> moves) {
    final List<Move> copy = new ArrayList<>(moves);
    return new Movement(copy, oneMovement);
  }

  private Movement(List<Move> moves, boolean isAny) {
    this.moves = moves;
    this.repeatMovement = isAny;
  }

  public static Movement of(Move move1, Move move2) {
    final List<Move> movement = new ArrayList<>();
    movement.add(move1);
    movement.add(move2);
    return new Movement(movement, oneMovement);
  }

  public static Movement of(Move move) {
    final List<Move> baseMovement = new ArrayList<>();
    baseMovement.add(move);
    return new Movement(baseMovement, oneMovement);
  }

  public static Movement any(List<Move> moves) {
    final List<Move> copy = new ArrayList<>(moves);
    return new Movement(copy, anyMovement);
  }

  public static Movement any(Move move1, Move move2) {
    final List<Move> movement = new ArrayList<>();
    movement.add(move1);
    movement.add(move2);
    return new Movement(movement, anyMovement);
  }

  public static Movement any(Move move) {
    final List<Move> baseMovement = new ArrayList<>();
    baseMovement.add(move);
    return new Movement(baseMovement, anyMovement);
  }

  public boolean isValid(Coordinate origin, Coordinate destination) {
    final Coordinate endPositionAfterMovement = copyOf(origin);

    if (repeatMovement)
      while (endPositionAfterMovement.isValid()) {
        for (final Move move : moves) {
          if (move.isValid(endPositionAfterMovement, destination))
            return true;
        }
      }
    else
      for (final Move move : moves) {
        move.apply(endPositionAfterMovement);
      }

//    for (final Move move : moves) {
//      if (repeatMovement) {
//        while (endPositionAfterMovement.isValid()) {
//          move.apply(endPositionAfterMovement);
//          if (endPositionAfterMovement.equals(destination))
//            return true;
//        }
//
//      } else {
//        move.apply(endPositionAfterMovement);
//      }
//    }

    logger.debug(origin.toString() + " has no movements to make ");
    return endPositionAfterMovement.equals(destination);
  }

  private Coordinate copyOf(Coordinate position) {
    return ChessCoordinate.of(
        (Character) position.getHorizontal().getValueInDomain(),
        (Integer) position.getVertical().getValueInDomain());
  }

}
