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
public class QueenMovementTest extends GenericMovementTest {

  MockMvc mockMvc;

  @Autowired
  public QueenMovementTest(MockMvc mockInstance, ChessController chessController) {
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
    final Request invalidRequest = new Request("D", "1", "E", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(invalidRequest)))
        .andExpect(status().is5xxServerError())
        .andExpect(content().string(containsString("Not able to move Queen from [D1] to [E3].")));
  }

  @Test
  public void right() throws Exception {
    final Request twoSteps = new Request("E", "1", "E", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void left() throws Exception {
    final Request twoSteps = new Request("E", "3", "E", "1");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(twoSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void down() throws Exception {
    final Request oneStep = new Request("F", "3", "F", "2");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(oneStep)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void up() throws Exception {
    final Request threeSteps = new Request("F", "4", "F", "7");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(threeSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void upLeftDiagonal() throws Exception {
    final Request threeSteps = new Request("E", "4", "C", "6");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(threeSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void upRightDiagonal() throws Exception {
    final Request threeSteps = new Request("E", "4", "G", "6");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(threeSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void downRightDiagonal() throws Exception {
    final Request threeSteps = new Request("G", "6", "E", "4");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(threeSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void downLeftDiagonal() throws Exception {
    final Request threeSteps = new Request("E", "4", "C", "2");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(threeSteps)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }
}
