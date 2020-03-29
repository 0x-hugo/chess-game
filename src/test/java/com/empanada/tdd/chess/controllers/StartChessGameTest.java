package com.empanada.tdd.chess.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.empanada.tdd.chess.shared.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StartChessGameTest {

  MockMvc mockMvc;

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

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
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(validRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Game has not been created.")));
  }

  private String asJsonString(Request request) {
    try {
      return new ObjectMapper().writeValueAsString(request);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }
}
