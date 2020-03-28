package com.empanada.tdd.chess.components.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.messaging.ChessPosition;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.impl.ChessTable;
import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.OperationStatus;
import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.shared.exceptions.PositionException;

@Component("manager.chess")
public class ChessManager implements Manager {

  private final Game game;

  Logger logger = LogManager.getLogger(ChessManager.class.getName());

  final String INVALID_COORDINATES_MSG = "Invalid coordinates.";

  @Autowired
  public ChessManager(@Qualifier("game.chess") Game gameImpl) {
    game = ChessGame.of(new ChessTable(), new ChessRules());
  }

  @Override
  public void initializeGame() {
    game.initialize();
  }

  /**
   * 
   * */
  @Override
  public OperationResult move(Request request) {
    try {
      final Command command = toCommand(request);

//      game.excecute(command);

    } catch (final PositionException exception) {
      logger.info(INVALID_COORDINATES_MSG, exception); // TODO: Add which value caused this exception for info
      return OperationResult.of(OperationStatus.INVALID_COORDINATE);
    }

    return OperationResult.of(OperationStatus.OK);
  }

  private Command toCommand(Request request) throws PositionException {

    if (request.getxOrig().length() != 1 || request.getxDest().length() != 1 ||
        request.getyOrig().length() != 1 || request.getyDest().length() != 1) {
      throw new PositionException(INVALID_COORDINATES_MSG);
    }

    try {
      final Character xOrig = request.getxOrig().charAt(0);
      final Character xDest = request.getxDest().charAt(0);
      final Integer yOrig = Integer.parseInt(request.getyOrig());
      final Integer yDest = Integer.parseInt(request.getyDest());

      final ChessPosition origin = ChessPosition.of(xOrig, yOrig);
      final ChessPosition destination = ChessPosition.of(xDest, yDest);

      return Command.of(origin, destination);
    } catch (final NumberFormatException e) {
      throw new PositionException(INVALID_COORDINATES_MSG);
    } catch (final PositionException position) {
      throw position;
    }
  }
}
