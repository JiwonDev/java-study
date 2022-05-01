package com._Jiwon_stringCalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class StringConverter {

    private static final String REGEX_OPERATORS = "[+]";
    // 참고: 숫자를 나타내는 정규표현식: [0-9]+ ( [.][0-9]+ )?
    private static final String REGEX_EXPRESSION = "^[0-9]+([.][0-9]+)?([+][0-9]+([.][0-9]+)?)*";

    /**
     * 문자열 형태의 연산식을 토큰으로 변환합니다.
     *
     * @param expression 연산식
     * @return 토큰 리스트
     */
    public List<Double> convert(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException();
        }
        if (!isParsable(expression)) {
            return List.of();
        }
        List<String> tokens = parseToken(expression);

        return toOperands(tokens);
    }

    private boolean isBlank(String string) {
        if (string == null) {
            return true;
        }
        return string.isBlank();
    }

    private boolean isParsable(String expression) {
        return Pattern.matches(REGEX_EXPRESSION, expression);
    }

    private List<Double> toOperands(List<String> tokens) {
        return tokens.stream()
            .map(Double::parseDouble)
            .toList();
    }

    private List<String> parseToken(String expression) {
        return Arrays.asList(expression.split("[+]"));
    }
}
