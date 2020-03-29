package com.empanada.tdd.chess.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.shared.OperationResult;
import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.shared.Response;

@Controller
@RequestMapping(value = "/chess")
public class ChessController {

  Logger logger = LogManager.getLogger(ChessController.class.getName());

  private final Manager manager;

  @Autowired
  ChessController(@Qualifier("manager.chess") Manager managerImpl) {
    manager = managerImpl;
  }

  @PostMapping("/start")
  @ResponseBody
  public ResponseEntity<Response> createGame() {
    final OperationResult result = manager.newGame();
    if (result.isNotSuccesful())
      return result.generateCommandResponse();
    return OperationResult.generateResponse(HttpStatus.resolve(200), "Chess game has been created.");
  }

  @PostMapping("/")
  @ResponseBody
  public ResponseEntity<Response> move(@RequestBody Request command) {
    final OperationResult result = manager.move(command);
    if (result.isNotSuccesful())
      return result.generateCommandResponse();
    return result.generateCommandResponse(HttpStatus.resolve(200));
  }

  public void destroyGame() {
    manager.destroyGame();
  }

}
