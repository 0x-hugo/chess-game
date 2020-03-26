package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.model.pieces.NullPiece;
import com.empanada.tdd.chess.model.pieces.Piece;

public class Cell {

  private Character x;
  private Integer y;
  private Piece piece;

  /**
   * sets nullPiece
   */
  public static Cell of(Position position) {
    final Piece piece = new NullPiece();
    return new Cell(position.getX(), position.getY(), piece);
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

  public String drawPiece() {
    return piece.draw();
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public String getCoordenates() {
    return x.toString() + y.toString();
  }

}
