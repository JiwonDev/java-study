package com._Jiwon_stringCalculator.domain;

import java.util.List;

public final class Calculator {

    /**
     * 토큰(피연산자)를 받아 계산 결과를 반환합니다.
     * @param operands 토큰
     * @return 계산 결과
     */
    public double calculate(List<Double> operands) {
        return operands.stream()
            .reduce(0D, (total, next) -> total += next);
    }
}
