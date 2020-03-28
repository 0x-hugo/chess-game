package com.empanada.tdd.chess.shared.exceptions;

// to refactor in StatusOperations
public class PositionException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public PositionException(String string) {
    super(string);
  }

  @Override
  public String getMessage() {
    return super.getMessage();
  }

}
