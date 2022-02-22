package com._01_racingcar.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public final class RacingGame {

    private final List<Car> carList = new ArrayList<>();
    private final GameStrategy gameStrategy;

    public RacingGame(List<Car> carFactory, GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
        carList.addAll(carFactory);
    }

    public void start(int attempt) {
        for (int i = 0; i < attempt; i++) {
            gameStrategy.play(carList);
        }
    }

    private List<Car> getResult() {
        int max = this.carList.stream().mapToInt(Car::getDistance).max()
            .orElseThrow(IllegalArgumentException::new);
        return this.carList.stream().filter(item -> item.getDistance() == max).toList();
    }
}
