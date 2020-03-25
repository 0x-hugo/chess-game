package com.empanada.tdd.chess.model.table.impl;

import java.util.HashMap;
import java.util.Map;

import com.empanada.tdd.chess.model.Pieces.Piece;
import com.empanada.tdd.chess.model.Pieces.impl.Bishop;
import com.empanada.tdd.chess.model.Pieces.impl.King;
import com.empanada.tdd.chess.model.Pieces.impl.Knight;
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

    for (int start = SquareBoundaries.start; start < SquareBoundaries.end; start++) {

      cells.put(Cell.of('A', 2), new Rook());
      cells.put(Cell.of('B', 2), new Knight());
      cells.put(Cell.of('C', 2), new Bishop());
      cells.put(Cell.of('D', 2), new Queen());
      cells.put(Cell.of('E', 2), new King());
      cells.put(Cell.of('F', 2), new Bishop());
      cells.put(Cell.of('G', 2), new Knight());
      cells.put(Cell.of('H', 2), new Rook());
    }
  }

}
