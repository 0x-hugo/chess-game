package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.impl.RuleStatus;
import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.pieces.NullPiece;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.model.table.Table;

public class ChessRulePieceMovement extends AbstractRule {

  @Override
  public RuleStatus applyRule(Command command, Table table) {
    return validateMove(command, table);
  }

  private RuleStatus validateMove(Command command, Table table) {
    final ChessCoordinate origin = command.getOrigin();
    final ChessCoordinate destination = command.getDestination();

    final Piece pieceToMove = table.getPieceAt(command.getOrigin());

    if (pieceToMove instanceof NullPiece)
      return RuleStatus.invalid("There is no piece at [" + origin.toString() + "].");

    if (!pieceToMove.canMove(origin, destination))
      return RuleStatus.invalid("Not able to move [" + origin.toString() + "] to [" + destination.toString() + "].");
    return applyNextRule(command, table);
  }

}
