package com._03_chess.controller;

import com._03_chess.GameRequest;
import com._03_chess.GameResponse;
import com._03_chess.InputRequest;
import com._03_chess.domain.ChessBoard;

public final class ChessController {

    public void start(GameRequest request) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.init();
    }

    public GameResponse play(InputRequest request) {

        return null;
    }
}
