package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.impl.RuleStatus;
import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.ChessPosition;
import com.empanada.tdd.chess.model.table.Table;

public class ChessRuleCheck extends AbstractRule {

  @Override
  public RuleStatus applyRule(Command command, Table table) {
    return (invalidMove())
        ? RuleStatus.invalid("checkmage.")
        : applyNextRule(command, table);
  }

  private boolean invalidMove() {
    return !validMove();
  }

  private boolean validMove() {
    final ChessPosition queen = ChessPosition.of(ChessCoordinate.of('C', 4));
    return true;
  }

}
