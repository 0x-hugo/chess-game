package com.empanada.tdd.chess.shared;

public class Response {

  private String message;

  // TODO: refactorizar y pasarlo a properties
  public static Response of(String message) {
    final Response response = new Response(message);
    return response;
  }

  private Response(String message) {
    this.message = message;
  }

  private Response() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
