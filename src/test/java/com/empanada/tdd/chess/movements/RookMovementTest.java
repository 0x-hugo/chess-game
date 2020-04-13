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
public class RookMovementTest extends GenericMovementTest {

  MockMvc mockMvc;

  @Autowired
  public RookMovementTest(MockMvc mockInstance, ChessController chessController) {
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
  public void invalid() throws Exception {
    final Request invalidRequest = new Request("A", "1", "B", "2");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(invalidRequest)))
        .andExpect(status().is5xxServerError())
        .andExpect(content().string(containsString("Not able to move Rook from [A1] to [B2].")));
  }

  @Test
  public void up() throws Exception {
    final Request twoSteps = new Request("A", "1", "A", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void right() throws Exception {
    final Request twoSteps = new Request("A", "1", "C", "1");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void down() throws Exception {
    final Request twoSteps = new Request("A", "3", "A", "1");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void left() throws Exception {
    final Request twoSteps = new Request("A", "1", "C", "1");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }
}
