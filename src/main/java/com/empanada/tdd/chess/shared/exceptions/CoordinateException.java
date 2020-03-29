package com.empanada.tdd.chess.shared.exceptions;

import com.empanada.tdd.chess.shared.OperationStatus;

// to refactor in StatusOperations
public class CoordinateException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CoordinateException(OperationStatus opStatus) {
    super(opStatus.getMessage());
  }

  public CoordinateException(String string) {
    super(string);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

}
