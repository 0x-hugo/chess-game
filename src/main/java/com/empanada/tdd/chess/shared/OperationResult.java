package com.empanada.tdd.chess.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class OperationResult {

  private OperationStatus status;
  private String message;

  public static OperationResult of(OperationStatus status) {
    return new OperationResult(status);
  }

  private OperationResult(OperationStatus status) {
    this.status = status;
  }

  public static OperationResult of(OperationStatus status, String message) {
    return new OperationResult(message, status);
  }

  private OperationResult(String message, OperationStatus status) {
    this.message = message;
    this.status = status;
  }

  private OperationResult() {
  }

  public ResponseEntity<Response> generateCommandResponse(HttpStatus status) {
    return new ResponseEntity<>(Response.of(getStatusMessage()), status);
  }

  public String getStatusMessage() {
    return status.getMessage();
  }

  public ResponseEntity<Response> generateCommandResponse() {
    final Response responseMessage = Response.of(getExistentMessage());
    return new ResponseEntity<>(responseMessage, HttpStatus.resolve(status.getStatusCode()));
  }

  private String getExistentMessage() {
    assert (this.status != null);
    return this.hasMessage()
        ? this.message
        : status.getMessage();
  }

  private boolean hasMessage() {
    return !StringUtils.isEmpty(this.message);
  }

  public static ResponseEntity<Response> generateResponse(HttpStatus status, String message) {
    return new ResponseEntity<>(Response.of(message), status);
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
}
