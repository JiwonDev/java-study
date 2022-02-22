package com._01_racingcar.racingcar.domain;

import static org.junit.platform.commons.util.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class CarFactory {

    public List<Car> getCars(String inputString) {
        if (!isValid(inputString)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return toCars(inputString);
    }

    private boolean isValid(String inputString) {
        if (isBlank(inputString)) {
            return false;
        }
        if (!isAlpha(inputString.replace(",", ""))) {
            return false;
        }
        if (!isShorterThan(inputString, 5)) {
            return false;
        }
        var lastChar = inputString.substring(inputString.length() - 1);
        if (lastChar.equals(",")) {
            return false;
        }

        return !isDuplicated(inputString);
    }

    private List<Car> toCars(String inputString) {
        List<Car> lists = new ArrayList<>();
        String[] split = inputString.split(",");
        for (String s : split) {
            Car car = Car.of(s);
            lists.add(car);
        }
        return lists;
    }

    private boolean isDuplicated(String name) {
        var cars = List.of(name.split(","));
        var setCars = new HashSet<>(cars);
        return cars.size() != setCars.size();
    }

    private boolean isShorterThan(String readLine, int limit) {
        var cars = readLine.split(",");
        boolean flag = true;
        for (String car : cars) {
            if (car.length() > limit) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
}
