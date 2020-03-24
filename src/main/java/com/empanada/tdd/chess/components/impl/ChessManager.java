package com.empanada.tdd.chess.components.impl;

import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.messaging.Position;

@Component
public class ChessManager implements Manager {

  @Override
  public void initializeGame() {
  }

  @Override
  public void move(Position origin, Position destiny) {
  }

}
