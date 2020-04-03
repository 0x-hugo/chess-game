package com.empanada.tdd.chess.components.games.impl;

import com.empanada.tdd.chess.components.games.Game;
import com.empanada.tdd.chess.components.games.GameStatus;
import com.empanada.tdd.chess.components.rules.Rule;
import com.empanada.tdd.chess.components.rules.RuleStatus;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheck;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheckmate;
import com.empanada.tdd.chess.components.rules.impl.ChessRulePieceMovement;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleStalemate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;
import com.empanada.tdd.chess.shared.ExecutionResult;
import com.empanada.tdd.chess.shared.ExecutionStatus;

public class ChessGame implements Game {

  GameStatus state;
  Rule rules;
  Table table;

  public static ChessGame of(Table table) {
    return new ChessGame(table);
  }

  private ChessGame(Table table) {
    this.table = table;
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
    rules = new ChessRuleCheckmate()
        .addRule(new ChessRuleStalemate())
        .addRule(new ChessRuleCheck())
        .addRule(new ChessRulePieceMovement());

  }

  @Override
  public ExecutionResult execute(Command command) {
    final Coordinate origin = command.getOrigin();
    final Coordinate destination = command.getDestination();

    if (table.isOutOfBounds(origin) && table.isOutOfBounds(destination))
      return ExecutionResult.of(ExecutionStatus.NOT_OK, "out of bounds");
    if (origin.equals(destination))
      return ExecutionResult.of(ExecutionStatus.NOT_OK, "same coordinates");

    // Case of King get (checked or mate) after a piece moves
    final RuleStatus status = rules.apply(origin, destination, table);
    if (status.isInvalid())
      return ExecutionResult.of(ExecutionStatus.NOT_OK, status.getMessage());

    return table.move(origin, destination);

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
