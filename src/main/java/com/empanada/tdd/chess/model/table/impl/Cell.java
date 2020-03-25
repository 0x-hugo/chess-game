package com.empanada.tdd.chess.model.table.impl;

import com.empanada.tdd.chess.messaging.Position;

public class Cell {

  private Character x;
  private Integer y;

  public static Cell of(Character x, Integer y) {
    final Cell cell = new Cell(x, y);
    return cell;
  }

  private Cell(Character x, Integer y) {
    this.x = x;
    this.y = y;
  }

  private Cell() {
  }

  public Position getPosition() {
    return Position.of(x, y);
  }

}
