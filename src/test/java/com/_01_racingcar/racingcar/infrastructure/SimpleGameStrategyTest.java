package com._01_racingcar.racingcar.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import com._01_racingcar.racingcar.domain.Car;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class SimpleGameStrategyTest {

    @Test
    @DisplayName("자동차 거리는 음수가 되지 않는다. (가만히 있거나, 움직여야 한다.)")
    void simpleGameStrategyTest() throws Exception {
        // Arrange
        var strategy = new SimpleGameStrategy();
        var cars = List.of(Car.of("A"), Car.of("B"), Car.of("C"));

        // Act
        strategy.play(cars);
        var movedCars = cars.stream().filter(car -> car.getDistance() > -1).toList();

        // Assert
        assertThat(movedCars.size()).isEqualTo(cars.size());
    }

}
