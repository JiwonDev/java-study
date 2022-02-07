package jiwon.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * 요구사항
 * 1. '3+4+5' 를 입력하면 int 형으로 계산 결과를 반환한다.
 * 2. '3+' 처럼 처리할 수 없는 경우 0을 반환한다.
 */
public final class StringCalculatorTest {

    @Test
    @DisplayName("올바른 식을 입력하고 계산 결과를 반환받는다.")
    void StringCalculatorTest() throws Exception {
        // Arrange 준비
        var calculator = new StringCalculator();

        // Act 실행
        var result = calculator.getResult("3+4+5");

        // Assert 검증
        assertEquals(result, 3 + 4 + 5);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("인자로 null 이나 공백을 전달하면 0을 반환한다.")
    void input_validation_test1(String args) throws Exception {
        //Arrange
        var calculator = new StringCalculator();

        // Act
        var result = calculator.getResult(args);

        // Assert
        assertEquals(result, 0);
    }

    @TestFactory
    @DisplayName("인자로 받은 계산 식이 유효하지 않다면 0을 반환한다.")
    Collection<DynamicTest> input_validation_test2() {
        //Arrange
        var calculator = new StringCalculator();

        // Act & Assert
        return Arrays.asList(
            dynamicTest("시작 값이 숫자가 아닌 경우",
                () -> assertEquals(0, calculator.getResult("+213+21"))),

            dynamicTest("마지막 값이 숫자가 아닌 경우",
                () -> assertEquals(0, calculator.getResult("3+"))),

            dynamicTest("사용하지 않는 연산자가 포함된 경우",
                () -> assertEquals(0, calculator.getResult("1-124*23/1"))),

            dynamicTest("숫자만 존재하는 경우",
                () -> assertEquals(0, calculator.getResult("1234")))
        );
    }

}
