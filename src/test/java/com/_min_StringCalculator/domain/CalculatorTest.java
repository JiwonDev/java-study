package com._min_StringCalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    @DisplayName("연산 시작 true")
    public void StartCalculatorTrue() throws Exception{
        //arrange
        Calculator calculator = new Calculator();

        //act
        Double start = calculator.start("1+2+3+4");

        //assert
        assertThat(start).isEqualTo(10D);

     }

    @Test
    @DisplayName("연산 시작 false")
    public void StartCalculatorFalse() throws Exception{
        //arrange
        Calculator calculator = new Calculator();

        //act
        Double start = calculator.start("1++1");

        //assert
        assertThat(start).isEqualTo(0D);

    }

    @Test
    @DisplayName("0으로 나눌때 0으로 나눌수 없습니다 Exception")
    public void StartCalculatorDivideZero() throws Exception{
        //arrange
        Calculator calculator = new Calculator();

        //act


        //assert
        assertThatThrownBy(() -> calculator.start("10/0"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("0으로 나누기 불가");

    }

}