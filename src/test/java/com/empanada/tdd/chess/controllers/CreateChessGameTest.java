package com.empanada.tdd.chess.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.empanada.tdd.chess.components.Game;
import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.components.impl.ChessGame;
import com.empanada.tdd.chess.components.impl.ChessManager;
import com.empanada.tdd.chess.components.impl.ChessRules;
import com.empanada.tdd.chess.controllers.ChessController;
import com.empanada.tdd.chess.model.table.impl.ChessTable;
import com.empanada.tdd.chess.shared.Response;

@SpringBootTest
public class CreateChessGameTest {

  ChessController chessAPI;
  Game chessGame;
  Manager manager;

  // TODO: Ver de cambiar los status code por unos mas adecuados
  private final int SUCCESSFUL_STATUS_CODE = 200;
  private final int FAIL_STATUS_CODE = 400;

  @BeforeEach
  public void startup() {
    chessGame = ChessGame.of(new ChessTable(), new ChessRules());
    manager = new ChessManager(chessGame);
    chessAPI = new ChessController(manager);
  }

  @Test
  public void createGameHappyCase() {
    final ResponseEntity<Response> response = chessAPI.createGame();

    assertEquals(response.getStatusCodeValue(), SUCCESSFUL_STATUS_CODE);
    assertEquals(response.getBody().getMessage(), "Chess game has been created");
  }

  // TODO: no se me ocurre que validar para que falle..
//  @Test
//  public void createGameBadCase() {
//    final ResponseEntity<CommandResponse> response = chessAPI.createGame();
//
//    assertEquals(response.getStatusCodeValue(), FAIL_STATUS_CODE);
//    assertEquals(response.getBody().getMessage(), "Hubo quilombo");
//  }
}
