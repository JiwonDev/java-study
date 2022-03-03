package com._02_lottoticket.lotto_ticket.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoTest {

    @Test
    @DisplayName("지난 주 당첨 번호를 6개를 직접 입력받는다.")
    void test1() throws Exception {
        //Arrange
        var numbers = List.of(1, 2, 3, 4, 5, 6);

        // Act
        Lotto lotto = Lotto.create(numbers);

        // Assert
        assertThat(lotto.getNumbers()).contains(6, 2, 3, 4, 5, 1);
    }

    @Test
    @DisplayName("문자열로 로또번호 6개를 따음표로 구분해서 입력받을 수 있어야한다.")
    void test22() throws Exception {
        // Arrange
        var numbers = "1,2,3,4,5,6";

        // Act
        var lotto = Lotto.create(numbers);

        // Assert
        assertThat(lotto.getNumbers()).contains(6, 2, 3, 4, 5, 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("문자열로 번호를 입력할 때 빈 칸이나 null 이 들어오는 경우 예외를 반환한다.")
    void test2(String args) throws Exception {
        var exception = catchThrowable(() -> Lotto.create(args));

        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열에 중복된 숫자가 입력된 경우 예외를 반환한다.")
    void test3() throws Exception {
        // Arrange
        var numbers = "1,2,2,4,5,6";
        // Act
        var exception = catchThrowable(() -> Lotto.create(numbers));
        // Assert
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 입력된 경우 예외를 반환한다.")
    void test444() throws Exception {
        // Arrange
        var numbers = List.of(1,2,2,4,5,6);
        // Act
        var exception = catchThrowable(() -> Lotto.create(numbers));
        // Assert
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 숫자 범위(1~45) 에서 벗어나는 경우 예외를 반환한다.")
    void test4() throws Exception {
        // Arrange
        List<Integer> maxNumber = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> minNumber = List.of(-1, 0, 1, 2, 3, 4);

        // Act
        var exceptionMax = catchThrowable(() -> Lotto.create(maxNumber));
        var exceptionMin = catchThrowable(() -> Lotto.create(minNumber));

        // Assert
        assertThat(exceptionMax).isInstanceOf(IllegalArgumentException.class);
        assertThat(exceptionMin).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력된 번호가 6개가 아니라면 예외를 반환한다.")
    void test5() throws Exception {
        // Arrange

        // Act

        // Assert

    }

    @Test
    @DisplayName("숫자 외의 문자가 입력된 경우 예외를 반환하다.")
    void test6() throws Exception {
        // Arrange

        // Act

        // Assert

    }
}
