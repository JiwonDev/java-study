package com._03_chess.view;

import static org.assertj.core.api.Assertions.assertThat;

import com._03_chess.GameRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessViewTest {
    @Test
    @DisplayName("start 를 입력 받으면 게임을 실행한다.")
    void startGame() throws Exception {
        ChessView view = new ChessView(new StubInput("start"));
        GameRequest gameRequest = view.inputGameStatus();
        assertThat(gameRequest.isStatus()).isTrue();
    }

    @Test
    @DisplayName("end 를 입력 받으면 게임을 종료한다.")
    void endGame() throws Exception {
        ChessView view = new ChessView(new StubInput("end"));
        GameRequest gameRequest = view.inputGameStatus();
        assertThat(gameRequest.isStatus()).isFalse();
    }

    private static class StubInput implements Input {
        private final String undefinedString;

        public StubInput(String s) {
            this.undefinedString = s;
        }

        @Override
        public void print(String message) {

        }

        @Override
        public String getInput() {
            return this.undefinedString;
        }
    }
}
