package com.min.calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String SPLIT_OPERATOR_NUMBER = "(?<=[+*/-])|(?=[+*/-])";
    private final static List<String> SYMBOLS = List.of("+", "-", "*", "/");
    private final String stringFormula;

    public StringCalculator(String stringFormula) {
        this.stringFormula = stringFormula;
    }

    public String startCalculator() {
        if (!isValid()) {
            throw new IllegalArgumentException("식이 이상합니다.");
        }
        String[] splitData = splitOperatorsAndNumbers();
        LinkedList<String> result = new LinkedList<>();

        for (String splitDatum : splitData) {
            if (SYMBOLS.stream().anyMatch(item -> item.equals(splitDatum))) {
                result.addFirst(splitDatum);
            } else {
                result.add(splitDatum);
            }
            if (result.size() == 3) {
                String symbol = result.pop();
                switch (symbol) {
                    case "+" -> plus(result);
                    case "-" -> minus(result);
                    case "*" -> multiple(result);
                    case "/" -> divide(result);
                }
            }
        }
        return checkOtherCondition(result);
    }

    private String checkOtherCondition(LinkedList<String> result) {
        String pop = result.pop();
        String[] split = pop.split("\\.");
        if (Objects.equals(split[split.length - 1], "0")) {
            pop = split[0];
        }
        return pop;
    }

    private String[] splitOperatorsAndNumbers() {
        return stringFormula.split(SPLIT_OPERATOR_NUMBER);
    }

    private boolean isValid() {
        return Pattern.compile("^[0-9]+([+*/-][0-9]+)").matcher(stringFormula).find();
    }

    private void divide(LinkedList<String> list) {
        String firstValue = list.pop();
        String secondValue = list.pop();
        if (Objects.equals(secondValue, "0")) {
            throw new IllegalArgumentException("0으로 나눌수 없습니다");
        }
        double v = Double.parseDouble(firstValue) / Double.parseDouble(secondValue);
        list.push(String.valueOf(v));
    }

    private void multiple(LinkedList<String> list) {
        String firstValue = list.pop();
        String secondValue = list.pop();
        double v = Double.parseDouble(firstValue) * Double.parseDouble(secondValue);
        list.push(String.valueOf(v));
    }

    private void minus(LinkedList<String> list) {
        String firstValue = list.pop();
        String secondValue = list.pop();
        double v = Double.parseDouble(firstValue) - Double.parseDouble(secondValue);
        list.push(String.valueOf(v));
    }

    private void plus(LinkedList<String> list) {
        String firstValue = list.pop();
        String secondValue = list.pop();
        double v = Double.parseDouble(firstValue) + Double.parseDouble(secondValue);
        list.push(String.valueOf(v));
    }

}
