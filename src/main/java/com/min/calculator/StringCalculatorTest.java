package com.min.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("예외 테스트를 시작해보자")
    public void exceptionTest() {
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator("+3+4");
            stringCalculator.startCalculator();
        });
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            StringCalculator stringCalculator = new StringCalculator("4++5");
            stringCalculator.startCalculator();
        });
    }

    @Test
    @DisplayName("맞는 테스트를 시작해보지")
    public void test() {
        assertThat(new StringCalculator("123+145*1").startCalculator()).isEqualTo("268");
    }
}