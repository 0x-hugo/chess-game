package com.empanada.tdd.chess.messaging;

public class Command {

  private ChessPosition origin;
  private ChessPosition destination;

  public static Command of(ChessPosition origin, ChessPosition destiny) {
    final Command command = new Command(origin, destiny);
    return command;
  }

  private Command(ChessPosition origin, ChessPosition destination) {
    super();
    this.origin = origin;
    this.destination = destination;
  }

  private Command() {
  }

  public ChessPosition getOrigin() {
    return origin;
  }

  public ChessPosition getDestination() {
    return destination;
  }

  public void setDestination(ChessPosition destination) {
    this.destination = destination;
  }

  public void setOrigin(ChessPosition origin) {
    this.origin = origin;
  }

}
