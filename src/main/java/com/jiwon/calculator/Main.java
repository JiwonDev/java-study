package com.jiwon.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("입력 : ");
        Scanner sc = new Scanner(System.in);
        var inputString = sc.nextLine();

        var stringCalculator = new StringCalculator();
        System.out.println("결과 : " + stringCalculator.getResult(inputString));
    }

}
