package com.empanada.tdd.chess.shared.exceptions;

import com.empanada.tdd.chess.shared.OperationStatus;

// to refactor in StatusOperations
public class CommandException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  OperationStatus status;

  public CommandException(OperationStatus opStatus) {
    super(opStatus.getMessage());
    status = opStatus;
  }

  public CommandException(OperationStatus opStatus, String message) {
    super(message);
    status = opStatus;
  }

  public CommandException(String string) {
    super(string);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  public OperationStatus getStatus() {
    return status;
  }

}
