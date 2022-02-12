package com.min.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculatorMain {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String formula = bufferedReader.readLine();
        String stringCalculator = new StringCalculator(formula).startCalculator();
        System.out.println("결과값 = " + stringCalculator);
    }
}
