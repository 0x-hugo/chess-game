package com.empanada.tdd.chess.startgame;

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

import com.empanada.tdd.chess.shared.Request;
import com.empanada.tdd.chess.utils.EndpointURL;
import com.empanada.tdd.chess.utils.HttpUtils;
import com.empanada.tdd.chess.utils.JsonUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StartChessGameTest {

  MockMvc mockMvc;

  private static String startEndpoint = EndpointURL.create.getUrl();
  private static String moveEndpoint = EndpointURL.move.getUrl();

  @Autowired
  StartChessGameTest(MockMvc mockIntance) {
    this.mockMvc = mockIntance;
  }

  @BeforeEach
  public void startup() {
  }

  @AfterEach
  public void teardown() {
  }

  @Test
  public void createGameHappyCase() throws Exception {
    mockMvc.perform(post(startEndpoint))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("Chess game has been created.")));
  }

  @Test
  public void moveWithoutStart() throws Exception {
    final Request validRequest = new Request("D", "2", "D", "3");

    mockMvc.perform(post(moveEndpoint)
        .contentType(HttpUtils.APPLICATION_JSON_UTF8)
        .content(JsonUtils.toJson(validRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Game has not been created.")));
  }
}
