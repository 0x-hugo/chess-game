package com.empanada.tdd.chess.messaging;

import com.empanada.tdd.chess.model.table.Coordinate;

public class Command {

  private Coordinate origin;
  private Coordinate destination;

  public static Command of(Coordinate origin, Coordinate destination) {
    return new Command(origin, destination);
  }

  private Command(Coordinate origin, Coordinate destination) {
    super();
    this.origin = origin;
    this.destination = destination;
  }

  private Command() {
  }

  public Coordinate getOrigin() {
    return origin;
  }

  public Coordinate getDestination() {
    return destination;
  }

  public void setDestination(Coordinate destination) {
    this.destination = destination;
  }

  public void setOrigin(Coordinate origin) {
    this.origin = origin;
  }

}
