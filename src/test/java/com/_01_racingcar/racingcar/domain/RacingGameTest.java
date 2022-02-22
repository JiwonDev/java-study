package com._01_racingcar.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingGame 도메인 서비스 테스트")
class RacingGameTest {

    @Test
    @DisplayName("입력한 횟수만큼 자동차 경주를 진행한다.")
    void show_result() throws Exception {
        // Arrange
        var spyGameStrategy = new SpyGameStrategy();
        var racingGame = new RacingGame(List.of(Car.of("A"), Car.of("B"), Car.of("C")),
            spyGameStrategy);
        final var attempts = 5;

        // Act
        racingGame.start(attempts);

        // Assert
        assertThat(attempts).isEqualTo(spyGameStrategy.getAttempts());
    }

    static private class SpyGameStrategy implements GameStrategy {

        private int attempts = 0;

        @Override
        public void play(List<Car> carList) {
            attempts++;
        }

        public int getAttempts() {
            return attempts;
        }
    }

}
