package com.empanada.tdd.chess.controllers;

interface Base {
  String home = "/chess";
}

public enum EndpointURL {
  app("/"),
  move("/"),
  create("/start");

  String url;

  EndpointURL(String string) {
    url = Base.home + string;
  }

  public String getUrl() {
    return url;
  }

}
