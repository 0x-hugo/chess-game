package com.empanada.tdd.chess.components.managers.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.empanada.tdd.chess.components.games.Game;
import com.empanada.tdd.chess.components.games.impl.ChessGame;
import com.empanada.tdd.chess.components.managers.Manager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.model.table.Coordinate;
import com.empanada.tdd.chess.model.table.impl.ChessCoordinate;
import com.empanada.tdd.chess.model.table.impl.ChessTable;
import com.empanada.tdd.chess.shared.ExecutionResult;
import com.empanada.tdd.chess.shared.ExecutionStatus;
import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.OperationStatus;
import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.shared.exceptions.CommandException;
import com.empanada.tdd.chess.shared.exceptions.CoordinateException;

@Component("manager.chess")
public class ChessManager implements Manager {

  private Game game;

  Logger logger = LogManager.getLogger(ChessManager.class.getName());

  @Override
  public OperationResult newGame() {
    game = ChessGame.of(new ChessTable());
    game = game.initialize();
    if (game.hasNotStarted())
      return OperationResult.of(OperationStatus.INVALID_INIT_GAME);
    return OperationResult.of(OperationStatus.OK);
  }

  @Override
  public void destroyGame() {
    game = null;
  }

  @Override
  public OperationResult move(Request request) {
    if (game == null)
      return ExecutionResult.of(ExecutionStatus.GAME_NOT_STARTED, "Game has not been created.").toOperationResult();

    try {
      final Command command = toCommand(request);
      final ExecutionResult execStatus = game.execute(command);
      return execStatus.toOperationResult();
    } catch (final CommandException exception) {
      logger.info(OperationStatus.INVALID_COORDINATE, exception); // TODO: Add Position info for this exception
      return OperationResult.of(exception.getStatus(), exception.getMessage());
    }
  }

  private Command toCommand(Request request) throws CommandException {
    try {
      final Coordinate origin = ChessCoordinate.buildCoordinate(request.getxOrig(), request.getyOrig());
      final Coordinate destination = ChessCoordinate.buildCoordinate(request.getxDest(), request.getyDest());

      return Command.of(origin, destination);
    } catch (NumberFormatException | CoordinateException e) {
      throw new CommandException(OperationStatus.INVALID_COORDINATE, e.getMessage());
    }
  }

}
