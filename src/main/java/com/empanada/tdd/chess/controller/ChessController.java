package com.empanada.tdd.chess.controller;

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

  private final Manager manager;

  @Autowired
  ChessController(@Qualifier("manager.chess") Manager managerImpl) {
    manager = managerImpl;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<CommandResponse> move(@ModelAttribute Command command) {
    final OperationResult result = manager.move(command);

    if (result.getState() >= HttpStatus.BAD_REQUEST.value())
      new ResponseEntity<CommandResponse>(HttpStatus.BAD_REQUEST);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("start")
  @ResponseBody
  public ResponseEntity<CommandResponse> createGame() {
    return new ResponseEntity<>(CommandResponse.of("Chess game has been created"), HttpStatus.OK);
  }

  public Manager getManager() {
    return manager;
  }
}
