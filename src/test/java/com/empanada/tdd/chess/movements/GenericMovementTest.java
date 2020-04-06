package com.empanada.tdd.chess.movements;

import org.springframework.beans.factory.annotation.Autowired;

import com.empanada.tdd.chess.controllers.ChessController;
import com.empanada.tdd.chess.utils.EndpointURL;

public class GenericFirstMove {

  ChessController chessAPI;

  protected String invalid_move_msg = "Invalid move.";
  protected String valid_move_msg = "OK.";

  protected String moveEndpoint = EndpointURL.move.getUrl();

  @Autowired
  public GenericFirstMove(ChessController apiImpl) {
    chessAPI = apiImpl;
  }

  public void prepare() {
    chessAPI.createGame();
  }

  protected void destroyGame() {
    chessAPI.destroyGame();
  }

}
