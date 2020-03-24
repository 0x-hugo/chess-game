package com.empanada.tdd.chess.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.components.impl.ChessManager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.shared.CommandResponse;

@SpringBootTest
public class FirstMoveTest {

  ChessController chessAPI;
  Manager manager;

  private final int SUCCESSFUL_STATUS_CODE = 200;
  private final int FAIL_STATUS_CODE = 400;

  @BeforeEach
  public void startup() {
    manager = new ChessManager();
    chessAPI = new ChessController(manager);
    setupScenarioForFirstMove();
  }

  private void setupScenarioForFirstMove() {
    chessAPI.createGame();
  }

  @Test
  public void movePieceOK() {
    final Position pawn = Position.of('D', '2');
    final Position destiny = Position.of('D', '3');
    final Command validMovement = Command.of(pawn, destiny);

    final ResponseEntity<CommandResponse> response = chessAPI.move(validMovement);

    assertEquals(response.getStatusCode(), SUCCESSFUL_STATUS_CODE);
    assertEquals(response.getStatusCode(), "Todo ok");
  }

  @Test
  public void invalidMove() {
    final Position bishop = Position.of('F', '8');
    final Position destiny = Position.of('D', '3');
    final Command invalidMovement = Command.of(bishop, destiny);

    final ResponseEntity<CommandResponse> response = chessAPI.move(invalidMovement);

    assertEquals(response.getStatusCode(), FAIL_STATUS_CODE);
    assertEquals(response.getStatusCode(), "invalid move");
  }

  @Test
  public void outOfBoundMove() {
    final Position bishop = Position.of('F', '8');
    final Position destiny = Position.of('D', '9');
    final Command invalidMovement = Command.of(bishop, destiny);

    final ResponseEntity<CommandResponse> response = chessAPI.move(invalidMovement);

    assertEquals(response.getStatusCode(), FAIL_STATUS_CODE);
    assertEquals(response.getStatusCode(), "out of bounds");
  }

}
