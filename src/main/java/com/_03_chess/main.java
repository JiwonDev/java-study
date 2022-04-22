package com._03_chess;

import com._03_chess.controller.ChessController;
import com._03_chess.view.ChessView;
import com._03_chess.view.ConsoleInput;
import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        var view = new ChessView(new ConsoleInput());
        var controller = new ChessController();

        GameRequest request = view.inputGameStatus();
        //board
        controller.start(request);

        while (true) {
            InputRequest input = view.getInput(); // play
            GameResponse response = controller.play(input);
            if (response.isGameOver()) {
                break;
            }
        }
    }
}
