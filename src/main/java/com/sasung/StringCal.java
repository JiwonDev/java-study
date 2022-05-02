package com.sasung;

import java.util.ArrayList;
import java.util.List;

public final class StringCal {

    public int calculate(String strFormula) {
        String[] splittedCharacters = toCharacters(strFormula);
        List<Token> tokens = convertTokens(splittedCharacters);

        // SRP 단일 책임 원칙 - 하나의 메서드는 하나의 일만 하도록 만들어라.
        // 왜? -> 기능을 추가하기 어려우니까. 메서드가 비대하면 머리아프니까.
        return doArithmetic(tokens);
    }


    private String[] toCharacters(String string) {
        string.replace(" ", "");
        return string.split("");
    }

    /**
     * 한글자로 나눠진 String 배열을 받아서 토큰 리스트로 변환합니다.
     *
     * @param characters 한글자 단위로 나눠진 String 배열
     * @return Token 리스트로 변환합니다.
     * @throws IllegalArgumentException 올바른 연산식 토큰으로 변환할 수 없는 문자열인 경우
     */
    private List<Token> convertTokens(String[] characters) {

        List<Token> tokens = new ArrayList<>();

        StringBuilder number = new StringBuilder();
        boolean isOperatorBefore = false;

        for (int i = 0; i < characters.length; i++) {
            // 1. 연산자가 연속으로 나온 횟수
            String currentChar = characters[i];

            // 2. 쪼개진 문자열을 숫자인지 확인하고, 숫자라면 붙여서 토큰을 만든다.
            if (isDigit(currentChar)) {
                number.append(currentChar);
                isOperatorBefore = false;

            } else if (isOperator(currentChar)) {
                // 3. 이전에 나온 토큰이 연산자였다면, 반복문을 멈춘다.
                if (isOperatorBefore) {
                    throw new IllegalArgumentException();
                }

                isOperatorBefore = true;

                // 4. 연산자가 나오면 먼저 숫자를 추가한다.
                tokens.add(new Token(number.toString()));
                number.delete(0, number.length());

                // 5. 그 다음 연산자를 추가한다.
                tokens.add(new Token(currentChar));
            }

        }
        return tokens;
    }

    private boolean isOperator(String character) {
        // TODO 연산자 판별 함수 만들기
        return true;
    }

    private boolean isDigit(String character) {
        char ch = character.charAt(0);
        return Character.isDigit(ch);
    }

    /**
     * 토큰 리스트를 받아서 사칙 연산을 한 값을 반환한다.
     *
     * @param tokens 토큰 리스트
     * @return 계산한 숫자
     */
    private int doArithmetic(List<Token> tokens) {
//        int result = 0;
//        int i = 1;
//        do {
//            try {
//                int num1 = Integer.parseInt(tokens.get(i - 1));
//                int num2 = Integer.parseInt(tokens.get(i + 1));
//                String operator = tokens.get(i);
//
//                switch (operator) {
//                    case "+":
//                        result = num1 + num2;
//                        break;
//
//                    case "-":
//                        result = num1 - num2;
//                        break;
//
//                    case "*":
//                        result = num1 * num2;
//                        break;
//
//                    case "/":
//                        result = num1 / num2;
//                        break;
//                }
//
//                tokens.set(i - 1, String.valueOf(result));
//                tokens.remove(i);
//                tokens.remove(i);
//            } catch (Exception e) {
//                if (e instanceof ArithmeticException) {
//                    System.out.println("0으로 나눔");
//                } else {
//                    result = 0;
//                    System.out.println("처리할 수 없음" + e.getMessage());
//                }
//                break;
//            }
//        } while (i < tokens.size());
//
//        return result;
        return 0;
    }

}
