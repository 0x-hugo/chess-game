package com.empanada.tdd.chess.components.impl;

public enum ExecutionStatus {
  GAME_NOT_STARTED(false),
  NOT_VALID(false),
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
