package com.jiwon.calculator.domain;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException(String message) {
        super(message);
    }
}
