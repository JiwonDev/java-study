package com._01_racingcar.racingcar.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import com._01_racingcar.racingcar.domain.Car;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

final class SimpleGameStrategyTest {

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

    @Test
    @DisplayName("가장 이동한 거리가 큰 자동차들이 우승자로 반환된다.")
    void test() throws Exception {
        // Arrange
        var strategy = new SimpleGameStrategy();
        var winnerCar1 = Car.of("A");
        var winnerCar2 = Car.of("B");
        winnerCar1.move();
        winnerCar2.move();

        var cars = List.of(winnerCar1, winnerCar2, Car.of("C"));

        // Act (sut == System Under Test)
        List<Car> winners = strategy.getWinners(cars);

        // Assert
        assertThat(winners).contains(winnerCar1, winnerCar2);
    }

}
