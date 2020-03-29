package com.empanada.tdd.chess.components.games;

import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.shared.ExecutionResult;

public interface Game {

  Game initialize();

  ExecutionResult execute(Command command);

  boolean hasNotStarted();

  boolean hasStarted();

}
