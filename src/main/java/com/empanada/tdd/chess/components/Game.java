package com.empanada.tdd.chess.components;

import com.empanada.tdd.chess.components.impl.ExecutionResult;
import com.empanada.tdd.chess.messaging.Command;

public interface Game {

  Game initialize();

  ExecutionResult execute(Command command);

  boolean hasNotStarted();

  boolean hasStarted();

}
