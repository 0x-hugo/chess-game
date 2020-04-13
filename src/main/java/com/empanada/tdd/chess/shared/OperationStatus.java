package com.empanada.tdd.chess.shared;

public enum OperationStatus {
  // TODO: refactor to properties
  OK(200, "OK."),
  NOT_OK(500);

  private Integer status_code;
  private String message;

  private OperationStatus(int code) {
    status_code = code;
  }

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
