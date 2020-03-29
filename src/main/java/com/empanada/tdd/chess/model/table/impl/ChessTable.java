package com.empanada.tdd.chess.model.table.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.pieces.NullPiece;
import com.empanada.tdd.chess.model.pieces.Piece;
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

  Map<ChessCoordinate, Piece> table;

  @Override
  public void init() {
    table = new HashMap<>();
    initializePositions();
  }

  private void initializePositions() {
    for (final Integer y : ChessCoordenates.vertical) {
      for (final Character x : ChessCoordenates.horizontal) {
        if (y == 1 || y == 8) {
          if (x == 'A' || x == 'H')
            table.put(ChessCoordinate.of(x, y), new Rook());
          else if (x == 'B' || x == 'G')
            table.put(ChessCoordinate.of(x, y), new Knight());
          else if (x == 'C' || x == 'F')
            table.put(ChessCoordinate.of(x, y), new Bishop());
          else if (x == 'D')
            table.put(ChessCoordinate.of(x, y), new King());
          else if (x == 'E')
            table.put(ChessCoordinate.of(x, y), new Queen());
        } else if (y == 2 || y == 7) {
          table.put(ChessCoordinate.of(x, y), new Pawn());
        } else {
          table.put(ChessCoordinate.of(x, y), new NullPiece());
        }
        System.out.print(x.toString() + y.toString() + ", ");
      }
      System.out.println();
    }

  }

  @Override
  public Piece getPieceAt(ChessCoordinate coordinate) {
    return table.get(coordinate);
  }

  @Override
  public void killPiece(ChessCoordinate position) {
    // TODO: Graveyard with this pieces
    table.put(position, null);
  }

  @Override
  public void movePiece(ChessCoordinate origin, ChessCoordinate destination) {
    killPiece(destination);
    table.put(destination, table.get(origin));
    table.put(origin, new NullPiece());

  }

  @Override
  public ExecutionResult move(Command command) {
    final Piece originPiece = getPieceAt(command.getOrigin());
    if (originPiece.canMove(command.getOrigin(), command.getDestination())) {
      return ExecutionResult.of(ExecutionStatus.OK);
    }
    return ExecutionResult.of(ExecutionStatus.NOT_OK);
  }

  public int diagonalForward(ChessCoordinate destination) {
    return 1;
  }

  public int forward(ChessCoordinate destination) {
    return 1;
  }

  public boolean canMove(ChessCoordinate destination) {
    final Piece piece = table.get(destination);
//    return piece.canMove(this, destination);
    return true;
  }

//  public boolean sameVerticalAs(ChessCoordinate destination) {
//    return this.getCoordinateX().equals(destination.getCoordinateX());
//  }

  @Override
  public boolean canMove(ChessCoordinate origin, ChessCoordinate destination) {
    return true;
  }

}
