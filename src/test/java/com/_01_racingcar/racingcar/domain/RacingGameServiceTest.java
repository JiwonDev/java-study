package com._01_racingcar.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com._01_racingcar.racingcar.application.RacingGameService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGame 도메인 서비스 테스트")
final class RacingGameServiceTest {

    @Test
    @DisplayName("게미을 실행하고 입력한 횟수만큼 자동차 경주를 진행한다.")
    void show_result() throws Exception {
        // Arrange
        var spyGameStrategy = new SpyGameStrategy();
        var cars = List.of(Car.of("A"), Car.of("B"), Car.of("C"));
        var screenBoard = new spyScreenBoard();

        var racingGame = new RacingGameService(spyGameStrategy, screenBoard);
        final var attempts = 5;

        // Act
        racingGame.start(attempts, cars);

        // Assert
        assertThat(spyGameStrategy.getAttempts()).isEqualTo(attempts);
        assertThat(screenBoard.getAttempts()).isEqualTo(attempts);
    }

    @Test
    @DisplayName("게임을 실행하고 정상적으로 완료된 후 화면에 우승자가 출력된다.")
    void racingGameServiceTest() throws Exception {
        // Arrange
        var gameStrategy = new SpyGameStrategy();
        var screenBoard = new spyScreenBoard();
        var racingGame = new RacingGameService(gameStrategy, screenBoard);
        var cars = List.of(Car.of("A"), Car.of("B"), Car.of("C"));

        // Act
        racingGame.start(5, cars);
        racingGame.finish(cars);

        // Assert
        assertThat(gameStrategy.isFinish()).isTrue();
        assertThat(screenBoard.isPrintWinner()).isTrue();

    }

    static private class SpyGameStrategy implements GameStrategy {

        private int attempts = 0;

        private boolean isFinish = false;

        public boolean isFinish() {
            return isFinish;
        }

        @Override
        public void play(List<Car> carList) {
            attempts++;
        }

        @Override
        public List<Car> getWinners(List<Car> carList) {
            this.isFinish = true;
            return carList;
        }

        public int getAttempts() {
            return attempts;
        }
    }

    private static class spyScreenBoard implements ScreenBoard {

        private boolean isPrintWinner = false;

        private int attempts = 0;

        @Override
        public void print(List<Car> carList) {
            attempts++;
        }

        @Override
        public void printWinner(List<Car> winners) {
            this.isPrintWinner = true;
        }

        public int getAttempts() {
            return attempts;
        }

        public boolean isPrintWinner() {
            return isPrintWinner;
        }
    }
}
