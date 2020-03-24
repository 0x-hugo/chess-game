package com.empanada.tdd.chess.shared;

public class CommandResponse {

  private String message;

  // TODO: refactorizar y pasarlo a properties
  private CommandResponse of(String message) {
    final CommandResponse cResponse = new CommandResponse(message);
    return cResponse;
  }

  private CommandResponse(String message) {
    this.message = message;
  }

  private CommandResponse() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
