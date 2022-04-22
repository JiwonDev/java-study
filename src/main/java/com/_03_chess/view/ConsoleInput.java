package com._03_chess.view;

import java.util.Scanner;

public final class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String getInput() {
        return scanner.nextLine();
    }
}
