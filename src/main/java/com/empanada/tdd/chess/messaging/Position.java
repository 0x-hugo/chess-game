package com.empanada.tdd.chess.messaging;

public class Position {

  private Character x;
  private Character y;

  public static Position of(char x, char y) {
    final Position position = new Position(x, y);
    return position;
  }

  private Position(Character x, Character y) {
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

  public Character getY() {
    return y;
  }

  public void setY(Character y) {
    this.y = y;
  }

}
