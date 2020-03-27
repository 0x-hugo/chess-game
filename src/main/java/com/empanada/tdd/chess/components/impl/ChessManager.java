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
import com.empanada.tdd.chess.shared.OperationStatus;
import com.empanada.tdd.chess.shared.Request;

@Component("manager.chess")
public class ChessManager implements Manager {

  private final Game game;

  @Autowired
  public ChessManager(@Qualifier("game.chess") Game gameImpl) {
    game = ChessGame.of(new ChessTable(), new ChessRules());
  }

  @Override
  public void initializeGame() {
    game.initialize();
  }

  @Override
  public OperationResult move(Request request) {
    try {
      final Command command = toCommand(request);

      // To evaluate with rules
      if (!isValid(command))
        return OperationResult.of(OperationStatus.INVALID_MOVE);
    } catch (final Exception exception) {
      return OperationResult.of(OperationStatus.OUT_OF_BOUNDS);
    }

    return OperationResult.of(OperationStatus.OK);
  }

  private Command toCommand(Request request) {
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
