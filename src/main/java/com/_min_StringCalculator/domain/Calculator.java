package com._min_StringCalculator.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Calculator {

    private final Map<String, Operator> operatorMap;
<<<<<<< HEAD
    private final double UNEXPECTED_EXPRESSION = 0D;
=======
>>>>>>> 82595c3 (Strign Cal)

    public Calculator() {
        this.operatorMap = Map.of(
                "+", (a, b) -> a + b,
                "-", (a, b) -> a - b,
                "/", (a, b) -> {
<<<<<<< HEAD
                    if(b == UNEXPECTED_EXPRESSION){
=======
                    if(b == 0D){
>>>>>>> 82595c3 (Strign Cal)
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
<<<<<<< HEAD

        return UNEXPECTED_EXPRESSION;
=======
        return 0D;
>>>>>>> 82595c3 (Strign Cal)
    }

    private Double calculation(List<Double> numbers, List<String> operators) {
        Iterator<String> iterator = operators.iterator();
        return numbers.stream().reduce((x, y) ->
                operatorMap.get(iterator.next()).apply(x, y))
<<<<<<< HEAD
                .orElseGet(() -> UNEXPECTED_EXPRESSION);
=======
                .orElseGet(() -> 0D);
>>>>>>> 82595c3 (Strign Cal)
    }


}
