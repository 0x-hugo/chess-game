package com.empanada.tdd.chess.shared;

public class ExecutionResult {

  private ExecutionStatus status;
  private String message;

  public static ExecutionResult of(ExecutionStatus status) {
//    if (status == ExecutionStatus.GAME_NOT_STARTED) // TODO: Quien tiene que informar si el juego no arranco?
    return new ExecutionResult(status);
  }

  private ExecutionResult(ExecutionStatus status) {
    this.status = status;
  }

  public static ExecutionResult of(ExecutionStatus status, String message) {
    return new ExecutionResult(status, message);
  }

  private ExecutionResult(ExecutionStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  private ExecutionResult() {
  }

  public OperationResult toOperationResult() {
    return (status.isSuccessful())
        ? OperationResult.of(OperationStatus.OK, message)
        : OperationResult.of(OperationStatus.INVALID_MOVE, message);
  }

}
