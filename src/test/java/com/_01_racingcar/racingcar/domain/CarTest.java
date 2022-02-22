package com._01_racingcar.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import com._01_racingcar.racingcar.domain.Car;
import com._01_racingcar.racingcar.domain.CarFactory;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * - 자동차 생성 -> 1대 이상의 자동차가 존재해야 한다. -> 자동차의 이름이 공백안된다. 길이는 1이상 ~5이하 사이. -> 이름은 특수문자 금지. 영어만가능 -> 중복된
 * 이름의 자동차 금지 (when get same car throw execption ) -> 쉼표의 개수와 자동차 개수가 같아야 한다. 명확하게 하자면 : 스트링으로 여러
 * 자동차를 한번에 입력할 수 있다. (쉼표로 구분)
 */
class CarTest {

    @Nested
    @DisplayName("이름 유효성 확인")
    class CarNameCheck {

        @Test
        @DisplayName("1대 이상의 자동차 이름이 존재하고, 정상적으로 Car 생성에 성공한다.")
        void test1() throws Exception {
            // Arrange
            String inputCars = "A,B,C,D";
            CarFactory car = new CarFactory();

            // Act
            List<Car> carList = car.getCars(inputCars);
            List<String> realCarListNames = carList.stream().map(Car::getName).toList();

            // Assert
            assertThat(realCarListNames).isEqualTo(List.of("A", "B", "C", "D"));
            assertThat(carList).extracting("name", String.class)
                .contains("A", "B", "C", "D");
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("자동차의 이름 인자에 공백이나 null 을 입력하면 예외를 반환한다.")
        void null_and_empty_check_test(String args) throws Exception {
            // Given
            var car = new CarFactory();

            // When
            var throwable = catchThrowable(() -> car.getCars(args));

            // Then
            assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        }

        @TestFactory
        @DisplayName("이름은 영어만 가능하다. 만약 아닌 경우, 예외를 반환한다.")
        Collection<DynamicTest> test3() throws Exception {
            // Given
            var car = new CarFactory();

            return List.of(
                dynamicTest("다른 문자를 섞어 입력한 경우", () -> {
                    Throwable throwable = catchThrowable(() -> car.getCars("asdasd,qwe가q,qwq1qw"));
                    assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
                }),

                dynamicTest("숫자만 입력한 경우", () -> {
                    Throwable throwable = catchThrowable(() -> car.getCars("123125,32525,123123"));
                    assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
                }),

                dynamicTest("쉼표만 입력한 경우", () -> {
                    Throwable throwable = catchThrowable(() -> car.getCars(",,"));
                    assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
                })
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {/*"a", "aaaaaaaaaaaaa,a", "aaaaaaaaaaaa", "aaaaa", */"aaaa,aa,"})
        @DisplayName("자동차의 이름이 1자 이상 5자 이하라면 예외를 반환한다.")
        void name_length_check(String args) throws Exception {
            // Given
            var car = new CarFactory();

            // When
            var throwable = catchThrowable(() -> car.getCars(args));

            // Then
            assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복된 자동차 이름이 있는 지 검사")
        void CarTest() throws Exception {
            // Given
            var car = new CarFactory();
            String inputTest = "abcde,abcde";
            // When
            var throwable = catchThrowable(() -> car.getCars(inputTest));

            // Then
            assertThat(throwable).isInstanceOf(IllegalArgumentException.class);

        }

    }

}
