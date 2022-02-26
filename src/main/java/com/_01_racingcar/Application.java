package com._01_racingcar;

import static java.lang.System.*;

import com._01_racingcar.racingcar.application.RacingGameService;
import com._01_racingcar.racingcar.controller.RacingGameController;
import com._01_racingcar.racingcar.domain.CarFactory;
import com._01_racingcar.racingcar.infrastructure.ConsoleScreenBoard;
import com._01_racingcar.racingcar.infrastructure.SimpleGameStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Application {

    public static void main(String[] args) throws IOException {
        // TODO 객체 Container 설정자를 만들어 해당 부분을 추상화한다.
        var racingGameService = new RacingGameService(new SimpleGameStrategy(),
            new ConsoleScreenBoard());
        var controller = new RacingGameController(new CarFactory(), racingGameService);

        // TODO view 패키지를 만들어 해당 부분을 추상화한다.
        var bufferedReader = new BufferedReader(new InputStreamReader(in));
        out.print("자동차들을 입력 하세요 -> ");
        var cars = bufferedReader.readLine();
        out.print("횟수를 입력 하세요 -> ");
        var attempt = Integer.parseInt(bufferedReader.readLine());

        controller.gameStart(cars, attempt);
    }
}
