package com._min_StringCalculator.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Map<String, Operator> operatorMap;
    private final double UNEXPECTED_EXPRESSION = 0D;

    public Calculator() {
        this.operatorMap = Map.of(
                "+", (a, b) -> a + b,
                "-", (a, b) -> a - b,
                "/", (a, b) -> {
                    if(b == UNEXPECTED_EXPRESSION){
                        throw new RuntimeException("0으로 나누기 불가");
                    }
                    return a / b;
                },
                "*", (a, b) -> a * b
        );
    }

    public Double start(String fun) {
        PreParedCalculator preParedCalculator = new PreParedCalculator();
        boolean correctExpression = preParedCalculator.isCorrectExpression(fun);
        if(correctExpression){
            List<Double> numbers = preParedCalculator.getNumbers(fun);
            List<String> operators = preParedCalculator.getOperators(fun);
            return calculation(numbers, operators);
        }

        return UNEXPECTED_EXPRESSION;
    }

    private Double calculation(List<Double> numbers, List<String> operators) {
        Iterator<String> iterator = operators.iterator();
        return numbers.stream().reduce((x, y) ->
                operatorMap.get(iterator.next()).apply(x, y))
                .orElseGet(() -> UNEXPECTED_EXPRESSION);
    }


}
