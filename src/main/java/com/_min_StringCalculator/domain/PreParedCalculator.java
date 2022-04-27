package com._min_StringCalculator.domain;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreParedCalculator {
    private static final String RIGHT_EXPRESSION = "[0-9]+([+*/-][0-9]+)+";
    private static final String SPLIT_NUMBER = "[0-9]+";
    private static final String SPLIT_OPERATOR = "[+*/-]";

    public boolean isCorrectExpression(String fun) {
        Pattern compile = Pattern.compile(RIGHT_EXPRESSION);
        Matcher matcher = compile.matcher(fun);
        return matcher.find();
    }

    public List<String> getOperators(String fun) {
        if(isCorrectExpression(fun)){
            return Pattern.compile(SPLIT_OPERATOR).matcher(fun)
                    .results().map(MatchResult::group).toList();
        }
        return null;
    }

    public List<Double> getNumbers(String fun) {
        if(isCorrectExpression(fun)){
            return Pattern.compile(SPLIT_NUMBER).matcher(fun)
                    .results().map(x -> Double.parseDouble(x.group())).toList();
        }
        return null;
    }
}
