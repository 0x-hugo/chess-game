package com.empanada.tdd.chess.components.rules;

import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.Table;

public interface Rule {

  RuleStatus apply(Coordinate origin, Coordinate destination, Table table);

}
