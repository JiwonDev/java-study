package com._01_racingcar.racingcar.infrastructure;

import com._01_racingcar.racingcar.domain.Car;
import com._01_racingcar.racingcar.domain.GameStrategy;
import java.util.List;
import java.util.Random;

public final class SimpleGameStrategy implements GameStrategy {

    private final Random random = new Random();

    @Override
    public List<Car> getWinners(List<Car> carList) {
        int max = carList.stream().mapToInt(Car::getDistance).max()
            .orElseThrow(IllegalArgumentException::new);

        return carList.stream().filter(item -> item.getDistance() == max).toList();
    }

    @Override
    public void play(List<Car> carList) {
        carList.forEach(car -> {
            if (canBeMoved()) {
                car.move();
            }
        });
    }

    private boolean canBeMoved() {
        return random.nextInt(9) > 3;
    }
}

