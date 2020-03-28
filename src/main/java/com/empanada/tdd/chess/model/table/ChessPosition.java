package com.empanada.tdd.chess.model.table;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.model.pieces.NullPiece;
import com.empanada.tdd.chess.model.pieces.Piece;

public class ChessPosition {

  private Character x;
  private Integer y;
  private Piece piece;

  /**
   * sets nullPiece
   */
  public static ChessPosition of(ChessCoordinate coordinate) {
    final Piece piece = new NullPiece();
    return new ChessPosition(coordinate.getX(), coordinate.getY(), piece);
  }

  public static ChessPosition of(ChessCoordinate coordinate, Piece piece) {
    return new ChessPosition(coordinate.getX(), coordinate.getY(), piece);
  }

  private ChessPosition(Character x, Integer y, Piece piece) {
    this.x = x;
    this.y = y;
    this.piece = piece;
  }

  private ChessPosition() {
  }

  public ChessCoordinate getPosition() {
    return ChessCoordinate.of(x, y);
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
