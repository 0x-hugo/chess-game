package com.empanada.tdd.chess.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.shared.CommandResponse;
import com.empanada.tdd.chess.shared.OperationResult;

@Controller
@RequestMapping(value = "/")
public class ChessController {

  Logger logger = LogManager.getLogger(ChessController.class.getName());

  private final Manager manager;

  @Autowired
  ChessController(@Qualifier("manager.chess") Manager managerImpl) {
    manager = managerImpl;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<CommandResponse> move(@ModelAttribute Command command) {
    final OperationResult result = manager.move(command);
    return result.generateCommandResponse();
  }

  @PostMapping("start")
  @ResponseBody
  public ResponseEntity<CommandResponse> createGame() {
    manager.initializeGame();
    return new ResponseEntity<>(CommandResponse.of("Chess game has been created"), HttpStatus.OK);
  }

}
