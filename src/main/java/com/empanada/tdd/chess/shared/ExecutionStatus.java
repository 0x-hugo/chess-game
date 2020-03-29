package com.empanada.tdd.chess.shared;

public enum ExecutionStatus {
  GAME_NOT_STARTED(false),
  NOT_OK(false),
  OK(true),
  ;

  Boolean successful;

  private ExecutionStatus(Boolean successful) {
    this.successful = successful;
  }

  public boolean isSuccessful() {
    return this.successful;
  }

  public boolean isNotSuccesful() {
    return !isSuccessful();
  }
}
