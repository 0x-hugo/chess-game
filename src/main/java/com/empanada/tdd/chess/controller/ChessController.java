package com.empanada.tdd.chess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empanada.tdd.chess.components.Manager;
import com.empanada.tdd.chess.messaging.Command;
import com.empanada.tdd.chess.shared.CommandResponse;

@Controller
@RequestMapping(value = "/")
public class ChessController {

  private final Manager manager;

  @Autowired
  ChessController(Manager managerImpl) {
    manager = managerImpl;
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<CommandResponse> move(@ModelAttribute Command command) {
    return null;
  }

  @PostMapping("reset")
  @ResponseBody
  public ResponseEntity<CommandResponse> createGame() {
    return null;
  }

  public Manager getManager() {
    return manager;
  }
}
