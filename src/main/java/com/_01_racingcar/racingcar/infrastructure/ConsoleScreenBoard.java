package com._01_racingcar.racingcar.infrastructure;

import static java.lang.System.*;

import com._01_racingcar.racingcar.domain.Car;
import com._01_racingcar.racingcar.domain.ScreenBoard;
import java.util.List;

public final class ConsoleScreenBoard implements ScreenBoard {

    private static final String DRAW_DISTANCE = "--|";

    @Override
    public void print(List<Car> carList) {
        for (Car car : carList) {
            out.println(car.getName() + " " + DRAW_DISTANCE.repeat(car.getDistance()) + "O");
        }
        out.println();
    }

    @Override
    public void printWinner(List<Car> winners) {
        out.println("the winner(s) : " + winners);
    }
}
