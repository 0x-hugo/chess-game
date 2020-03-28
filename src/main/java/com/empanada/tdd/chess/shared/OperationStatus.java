package com.empanada.tdd.chess.shared;

public enum OperationStatus {
  // TODO: refactor to properties
  OK(200, "OK."),
  INVALID_MOVE(402, "Invalid move."),
  INVALID_COORDINATE(406, "Invalid coordinates."),
  INVALID_INIT_GAME(402, "Error on start. Try later."),
  ;

  private Integer status_code;
  private String message;

  OperationStatus(int code, String message) {
    status_code = code;
    this.message = message;
  }

  public Integer getStatusCode() {
    return status_code;
  }

  public String getMessage() {
    return message;
  }
}
