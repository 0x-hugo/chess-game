package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.model.pieces.Piece;

public class Cell {

  private Character x;
  private Integer y;
  private Piece piece;

  public static Cell of(Position position) {
    return new Cell(position.getX(), position.getY());
  }

  private Cell(Character x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public static Cell of(Position position, Piece piece) {
    return new Cell(position.getX(), position.getY(), piece);
  }

  private Cell(Character x, Integer y, Piece piece) {
    this.x = x;
    this.y = y;
    this.piece = piece;
  }

  private Cell() {
  }

  public Position getPosition() {
    return Position.of(x, y);
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

}
