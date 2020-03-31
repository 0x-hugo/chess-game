package com.empanada.tdd.chess.messaging;

import java.util.Arrays;
import java.util.List;

import com.empanada.tdd.chess.model.table.impl.ChessCoordinates;
import com.empanada.tdd.chess.shared.exceptions.CoordinateException;

//TODO: build Position abstraction and use CoordenateObject instead of Character and Integer 
public class ChessCoordinate implements Coordinate {

  private Character x;
  private Integer y;

  public static ChessCoordinate of(Character x, Integer y) throws CoordinateException {
    final Character upperCaseX = Character.toUpperCase(x);
    if (invalidCoordinates(upperCaseX, y))
      throw new CoordinateException("Invalid position");
    return new ChessCoordinate(upperCaseX, y);

  }

  private static boolean invalidCoordinates(Character x, Integer y) {
    return !validCoordinates(x, y);
  }

  private static boolean validCoordinates(Character x, Integer y) {
    final List<Character> validX = Arrays.asList(ChessCoordinates.horizontal);
    final List<Integer> validY = Arrays.asList(ChessCoordinates.vertical);
    return validX.contains(x) && validY.contains(y);
  }

  private ChessCoordinate(Character x, Integer y) {
    super();
    this.x = x;
    this.y = y;
  }

  private ChessCoordinate() {
  }

  public Character getX() {
    return x;
  }

  public void setX(Character x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public int diagonalForward(ChessCoordinate destination) {
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ChessCoordinate) {
      final ChessCoordinate cord = (ChessCoordinate) obj;
      return this.x.equals(cord.x) && this.y == cord.y;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return x.hashCode() * y.hashCode();
  }
}
