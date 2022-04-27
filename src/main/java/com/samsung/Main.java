package com.samsung;

import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈식을 입력해 주세요.");


        String str = scanner.nextLine();
        StringCal stringCal = new StringCal();

        System.out.println(stringCal.add(str));
    }

}
