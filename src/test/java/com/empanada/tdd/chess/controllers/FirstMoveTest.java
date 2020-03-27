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

import com.empanada.tdd.chess.shared.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FirstMoveTest {

  MockMvc mockMvc;
  ChessController chessAPI;

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
  public static final String playEndpoint = "/";

  @BeforeEach
  @Autowired
  public void startup(MockMvc mockMvcInstance, ChessController apiImpl) {
    mockMvc = mockMvcInstance;
    chessAPI = apiImpl;
    setupScenarioForFirstMove();
  }

  private void setupScenarioForFirstMove() {
    chessAPI.createGame();
  }

  @Test
  public void invalidPosition() throws Exception {
    final Request invalidRequest = new Request('X', '9', 'A', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid position")));
  }

  private String asJsonString(Request request) {
    try {
      return new ObjectMapper().writeValueAsString(request);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void movePieceOK() throws Exception {
    final Request validRequest = new Request('D', '2', 'D', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("Todo ok")));

  }

  @Test
  public void movePieceLowerCaseOK() throws Exception {
    final Request validRequest = new Request('d', '2', 'd', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("Todo ok")));

  }

  @Test
  public void invalidMove() throws Exception {
    final Request invalidRequest = new Request('F', '8', 'D', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid move")));

  }

  @Test
  public void outOfBoundMove() throws Exception {
    final Request invalidRequest = new Request('F', '8', 'D', '9');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("out of bounds")));

  }

}
