package com.empanada.tdd.chess.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StartChessGameTest {

  MockMvc mockMvc;

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
  private static String startEndpoint = "/start";

  @Autowired
  StartChessGameTest(MockMvc mockIntance) {
    this.mockMvc = mockIntance;
  }

  @BeforeEach
  public void startup() {
  }

  @Test
  public void createGameHappyCase() throws Exception {
    mockMvc.perform(post(startEndpoint))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("Chess game has been created")));
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
