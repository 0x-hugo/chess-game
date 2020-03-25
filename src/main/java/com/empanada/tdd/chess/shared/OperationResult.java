package com.empanada.tdd.chess.shared;

public class OperationResult {

  private Integer status;

  public static OperationResult of(Integer status) {
    final OperationResult operationResult = new OperationResult(status);
    return operationResult;
  }

  private OperationResult(Integer status) {
    this.status = status;
  }

  private OperationResult() {
  }

  public Integer getState() {
    return status;
  }

  public boolean isValid() {
    return status >= 400;
  }

}
