package com._01_racingcar.racingcar.domain;

import java.util.List;

public interface ScreenBoard {

    void print(List<Car> carList);

    void printWinner(List<Car> winners);
}
