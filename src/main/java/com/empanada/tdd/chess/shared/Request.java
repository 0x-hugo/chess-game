package com.empanada.tdd.chess.shared;

public class Request {

  private final Character xOrig;
  private final Character xDest;

  private final Character yOrig;
  private final Character yDest;

  public static Request of(Character xOrig, Character yOrig, Character xDest, Character yDest) {
    return new Request(xOrig, yOrig, xDest, yDest);
  }

  public Request(Character xOrig, Character yOrig, Character xDest, Character yDest) {
    super();
    this.xOrig = xOrig;
    this.xDest = xDest;
    this.yOrig = yOrig;
    this.yDest = yDest;
  }

  public Character getxOrig() {
    return xOrig;
  }

  public Character getxDest() {
    return xDest;
  }

  public Character getyOrig() {
    return yOrig;
  }

  public Character getyDest() {
    return yDest;
  }

}
