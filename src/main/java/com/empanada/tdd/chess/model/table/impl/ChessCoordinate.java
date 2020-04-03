package com.empanada.tdd.chess.model.table.impl;

import java.util.Arrays;

import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.shared.exceptions.CoordinateException;

public class ChessCoordinate implements Coordinate {

  protected static String invalidMsg = "Invalid coordinates.";
  protected static final Integer[] vertical = { 1, 2, 3, 4, 5, 6, 7, 8 };
  protected static final Character[] horizontal = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

  private Axis x;
  private Axis y;

  public static ChessCoordinate of(Character x, Integer y) throws CoordinateException {
    final Character upperCaseX = Character.toUpperCase(x);
    final Axis xAxis = Axis.of(ChessCoordinate.horizontal,
        positionInArray(ChessCoordinate.horizontal, upperCaseX));
    final Axis yAxis = Axis.of(ChessCoordinate.vertical,
        positionInArray(ChessCoordinate.vertical, y));

    return new ChessCoordinate(xAxis, yAxis);
  }

  private static int positionInArray(Object[] array, final Object value) {
    final int a = Arrays.asList(array).indexOf(value);
    if (a == -1)
      throw new CoordinateException(invalidMsg);
    return a;
  }

  private ChessCoordinate(Axis x, Axis y) {
    super();
    this.x = x;
    this.y = y;
  }

  public static Coordinate buildCoordinate(String possibleX, String possibleY) {
    if (possibleX.length() != 1 || possibleY.length() != 1)
      throw new CoordinateException(invalidMsg);
    final Character xCord = possibleX.charAt(0);
    final Integer yCord = convertToNumber(possibleY);
    return ChessCoordinate.of(xCord, yCord);
  }

  private static int convertToNumber(String possibleNumber) throws NumberFormatException {
    return Integer.parseInt(possibleNumber);
  }

  private ChessCoordinate() {
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Coordinate) {
      final ChessCoordinate cord = (ChessCoordinate) obj;
      return this.x.getValue().equals(cord.x.getValue())
          && (this.y.getValue().equals(cord.y.getValue()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    return x.hashCode() * y.hashCode();
  }

  @Override
  public String toString() {
    return x.toString() + y.toString();
  }

  @Override
  public Axis getHorizontal() {
    return x;
  }

  @Override
  public Axis getVertical() {
    return y;
  }

  @Override
  public void incrementHorizontal(int i) {
    x.increment(i);
  }

  @Override
  public void incrementVertical(int i) {
    y.increment(i);
  }

  @Override
  public boolean isValid() {
    return x.isValid() && y.isValid();
  }

}
