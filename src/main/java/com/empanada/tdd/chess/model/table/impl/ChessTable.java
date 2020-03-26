package com.empanada.tdd.chess.model.table.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.model.pieces.impl.Bishop;
import com.empanada.tdd.chess.model.pieces.impl.King;
import com.empanada.tdd.chess.model.pieces.impl.Knight;
import com.empanada.tdd.chess.model.pieces.impl.Pawn;
import com.empanada.tdd.chess.model.pieces.impl.Queen;
import com.empanada.tdd.chess.model.pieces.impl.Rook;
import com.empanada.tdd.chess.model.table.Cell;
import com.empanada.tdd.chess.model.table.Table;

/**
 * Table only knows init game and boundaries
 */
public class ChessTable implements Table {

  private static final Logger logger = LogManager.getLogger(ChessTable.class.getName());

  List<Cell> cells;
  ChessCoordenates boundaries;

  @Override
  public void init() {
    cells = new ArrayList<>();
    initializePositions();
  }

  private void initializePositions() {
    for (final Integer y : ChessCoordenates.vertical) {
      for (final Character x : ChessCoordenates.horizontal) {
        if (y == 1 || y == 8) {
          if (x == 'A' || x == 'H')
            cells.add(Cell.of(Position.of(x, y), new Rook()));
          else if (x == 'B' || x == 'G')
            cells.add(Cell.of(Position.of(x, y), new Knight()));
          else if (x == 'C' || x == 'F')
            cells.add(Cell.of(Position.of(x, y), new Bishop()));
          else if (x == 'D')
            cells.add(Cell.of(Position.of(x, y), new King()));
          else if (x == 'E')
            cells.add(Cell.of(Position.of(x, y), new Queen()));
        } else if (y == 2 || y == 7) {
          cells.add(Cell.of(Position.of(x, y), new Pawn()));
        } else {
          cells.add(Cell.of(Position.of(x, y)));
        }

//        logger.debug(x.toString() + y.toString() + ", ");
        System.out.print(x.toString() + y.toString() + ", ");
      }
//      logger.debug("");
      System.out.println();
    }

  }

  private void putPawnPieces(int start) {

  }

  private void putSpecialPieces(int start) {

  }

}
