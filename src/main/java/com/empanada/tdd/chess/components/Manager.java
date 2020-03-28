package com.empanada.tdd.chess.components;

import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.Request;

public interface Manager {

  OperationResult initializeGame();

  OperationResult move(Request request);

}
