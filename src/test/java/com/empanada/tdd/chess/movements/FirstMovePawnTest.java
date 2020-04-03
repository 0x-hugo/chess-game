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
public class FirstMovePawnTest extends GenericFirstMove {

  MockMvc mockMvc;

  @Autowired
  public FirstMovePawnTest(MockMvc mockInstance, ChessController chessController) {
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
  public void movePawnOnePosition() throws Exception {
    final Request validRequest = new Request("D", "2", "D", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void movePawnTwoPositions() throws Exception {
    final Request validRequest = new Request("D", "2", "D", "4");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString(valid_move_msg)));
  }

  @Test
  public void movePawnThreePositions() throws Exception {
    final Request validRequest = new Request("D", "2", "D", "5");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is5xxServerError())
        .andExpect(content().string(containsString("Not able to move [D2] to [D5].")));
  }
}
