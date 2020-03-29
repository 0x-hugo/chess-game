package com.empanada.tdd.chess.components.rules;

import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Table;

public interface Rule {

  RuleStatus applyRule(Command command, Table table);

}
