package min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
//        CalculatorFromString();
    }

    private static void CalculatorFromString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> symbols = List.of("+", "-", "*", "/");
        LinkedList<String> list = new LinkedList<>();
        try {
            String getData = br.readLine();
            String[] split = getData.split("(?=[*/+-])|(?<=[*/+-])");
            double result = 0;
            for (String s : split) {
                if (symbols.stream().anyMatch(item -> item.equals(s))) {
                    list.addFirst(s);
                } else {
                    list.add(s);
                }
                if (list.size() == 3) {
                    String symbol = list.pop();
                    switch (symbol) {
                        case "+":
                            plus(list);
                            break;
                    }
                }
            }

            String pop = list.pop();
            if (symbols.stream().anyMatch(item -> item.equals(pop))) {
                System.out.println("0");
            } else {
                System.out.println("list.pop() = " + pop);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void plus(LinkedList<String> list) {
        String firstValue = list.pop();
        String secondValue = list.pop();
        double v = Double.parseDouble(firstValue) + Double.parseDouble(secondValue);
        list.push(String.valueOf(v));
    }
}
