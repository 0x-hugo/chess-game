package com.empanada.tdd.chess.components.rules.impl;

import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.components.rules.RuleStatus;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;

/**
 * Rules knows how to play the game. Who wins and what the constraints are.
 */
public class ChessRuleCheckmate extends AbstractRule {

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
