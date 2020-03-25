package com.empanada.tdd.chess.components.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.model.table.impl.ChessTable;
import com.empanada.tdd.chess.shared.OperationResult;

@Component("manager.chess")
public class ChessManager implements Manager {

  private final Game game;

  private final Integer BAD_OPERATION_STATUS = 400;
  private final Integer OUT_OF_BOUND_STATUS = 400;

  @Autowired
  public ChessManager(@Qualifier("game.chess") Game gameImpl) {
    game = ChessGame.of(new ChessTable(), new ChessRules());
  }

  @Override
  public void initializeGame() {
    game.initialize();
  }

  @Override
  public OperationResult move(Command command) {
    if (!isValid(command))
      return OperationResult.of(OUT_OF_BOUND_STATUS);

    return null;
  }

  private boolean isValid(Command command) {
    final Position origin = command.getOrigin();
    final Position destiny = command.getDestination();
    return isValid(origin) && isValid(destiny);
  }

  private boolean isValid(Position position) {
    return (position.getX() < 8 && position.getX() > 0) || (position.getY() < 'H' && position.getY() >= 'A');
  }

}
