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

  @Autowired
  public FirstMoveTest(MockMvc mockInstance, ChessController apiImpl) {
    mockMvc = mockInstance;
    chessAPI = apiImpl;
  }

  @BeforeEach
  public void startup() {
    chessAPI.createGame();
  }

  @Test
  public void invalidCoordinatesOnOrigin() throws Exception {
    final Request invalidRequest = new Request('X', '9', 'A', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates")));
  }

  private String asJsonString(Request request) {
    try {
      return new ObjectMapper().writeValueAsString(request);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void invalidCoordinatesOnDestiny() throws Exception {
    final Request invalidRequest = new Request('F', '8', 'D', '9');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates")));

  }

  @Test
  public void movePieceOK() throws Exception {
    final Request validRequest = new Request('D', '2', 'D', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("OK")));

  }

  @Test
  public void movePieceLowerCaseOK() throws Exception {
    final Request validRequest = new Request('d', '2', 'd', '3');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(validRequest)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("OK")));

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
  public void moveKnightTroughPieces() throws Exception {
    final Request knigthMove = new Request('B', '8', 'C', '6');

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(knigthMove)))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string(containsString("OK")));

  }

}
