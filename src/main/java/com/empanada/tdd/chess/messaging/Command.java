package com.empanada.tdd.chess.messaging;

public class Command {

  private Position origin;
  private Position destination;

  public static Command of(Position origin, Position destiny) {
    final Command command = new Command(origin, destiny);
    return command;
  }

  private Command(Position origin, Position destination) {
    super();
    this.origin = origin;
    this.destination = destination;
  }

  private Command() {
  }

  public Position getOrigin() {
    return origin;
  }

  public Position getDestination() {
    return destination;
  }

  public void setDestination(Position destination) {
    this.destination = destination;
  }

  public void setOrigin(Position origin) {
    this.origin = origin;
  }

}
