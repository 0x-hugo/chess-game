package com.empanada.tdd.chess.model.table.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.model.pieces.impl.Bishop;
import com.empanada.tdd.chess.model.pieces.impl.King;
import com.empanada.tdd.chess.model.pieces.impl.Knight;
import com.empanada.tdd.chess.model.pieces.impl.NullPiece;
import com.empanada.tdd.chess.model.pieces.impl.Pawn;
import com.empanada.tdd.chess.model.pieces.impl.Queen;
import com.empanada.tdd.chess.model.pieces.impl.Rook;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;
import com.empanada.tdd.chess.shared.ExecutionResult;
import com.empanada.tdd.chess.shared.ExecutionStatus;

/**
 * Table only knows init game and boundaries
 */
public class ChessTable implements Table {

  private static final Logger logger = LogManager.getLogger(ChessTable.class.getName());

  Map<Coordinate, Piece> table;

  @Override
  public void init() {
    table = new HashMap<>();
    initializePositions();
  }

  private void initializePositions() {
    for (final Integer y : ChessCoordinate.vertical) {
      for (final Character x : ChessCoordinate.horizontal) {
        if (y == 1 || y == 8) {
          if (x == 'A' || x == 'H')
            addToTable(x, y, new Rook());
          else if (x == 'B' || x == 'G')
            addToTable(x, y, new Knight());
          else if (x == 'C' || x == 'F')
            addToTable(x, y, new Bishop());
          else if (x == 'D')
            addToTable(x, y, new King());
          else if (x == 'E')
            addToTable(x, y, new Queen());
        } else if (y == 2 || y == 7) {
          addToTable(x, y, new Pawn());
        } else {
          addToTable(x, y, new NullPiece());
        }
        System.out.print(x.toString() + y.toString() + ", ");
      }
      System.out.println();
    }

  }

  private void addToTable(Character x, Integer y, AbstractPiece piece) {
    piece.setUpValidMoves();
    addToTable(ChessCoordinate.of(x, y), piece);
  }

  private void addToTable(ChessCoordinate position, AbstractPiece piece) {
    piece.setUpValidMoves();
    table.put(position, piece);
  }

  @Override
  public Piece getPieceAt(Coordinate coordinate) {
    return table.get(coordinate);
  }

  @Override
  public ExecutionResult move(Coordinate origin, Coordinate destination) {
    if (this.canMove(origin, destination)) {
      this.eat(origin, destination);
      return ExecutionResult.of(ExecutionStatus.OK);
    }
    return ExecutionResult.of(ExecutionStatus.NOT_OK);
  }

  private boolean canMove(Coordinate origin, Coordinate destination) {
    return true;
  }

  @Override
  public void eat(Coordinate origin, Coordinate destination) {
    killPiece(destination);
    table.put(destination, table.get(origin));
    table.put(origin, new NullPiece());

  }

  @Override
  public void killPiece(Coordinate position) {
    // TODO: Graveyard with this pieces
    table.put(position, null);
  }

  @Override
  public boolean isOutOfBounds(Coordinate position) {
    return invalidCoordinates(position.getHorizontal(), position.getVertical());
  }

  private boolean invalidCoordinates(Axis x, Axis y) {
    return !validCoordinates(x, y);
  }

  private boolean validCoordinates(Axis x, Axis y) {
    return x.isValid() && y.isValid();
  }
}
