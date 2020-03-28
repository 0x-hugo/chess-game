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

  public boolean isNotSuccesful() {
    return !(isSuccessful());
  }

  public boolean isSuccessful() {
    return status.getStatusCode() >= 200 && status.getStatusCode() < 300;
  }

  public String getStatusMessage() {
    return status.getMessage();
  }

  public ResponseEntity<Response> generateCommandResponse() {
    final Response responseMessage = Response.of(status.getMessage());
    return new ResponseEntity<>(responseMessage, HttpStatus.resolve(status.getStatusCode()));
  }

  public ResponseEntity<Response> generateCommandResponse(HttpStatus status) {
    return new ResponseEntity<>(Response.of(getStatusMessage()), status);
  }

  public static ResponseEntity<Response> generateCommandResponse(String message, HttpStatus status) {
    return new ResponseEntity<>(Response.of(message), status);
  }

}
