package com._03_chess.view;

import com._03_chess.GameRequest;
import com._03_chess.InputRequest;

public final class ChessView {

    private final Input input;

    public ChessView(Input consoleInput) {
        this.input = consoleInput;
    }

    public GameRequest inputGameStatus() {
        var inputString = input.getInput();

        while (true) {
            if (inputString.equals("start")) {
                return new GameRequest(true);
            }

            if (inputString.equals("end")) {
                return new GameRequest(false);
            }

            this.printEnterAgain();
        }
    }

    private void printEnterAgain() {
        input.print("다시 입력해 주세요");
    }

    public InputRequest getInput() {
        // TODO
        return null;
    }
}
