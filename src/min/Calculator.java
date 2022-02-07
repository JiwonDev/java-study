package min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Calculator {

    private final static List<String> SYMBOLS = List.of("+", "-", "*", "/");
    private final LinkedList<String> result = new LinkedList<>();
    private final List<String> splitData = new ArrayList<>();

    public Calculator() {
        inputData();
        startCalculator();
    }

    private void startCalculator() {
        for (String splitDatum : splitData) {
            if (SYMBOLS.stream().anyMatch(item -> item.equals(splitDatum))) {
                result.addFirst(splitDatum);
            } else {
                result.add(splitDatum);
            }
            if (result.size() == 3) {
                String symbol = result.pop();
                switch (symbol) {
                    case "+":
                        plus(result);
                        break;
                    case "-":
                        minus(result);
                    case "*":
                        multiple(result);
                        break;
                    case "/":
                        divide(result);
                        break;
                }
            }
        }
        checkOtherCondition();
    }
    private void checkOtherCondition() {
        String pop = result.pop();
        String[] split = pop.split("\\.");
        if (Objects.equals(split[split.length - 1], "0")) {
            pop = split[0];
        }
        System.out.println(pop);
    }

    private void inputData() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String getData = br.readLine();
            String[] split = getData.split("(?=[*/+-])|(?<=[*/+-])");
            if (SYMBOLS.stream().noneMatch(item -> item.equals(split[split.length - 1]))) {
                this.splitData.addAll(List.of(split));
            }else {
                throw new IllegalArgumentException("수식이 잘못됨");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
