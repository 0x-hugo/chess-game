package com.empanada.tdd.chess.model.table.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.pieces.NullPiece;
import com.empanada.tdd.chess.model.pieces.AbstractPiece;
import com.empanada.tdd.chess.model.pieces.impl.Bishop;
import com.empanada.tdd.chess.model.pieces.impl.King;
import com.empanada.tdd.chess.model.pieces.impl.Knight;
import com.empanada.tdd.chess.model.pieces.impl.Pawn;
import com.empanada.tdd.chess.model.pieces.impl.Queen;
import com.empanada.tdd.chess.model.pieces.impl.Rook;
import com.empanada.tdd.chess.model.table.Table;
import com.empanada.tdd.chess.shared.ExecutionResult;
import com.empanada.tdd.chess.shared.ExecutionStatus;

/**
 * Table only knows init game and boundaries
 */
public class ChessTable implements Table {

  private static final Logger logger = LogManager.getLogger(ChessTable.class.getName());

  Map<ChessCoordinate, AbstractPiece> table;

  @Override
  public void init() {
    table = new HashMap<>();
    initializePositions();
  }

  private void initializePositions() {
    for (final Integer y : ChessCoordinates.vertical) {
      for (final Character x : ChessCoordinates.horizontal) {
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
    addToTable(ChessCoordinate.of(x, y), piece);
  }

  private void addToTable(ChessCoordinate position, AbstractPiece piece) {
    table.put(position, piece);
  }

  @Override
  public AbstractPiece getPieceAt(ChessCoordinate coordinate) {
    return table.get(coordinate);
  }

  @Override
  public ExecutionResult move(Command command) {
    final ChessCoordinate origin = command.getOrigin();
    final ChessCoordinate destination = command.getDestination();
    if (this.canMove(origin, destination)) {
      this.eat(origin, destination);
      return ExecutionResult.of(ExecutionStatus.OK);
    }
    return ExecutionResult.of(ExecutionStatus.NOT_OK);
  }

  private boolean canMove(ChessCoordinate origin, ChessCoordinate destination) {
    return true;
  }

  @Override
  public void eat(ChessCoordinate origin, ChessCoordinate destination) {
    killPiece(destination);
    table.put(destination, table.get(origin));
    table.put(origin, new NullPiece());

  }

  @Override
  public void killPiece(ChessCoordinate position) {
    // TODO: Graveyard with this pieces
    table.put(position, null);
  }

}
