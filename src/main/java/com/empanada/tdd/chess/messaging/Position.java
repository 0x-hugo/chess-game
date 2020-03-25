package com.empanada.tdd.chess.messaging;

public class Position {

  private Character x;
  private Integer y;

  public static Position of(Character x, Integer y) {
    final Character upperCaseX = Character.toUpperCase(x);
    return new Position(upperCaseX, y);
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
