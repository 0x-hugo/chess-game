package com.empanada.tdd.chess.shared;

public class Request {

  private String xOrig;
  private String xDest;

  private String yOrig;
  private String yDest;

  public static Request of(String xOrig, String yOrig, String xDest, String yDest) {
    return new Request(xOrig, yOrig, xDest, yDest);
  }

  public Request() {
  }

  public Request(String xOrig, String yOrig, String xDest, String yDest) {
    super();
    this.xOrig = xOrig;
    this.xDest = xDest;
    this.yOrig = yOrig;
    this.yDest = yDest;
  }

  public String getxOrig() {
    return xOrig;
  }

  public String getxDest() {
    return xDest;
  }

  public String getyOrig() {
    return yOrig;
  }

  public String getyDest() {
    return yDest;
  }

}
