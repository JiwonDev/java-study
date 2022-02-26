package com._01_racingcar.racingcar.application;

import com._01_racingcar.racingcar.domain.Car;
import com._01_racingcar.racingcar.domain.GameStrategy;
import com._01_racingcar.racingcar.domain.ScreenBoard;
import java.util.List;

public final class RacingGameService {

    private final GameStrategy gameStrategy;
    private final ScreenBoard screenBoard;

    public RacingGameService(GameStrategy gameStrategy,
        ScreenBoard screenBoard) {
        this.gameStrategy = gameStrategy;
        this.screenBoard = screenBoard;
    }

    public void start(int attempt, List<Car> carList) {
        for (int i = 0; i < attempt; i++) {
            gameStrategy.play(carList);
            screenBoard.print(carList);
        }
        finish(carList);
    }

    public void finish(List<Car> carList) {
        screenBoard.printWinner(gameStrategy.getWinners(carList));
    }
}
