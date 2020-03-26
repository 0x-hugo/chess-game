package com.empanada.tdd.chess;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.empanada.tdd.chess.controllers.ChessController;

@SpringBootTest
public class SmokeTest {

  @Autowired
  ChessController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }
}
