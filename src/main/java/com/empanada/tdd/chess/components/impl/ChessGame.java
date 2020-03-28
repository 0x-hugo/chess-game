package com.empanada.tdd.chess.components.impl;

import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.Rules;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;

@Component("game.chess")
public class ChessGame implements Game {

  Table table;
  Rules rules;
  String state;

  public static ChessGame of(Table table, Rules rules) {
    return new ChessGame(table, rules);
  }

  private ChessGame(Table table, Rules rules) {
    this.table = table;
    this.rules = rules;
  }

  private ChessGame() {
  }

  @Override
  public Game initialize() {
    try {
      setupTable();
    } catch (final Exception e) {
      return null;
    }
    return this;
  }

  private void setupTable() {
    table.init();
  }

  @Override
  public void execute(Command command) {

//    if (rules.invalidMove(command)) {
//      
//    }
  }

}
