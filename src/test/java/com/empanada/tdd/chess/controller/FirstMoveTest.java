package com.empanada.tdd.chess.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.empanada.tdd.chess.manager.Manager;
import com.empanada.tdd.chess.manager.impl.ChessManager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.messaging.Position;
import com.empanada.tdd.chess.shared.CommandResponse;

@SpringBootTest
public class FirstMoveTest {

  ChessController chessAPI;
  Manager manager;

  private final int SUCCESSFUL_STATUS_CODE = 200;

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
    final Command command = Command.of(pawn, destiny);

    final ResponseEntity<CommandResponse> response = chessAPI.move(command);

    assertEquals(response.getStatusCode(), SUCCESSFUL_STATUS_CODE);
    assertEquals(response.getStatusCode(), "Todo ok");
  }

}
