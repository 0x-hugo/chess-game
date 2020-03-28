package com.empanada.tdd.chess.components;

import com.empanada.tdd.chess.messaging.Command;

public interface Game {

  Game initialize();

  void execute(Command command);

}
