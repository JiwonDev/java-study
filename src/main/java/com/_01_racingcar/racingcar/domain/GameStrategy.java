package com._01_racingcar.racingcar.domain;

import java.util.List;

public interface GameStrategy {

    void play(List<Car> carList);

    List<Car> getWinners(List<Car> carList);
}
