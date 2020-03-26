package com.empanada.tdd.chess.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OperationResult {

  private Integer statusCode;

  public static OperationResult of(Integer error) {
    final OperationResult operationResult = new OperationResult(error);
    return operationResult;
  }

  private OperationResult(Integer code) {
    this.statusCode = code;
  }

  private OperationResult() {
  }

  public Integer getStatusCode() {
    return statusCode;
  }

  public boolean isValid() {
    return statusCode >= 400;
  }

  public ResponseEntity<CommandResponse> generateCommandResponse() {
    return new ResponseEntity<>(HttpStatus.resolve(statusCode));
  }

}
