package com.empanada.tdd.chess.shared;

public enum OperationStatus {
  // TODO: refactor to properties
  OK(200),
  INVALID_MOVE(402),
  OUT_OF_BOUNDS(406);

  private Integer value;

  OperationStatus(int i) {
    value = i;
  }

  public Integer getValue() {
    return value;
  }
}
