package com.ch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1. 문자열 덧셈 계산기 구현
        //- '3+4+5' 를 입력하면 int 형으로 결과를 반환한다.
        //- '3+' 처럼 처리할 수 없는 경우 0을 반환한다.
        System.out.print("insert your formula: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringCalculator stringCalculator = new StringCalculator();
        String result = stringCalculator.CalCulate(str);
        System.out.println(result);
    }
}

