package com.jiwon.calculator;

import com.jiwon.calculator.domain.DivideByZeroException;
import com.jiwon.calculator.domain.StringCalculator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("입력 : ");
        Scanner sc = new Scanner(System.in);
        var inputString = sc.nextLine();

        var stringCalculator = new StringCalculator();

        try {
            System.out.println("결과 : " + stringCalculator.calculate(inputString));
        } catch (DivideByZeroException e) {
            System.out.println("결과 : " + e.getMessage());
        }

    }

}
