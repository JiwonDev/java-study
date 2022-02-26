package com._01_racingcar.racingcar.domain;

import lombok.Getter;

@Getter
public final class Car {

    private String name;

    private Position position;

    private Car(String name) {
        this.name = name;
        this.position = new Position();
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        position.increase();
    }

    public int getDistance() {
        return position.getDistance();
    }

    @Override
    public String toString() {
        return name;
    }

    static class Position {

        private int distance;

        private Position() {
            this.distance = 0;
        }

        private void increase() {
            distance += 1;
        }

        public int getDistance() {
            return distance;
        }
    }
}
