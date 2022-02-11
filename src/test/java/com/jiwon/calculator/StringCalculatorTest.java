package com.jiwon.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com.jiwon.calculator.domain.DivideByZeroException;
import com.jiwon.calculator.domain.StringCalculator;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * 요구사항 1. ('3+4+5' 를 입력하면 int 형으로 계산 결과를 반환한다.) 요구사항 2. ('3+' 처럼 처리할 수 없는 경우 0을 반환한다.) 요구사항 3. (0으로
 * 나눴다면 예외를 던진다. - 단, 연산자 우선순위는 고려하지 않는다.)
 */
final class StringCalculatorTest {

    @Test
    @DisplayName("올바른 식을 입력하고 계산 결과를 반환받는다.")
    void string_calculator_test() throws Exception {
        // Arrange 준비
        var calculator = new StringCalculator();

        // Act 실행
        var add = calculator.calculate("3+4+5");
        var subtract = calculator.calculate("3-4-5");
        var multiply = calculator.calculate("3*4*5");
        var divide = calculator.calculate("3/4/5");
        var result = calculator.calculate("20+40-10*20/50");

        // Assert 검증
        assertThat(add).isEqualTo(3 + 4 + 5);
        assertThat(subtract).isEqualTo(3 - 4 - 5);
        assertThat(multiply).isEqualTo(3 * 4 * 5);
        assertThat(divide).isEqualTo(3 / 4 / 5);
        assertThat(result).isEqualTo((20 + 40 - 10) * 20 / 50);
    }

    @Test
    @DisplayName("숫자만 입력하는 경우, 그 값을 그대로 반환한다.")
    void string_calculator_test2() throws Exception {
        // Arrange
        var calculator = new StringCalculator();

        // Act
        var result1 = calculator.calculate("1");
        var result2 = calculator.calculate("1000");

        // Assert
        assertThat(result1).isEqualTo(1L);
        assertThat(result2).isEqualTo(1000L);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("인자로 null 이나 공백을 전달하면 0을 반환한다.")
    void input_validation_test1(String args) throws Exception {
        //Arrange
        var calculator = new StringCalculator();

        // Act
        var result = calculator.calculate(args);

        // Assert
        assertThat(result).isEqualTo(0);
    }

    @TestFactory
    @DisplayName("인자로 받은 계산 식이 유효하지 않다면 0을 반환한다.")
    Collection<DynamicTest> input_validation_test2() {
        //Arrange
        var calculator = new StringCalculator();

        // Act & Assert
        return Arrays.asList(

            dynamicTest("시작 값이 숫자가 아닌 경우",
                () -> assertThat(calculator.calculate("+213+21")).isEqualTo(0)),

            dynamicTest("마지막 값이 숫자가 아닌 경우",
                () -> assertThat(calculator.calculate("3+")).isEqualTo(0)),

            dynamicTest("사용하지 않는 연산자가 포함된 경우",
                () -> assertThat(calculator.calculate("1$124%23^1")).isEqualTo(0)),

            dynamicTest("연산자만 존재하는 경우",
                () -> assertThat(calculator.calculate("+")).isEqualTo(0)));
    }

    @Test
    @DisplayName("0으로 나눴다면 DivideByZeroException 예외를 반환한다.")
    void zero_divide_test1() throws Exception {
        // Arrange
        var calculator = new StringCalculator();

        // Act
        var exception = catchThrowable(() -> calculator.calculate("3/0"));

        // Assert
        assertThat(exception).isInstanceOf(DivideByZeroException.class);
    }

    @Test
    @Disabled("zero_divide_test1 와 동일한 테스트")
    @DisplayName("0으로 나눴다면 DivideByZeroException 예외를 반환한다.")
    void zero_divide_test2() throws Exception {
        // Arrange
        var calculator = new StringCalculator();

        // Act & Assert
        assertThatExceptionOfType(DivideByZeroException.class)
            .isThrownBy(() -> calculator.calculate("3/0"));

    }
}
