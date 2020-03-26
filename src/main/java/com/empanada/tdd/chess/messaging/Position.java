package com.empanada.tdd.chess.messaging;

import java.util.Arrays;
import java.util.List;

import com.empanada.tdd.chess.model.table.impl.ChessCoordenates;
import com.empanada.tdd.chess.shared.exceptions.PositionException;

public class Position {

  private Character x;
  private Integer y;

  public static Position of(Character x, Integer y) {
    final Character upperCaseX = Character.toUpperCase(x);
    if (!validCoordenates(x, y))
      throw new PositionException("Invalid position");
    return new Position(upperCaseX, y);

  }

  private static boolean validCoordenates(Character x, Integer y) {
    final List<Character> validX = Arrays.asList(ChessCoordenates.horizontal);
    final List<Integer> validY = Arrays.asList(ChessCoordenates.vertical);
    return (validX.contains(x) && validY.contains(y));
  }

  private Position(Character x, Integer y) {
    super();
    this.x = x;
    this.y = y;
  }

  private Position() {
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

}
