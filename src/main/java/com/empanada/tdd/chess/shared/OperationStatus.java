package com.empanada.tdd.chess.shared;

public enum OperationStatus {
  // TODO: refactor to properties
  OK(200, "OK."),
  INVALID_MOVE(402, "Invalid move."),
  INVALID_COORDINATE(406, "Invalid coordinates."),
  ;

  private Integer value;
  private String message;

  OperationStatus(int i, String message) {
    value = i;
    this.message = message;
  }

  public Integer getValue() {
    return value;
  }

  public String getMessage() {
    return message;
  }
}
