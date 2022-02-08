package com.jiwon.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringCalculator {

    private static final String REGEX_OPERATORS = "[+]";
    private static final String REGEX_EXPRESSION = "^[0-9]([+][0-9])*";

    public int getResult(String string) {
        if (isBlank(string) || !isValid(string)) {
            return 0;
        }
        int[] numbers = extractNumbers(string);
        List<String> operators = extractOperators(string);

        return calculate(numbers, operators);
    }

    private int calculate(int[] numbers, List<String> operators) {
        //TODO operator 가 추가되면 하나씩 계산하도록 리팩토링
        return Arrays.stream(numbers).sum();
    }

    private int[] extractNumbers(String string) {
        return Arrays.stream(string.split(REGEX_OPERATORS)).mapToInt(Integer::parseInt).toArray();
    }

    private List<String> extractOperators(String string) {
        return Pattern.compile(REGEX_OPERATORS).matcher(string).results().map(MatchResult::group)
            .collect(Collectors.toList());
    }

    private boolean isValid(String string) {
        return Pattern.matches(REGEX_EXPRESSION, string);
    }

    private boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        return string.isBlank();
    }

}
