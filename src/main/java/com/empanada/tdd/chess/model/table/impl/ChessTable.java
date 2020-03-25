package com.empanada.tdd.chess.model.table.impl;

import java.util.HashMap;
import java.util.Map;

import com.empanada.tdd.chess.model.Pieces.Piece;
import com.empanada.tdd.chess.model.Pieces.impl.Bishop;
import com.empanada.tdd.chess.model.Pieces.impl.King;
import com.empanada.tdd.chess.model.Pieces.impl.Knight;
import com.empanada.tdd.chess.model.Pieces.impl.Pawn;
import com.empanada.tdd.chess.model.Pieces.impl.Queen;
import com.empanada.tdd.chess.model.Pieces.impl.Rook;
import com.empanada.tdd.chess.model.table.SquareBoundaries;
import com.empanada.tdd.chess.model.table.Table;

public class ChessTable implements Table {

  Map<Cell, Piece> cells;
  SquareBoundaries boundaries;

  @Override
  public void init() {
    cells = new HashMap<>();
    initializePositionsOfPieces();
  }

  private void initializePositionsOfPieces() {
    for (int start = SquareBoundaries.start; start <= SquareBoundaries.end; start++) {
      if (start == 1 || start == 8) {
        putSpecialPieces(start);
      } else if (start == 2 || start == 7) {
        putPawnPieces(start);
      }
    }
  }

  private void putPawnPieces(int start) {
    cells.put(Cell.of('A', start), new Pawn());
    cells.put(Cell.of('B', start), new Pawn());
    cells.put(Cell.of('C', start), new Pawn());
    cells.put(Cell.of('D', start), new Pawn());
    cells.put(Cell.of('E', start), new Pawn());
    cells.put(Cell.of('F', start), new Pawn());
    cells.put(Cell.of('G', start), new Pawn());
    cells.put(Cell.of('H', start), new Pawn());
  }

  private void putSpecialPieces(int start) {
    cells.put(Cell.of('A', start), new Rook());
    cells.put(Cell.of('B', start), new Knight());
    cells.put(Cell.of('C', start), new Bishop());
    cells.put(Cell.of('D', start), new Queen());
    cells.put(Cell.of('E', start), new King());
    cells.put(Cell.of('F', start), new Bishop());
    cells.put(Cell.of('G', start), new Knight());
    cells.put(Cell.of('H', start), new Rook());
  }

}
