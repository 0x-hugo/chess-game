package com.empanada.tdd.chess;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.empanada.tdd.chess.controllers.EndpointURL;

@SpringBootTest
class ChessApplicationTests {

  public static final String appEndpoint = EndpointURL.app.getUrl();

  @Test
  void contextLoads() {

  }

}
