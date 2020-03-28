package com.empanada.tdd.chess.components.impl;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.rules.AbstractRule;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheck;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheckmate;
import com.empanada.tdd.chess.components.rules.impl.ChessRulePieceMovement;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleStalemate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;

public class ChessGame implements Game {

  Table table;
  AbstractRule rules;
  GameStatus state;

  public static ChessGame of(Table table, AbstractRule rules) {
    return new ChessGame(table, rules);
  }

  private ChessGame(Table table, AbstractRule rules) {
    this.table = table;
    this.rules = rules;
    this.state = GameStatus.NOT_STARTED;
  }

  private ChessGame() {
  }

  @Override
  public Game initialize() {
    try {
      setupTable();
      setupRules();
      state = GameStatus.STARTED;
    } catch (final Exception e) {
      state = GameStatus.NOT_STARTED;
    }

    return this;
  }

  private void setupTable() {
    table.init();
  }

  private void setupRules() {
    rules = rules.addRule(new ChessRuleCheckmate())
        .addRule(new ChessRuleStalemate())
        .addRule(new ChessRuleCheck())
        .addRule(new ChessRulePieceMovement());

  }

  @Override
  public ExecutionResult execute(Command command) {
    if (this.hasNotStarted())
      return ExecutionResult.of(ExecutionStatus.GAME_NOT_STARTED);

    final RuleStatus status = rules.applyRule(command, table);
    if (status.isInvalid())
      return ExecutionResult.of(ExecutionStatus.NOT_VALID, status.getMessage());

    final ExecutionResult moveResult = table.move(command);

    return moveResult;

  }

  @Override
  public boolean hasNotStarted() {
    return !hasStarted();
  }

  @Override
  public boolean hasStarted() {
    return state == GameStatus.STARTED;
  }

}
