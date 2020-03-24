package com.empanada.tdd.chess.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.components.impl.ChessManager;
import com.empanada.tdd.chess.shared.CommandResponse;

@SpringBootTest
public class CreateChessGameTest {

  ChessController chessAPI;
  Manager manager;

  // TODO: Ver de cambiar los status code por unos mas adecuados
  private final int SUCCESSFUL_STATUS_CODE = 200;
  private final int FAIL_STATUS_CODE = 400;

  @BeforeEach
  public void startup() {
    manager = new ChessManager();
    chessAPI = new ChessController(manager);
  }

  @Test
  public void createGameHappyCase() {
    final ResponseEntity<CommandResponse> response = chessAPI.createGame();

    assertEquals(response.getStatusCode(), SUCCESSFUL_STATUS_CODE);
    assertEquals(response.getBody(), "Chess game has been created");
  }

  @Test
  public void createGameBadCase() {
    final ResponseEntity<CommandResponse> response = chessAPI.createGame();

    assertEquals(response.getStatusCode(), FAIL_STATUS_CODE);
    assertEquals(response.getBody(), "Hubo quilombo");
  }
}
