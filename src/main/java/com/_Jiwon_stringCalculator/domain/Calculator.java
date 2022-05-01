package com._Jiwon_stringCalculator.domain;

import java.util.List;

public final class Calculator {

    public double calculate(List<Double> operands) {
        return operands.stream()
            .reduce(0D, (total, next) -> total += next);
    }
}
