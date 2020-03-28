package com.empanada.tdd.chess.components.impl;

public class RuleStatus {

  private String message;
  private Boolean isValid;

  public static RuleStatus valid(String message) {
    return new RuleStatus(true, message);
  }

  public static RuleStatus invalid(String message) {
    return new RuleStatus(false, message);
  }

  public static RuleStatus valid() {
    return new RuleStatus(true);
  }

  public RuleStatus(Boolean isValid, String message) {
    this.isValid = isValid;
    this.message = message;
  }

  public RuleStatus(String message) {
    this.message = message;
  }

  public RuleStatus(Boolean isValid) {
    this.isValid = isValid;
  }

  public static ExecutionStatus executionStatus() {
    return ExecutionStatus.OK;
  }

  public boolean isValid() {
    return isValid;
  }

  public String getMessage() {
    return message;
  }

  public boolean isInvalid() {
    return !isValid();
  }

}
