package com.empanada.tdd.chess.model.pieces;

public abstract class AbstractPiece implements Move {

  protected PieceMove movements;

  public abstract String draw();

  protected PieceMove getMovesAllowed() {
    return movements;
  }

}
