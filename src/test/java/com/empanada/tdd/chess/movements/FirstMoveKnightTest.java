package com.empanada.tdd.chess.movements;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

import com.empanada.tdd.chess.controllers.ChessController;
import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.utils.HttpUtils;
import com.empanada.tdd.chess.utils.JsonUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FirstMoveKnightTest extends GenericFirstMove {

  MockMvc mockMvc;

  @Autowired
  public FirstMoveKnightTest(MockMvc mockInstance, ChessController chessController) {
    super(chessController);
    mockMvc = mockInstance;
  }

  @BeforeEach
  public void startup() {
    super.prepare();
  }

  @AfterEach
  public void teardown() {
    super.destroyGame();
  }

  @Test
  public void moveLeftKnightToOkPosition() throws Exception {
    final Request validRequest = new Request("B", "1", "A", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void moveLeftKnightToAnotherOkPosition() throws Exception {
    final Request validRequest = new Request("B", "1", "C", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void moveLeftKnightOverAllyPiece() throws Exception {
    final Request validRequest = new Request("B", "1", "D", "2");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is5xxServerError())
        .andExpect(content().string(containsString(invalid_move_msg)));
  }

  @Test
  public void moveRightKnightToOkPosition() throws Exception {
    final Request validRequest = new Request("G", "1", "H", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void moveRightKnightToAnotherOkPosition() throws Exception {
    final Request validRequest = new Request("G", "1", "F", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

}
