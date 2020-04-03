package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.components.rules.RuleStatus;
import com.empanada.tdd.chess.model.pieces.Piece;
import com.empanada.tdd.chess.model.pieces.impl.NullPiece;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;

public class ChessRulePieceMovement extends AbstractRule {

  @Override
  public RuleStatus apply(Coordinate origin, Coordinate destination, Table table) {
    return validateMove(origin, destination, table);
  }

  private RuleStatus validateMove(Coordinate origin, Coordinate destination, Table table) {

    final Piece piece = table.getPieceAt(origin);

    if (piece instanceof NullPiece)
      return RuleStatus.invalid("There is no piece at [" + origin.toString() + "].");

    if (!piece.hasValidMovements(origin, destination))
      return RuleStatus.invalid("Not able to move [" + origin.toString() + "] to [" + destination.toString() + "].");
    return super.applyNextRule(origin, destination, table);
  }

}
