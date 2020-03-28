package com.empanada.tdd.chess.messaging;

public class Command {

  private ChessCoordinate origin;
  private ChessCoordinate destination;

  public static Command of(ChessCoordinate origin, ChessCoordinate destination) {
    return new Command(origin, destination);
  }

  private Command(ChessCoordinate origin, ChessCoordinate destination) {
    super();
    this.origin = origin;
    this.destination = destination;
  }

  private Command() {
  }

  public ChessCoordinate getOrigin() {
    return origin;
  }

  public ChessCoordinate getDestination() {
    return destination;
  }

  public void setDestination(ChessCoordinate destination) {
    this.destination = destination;
  }

  public void setOrigin(ChessCoordinate origin) {
    this.origin = origin;
  }

}
