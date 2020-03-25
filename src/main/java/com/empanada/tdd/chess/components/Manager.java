package com.empanada.tdd.chess.components;

import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.shared.OperationResult;

public interface Manager {

  Game initializeGame();

  OperationResult move(Command command);

}
