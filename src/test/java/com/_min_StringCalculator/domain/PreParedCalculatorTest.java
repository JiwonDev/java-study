package com._min_StringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PreParedCalculatorTest {

    @Test
    @DisplayName("매칭 값 찾기 True")
    public void matcherTrue() {
        PreParedCalculator calculator = new PreParedCalculator();

        boolean valid1 = calculator.isCorrectExpression("1+2+3+4");
        boolean valid2 = calculator.isCorrectExpression("23*45");
        boolean valid3 = calculator.isCorrectExpression("12-65");
        boolean valid4 = calculator.isCorrectExpression("13*65/14+309");

        assertThat(valid1).isTrue();
        assertThat(valid2).isTrue();
        assertThat(valid3).isTrue();
        assertThat(valid4).isTrue();
    }

    @Test
    @DisplayName("매칭 값 찾기 False")
    public void matcherFalse() {
        PreParedCalculator calculator = new PreParedCalculator();

        boolean valid1 = calculator.isCorrectExpression("1++4");
        boolean valid2 = calculator.isCorrectExpression("23+*45");
        boolean valid3 = calculator.isCorrectExpression("3+");
        boolean valid4 = calculator.isCorrectExpression("+12");

        assertThat(valid1).isFalse();
        assertThat(valid2).isFalse();
        assertThat(valid3).isFalse();
        assertThat(valid4).isFalse();
    }

    @Test
    @DisplayName("기호 분리하기")
    public void separateOperator() throws Exception {
        //arrange
        PreParedCalculator calculator = new PreParedCalculator();

        //act
        List<String> operator = calculator.getOperators("1+2-3*4");

        //assert
        assertThat(operator).isEqualTo(List.of("+", "-", "*"));

    }

    @Test
    @DisplayName("숫자 분리하기")
    public void separateNumber() throws Exception {
        //arrange
        PreParedCalculator calculator = new PreParedCalculator();

        //act
        List<Double> numbers = calculator.getNumbers("11+23*34");

        //assert
        assertThat(numbers).isEqualTo(List.of(11D, 23D, 34D));

    }

}