package com.empanada.tdd.chess.utils;

import com.empanada.tdd.chess.shared.Request;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

  public static String toJson(Request request) {
    try {
      return new ObjectMapper().writeValueAsString(request);
    } catch (final Exception e) {
      throw new RuntimeException(e);
    }
  }

}
