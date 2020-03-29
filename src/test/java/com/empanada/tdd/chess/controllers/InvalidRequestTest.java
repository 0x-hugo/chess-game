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
public class InvalidRequestTest {

  MockMvc mockMvc;
  ChessController chessAPI;

  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));
  public static final String playEndpoint = EndpointURL.move.getUrl();

  @Autowired
  public InvalidRequestTest(MockMvc mockInstance, ChessController apiImpl) {
    mockMvc = mockInstance;
    chessAPI = apiImpl;
  }

  @BeforeEach
  public void startup() {
    chessAPI.createGame();
  }

  @Test
  public void invalidStringLengthInXOrigCoordinate() throws Exception {
    final Request invalidRequest = new Request("XE", "3", "A", "3");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  private String asJsonString(Request request) {
    try {
      return new ObjectMapper().writeValueAsString(request);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void invalidStringLengthInYOrigCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "33", "A", "3");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  @Test
  public void invalidStringLengthInXDestCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "3", "AF", "3");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  @Test
  public void invalidStringLengthInYDestCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "3", "A", "23");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  @Test
  public void invalidValueInXOrigCoordinate() throws Exception {
    final Request invalidRequest = new Request("Z", "3", "A", "4");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  @Test
  public void invalidValueInYOrigCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "0", "A", "4");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  public void invalidValueInXDestCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "3", "I", "4");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }

  public void invalidValueInYDestCoordinate() throws Exception {
    final Request invalidRequest = new Request("A", "3", "A", "9");

    mockMvc.perform(post(playEndpoint)
        .contentType(APPLICATION_JSON_UTF8)
        .content(asJsonString(invalidRequest)))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(containsString("Invalid coordinates.")));
  }
}
