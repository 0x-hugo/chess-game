package com.empanada.tdd.chess.components.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.components.rules.impl.ChessRuleCheckmate;
import com.empanada.tdd.chess.messaging.ChessCoordinate;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.impl.ChessTable;
import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.OperationStatus;
import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.shared.exceptions.CommandException;
import com.empanada.tdd.chess.shared.exceptions.PositionException;

@Component("manager.chess")
public class ChessManager implements Manager {

  private Game game;

  Logger logger = LogManager.getLogger(ChessManager.class.getName());

  @Override
  public OperationResult newGame() {
    game = ChessGame.of(new ChessTable(), new ChessRuleCheckmate());
    game = game.initialize();
    if (game.hasNotStarted())
      return OperationResult.of(OperationStatus.INVALID_INIT_GAME);
    return OperationResult.of(OperationStatus.OK);
  }

  @Override
  public OperationResult move(Request request) {
    try {
      final Command command = toCommand(request);
      final ExecutionResult execStatus = game.execute(command);
      return execStatus.toOperationResult();
    } catch (final CommandException exception) {
      // TODO: Add which Position caused this exception for info
      logger.info(OperationStatus.INVALID_COORDINATE, exception);
      return OperationResult.of(exception.getStatus());
    }
  }

  private Command toCommand(Request request) throws CommandException {
    try {
      validateCordinatesLength(request);

      final Character xOrig = request.getxOrig().charAt(0);
      final Character xDest = request.getxDest().charAt(0);
      final Integer yOrig = Integer.parseInt(request.getyOrig());
      final Integer yDest = Integer.parseInt(request.getyDest());

      final ChessCoordinate origin = ChessCoordinate.of(xOrig, yOrig);
      final ChessCoordinate destination = ChessCoordinate.of(xDest, yDest);

      return Command.of(origin, destination);
    } catch (NumberFormatException | PositionException e) {
      throw new CommandException(OperationStatus.INVALID_COORDINATE);
    }
  }

  private void validateCordinatesLength(Request request) throws PositionException {
    if (request.getxOrig().length() != 1 || request.getxDest().length() != 1 ||
        request.getyOrig().length() != 1 || request.getyDest().length() != 1) {
      throw new PositionException(OperationStatus.INVALID_COORDINATE);
    }
  }
}
