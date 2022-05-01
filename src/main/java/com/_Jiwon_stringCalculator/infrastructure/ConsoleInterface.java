package com._Jiwon_stringCalculator.infrastructure;

import com._Jiwon_stringCalculator.view.UserInterface;
import java.util.Scanner;

public final class ConsoleInterface implements UserInterface {

    private final Scanner scanner;

    public ConsoleInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }
}
