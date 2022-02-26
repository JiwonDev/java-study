package com._01_racingcar.racingcar.controller;

import static java.lang.System.out;

import com._01_racingcar.racingcar.application.RacingGameService;
import com._01_racingcar.racingcar.domain.Car;
import com._01_racingcar.racingcar.domain.CarFactory;
import com._01_racingcar.racingcar.domain.exception.InvalidCarNameException;
import java.util.List;

public final class RacingGameController {

    private final CarFactory carFactory;
    private final RacingGameService racingGameService;

    public RacingGameController(CarFactory carFactory, RacingGameService racingGameService) {
        this.carFactory = carFactory;
        this.racingGameService = racingGameService;
    }

    public void gameStart(String carNames, int attempts) {
        try {
            List<Car> carList = carFactory.getCars(carNames);
            racingGameService.start(attempts, carList);
        } catch (InvalidCarNameException e) {
            out.println(e.getMessage());
        }
    }
}
