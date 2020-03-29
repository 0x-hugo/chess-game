package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.impl.RuleStatus;
import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;

public class ChessRuleStalemate extends AbstractRule {

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
    return true;
  }
}
