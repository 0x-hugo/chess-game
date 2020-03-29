package com.empanada.tdd.chess.components.managers;

import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.Request;

public interface Manager {

  OperationResult newGame();

  OperationResult move(Request request);

  void destroyGame();
}
