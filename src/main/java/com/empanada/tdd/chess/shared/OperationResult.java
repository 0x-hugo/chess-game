package com.empanada.tdd.chess.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OperationResult {

  private OperationStatus status;

  public static OperationResult of(OperationStatus status) {
    return new OperationResult(status);
  }

  private OperationResult(OperationStatus status) {
    this.status = status;
  }

  private OperationResult() {
  }

  public OperationStatus getCurrentStatus() {
    return status;
  }

  public boolean isSuccessful() {
    return status.getValue() >= 200 && status.getValue() < 300;
  }

  public ResponseEntity<Response> generateCommandResponse() {
    return new ResponseEntity<>(HttpStatus.resolve(status.getValue()));
  }

}
