package com.jiwon.calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringCalculator {

    private static final String REGEX_OPERATORS = "[+*/\\-]";
    private static final String REGEX_EXPRESSION = "^[0-9]+([.][0-9]+)?([+*/\\-][0-9]+([.][0-9]+)?)*";

    private final Map<String, Operator> operatorMap;

    public StringCalculator() {
        operatorMap = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "/", (a, b) -> {
                if (b == 0) {
                    throw new DivideByZeroException("값을 0으로 나눌 수 없습니다.");
                }
                return a / b;
            },
            "*", (a, b) -> a * b
        );
    }

    public double calculate(String formula) {
        if (isBlank(formula)) return 0;
        formula = removeSpace(formula);
        if (!isValid(formula)) return 0;

        double[] numbers = extractNumbers(formula);
        List<Operator> operators = extractOperators(formula);

        if (!isComputable(numbers, operators)) return 0;
        return compute(numbers, operators);
    }

    private String removeSpace(String formula) {
        return formula.replace(" ", "");
    }

    private double compute(double[] numbers, List<Operator> operators) {
        var iterOperator = operators.iterator();

        return Arrays.stream(numbers)
            .reduce((a, b) -> iterOperator.next().apply(a, b))
            .orElseThrow(IllegalArgumentException::new);
    }

    private double[] extractNumbers(String string) {
        return Arrays.stream(string.split(REGEX_OPERATORS)).mapToDouble(Double::parseDouble)
            .toArray();
    }

    private List<Operator> extractOperators(String string) {
        var stringOperators = Pattern.compile(REGEX_OPERATORS)
            .matcher(string)
            .results()
            .map(MatchResult::group)
            .collect(Collectors.toList());

        return stringOperators.stream().map(operatorMap::get).collect(Collectors.toList());
    }

    private boolean isComputable(double[] numbers, List<Operator> operators) {
        if (numbers.length == 1 && operators.isEmpty()) {
            return true;
        }

        return (numbers.length - 1) == operators.size();
    }

    private boolean isValid(String formula) {
        return Pattern.matches(REGEX_EXPRESSION, formula);
    }

    private boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        return string.isBlank();
    }

}
