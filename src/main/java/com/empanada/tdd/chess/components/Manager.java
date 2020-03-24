package com.empanada.tdd.chess.components;

import com.empanada.tdd.chess.messaging.Position;

public interface Manager {

  void initializeGame();

  void move(Position origin, Position destiny);

}