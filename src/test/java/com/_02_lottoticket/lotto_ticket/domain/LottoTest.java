package com._02_lottoticket.lotto_ticket.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import com._02_lottoticket.lotto_ticket.domain.exception.DuplicatedLottoNumberException;
import com._02_lottoticket.lotto_ticket.domain.exception.InvalidLottoNumberException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoTest {

    @Test
    @DisplayName("보너스 볼은 당첨번호와 중복되면 예외를 반환한다..")
    void input_bonus_test1() throws Exception {
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        var bonus = 6;

        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.create(numbers);
            lotto.setBonus(bonus);
        }).isInstanceOf(DuplicatedLottoNumberException.class);
    }

    @Test
    @DisplayName("보너스 볼을 성공적으로 입력받는다.")
    void input_bonus_test() throws Exception {
        var numbers = List.of(1, 2, 3, 4, 5, 6);
        var bonus = 7;
        Lotto lotto = Lotto.create(numbers);

        var exception = catchThrowable(() -> lotto.setBonus(bonus));

        assertThat(exception).isNull();
    }

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
    @DisplayName("중복된 숫자가 입력된 경우 예외를 반환한다.")
    void test444() throws Exception {
        // Arrange
        var numbers = List.of(1, 2, 2, 4, 5, 6);
        // Act
        var exception = catchThrowable(() -> Lotto.create(numbers));
        // Assert
        assertThat(exception).isInstanceOf(DuplicatedLottoNumberException.class);
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
        assertThat(exceptionMax).isInstanceOf(InvalidLottoNumberException.class);
        assertThat(exceptionMin).isInstanceOf(InvalidLottoNumberException.class);
    }

    @Test
    @DisplayName("입력된 번호가 6개가 아니라면 예외를 반환한다.")
    void test5() throws Exception {
        var exception1 = catchThrowable(() -> Lotto.create(List.of(1)));
        var exception2 = catchThrowable(() -> Lotto.create(List.of(1, 2, 3, 4, 5, 6, 7, 8)));

        assertThat(exception1).isInstanceOf(InvalidLottoNumberException.class);
        assertThat(exception2).isInstanceOf(InvalidLottoNumberException.class);
    }

    @Nested
    @DisplayName("문자열 입력 테스트")
    class StringInputTest {

        @Test
        @DisplayName("로또번호 6개를 입력받고, Lotto 객체를 성공적으로 생성한다.")
        void test() throws Exception {
            var exception = catchThrowable(() -> Lotto.create("45,42,41,38,10,20", 11));
            assertThat(exception).isNull();
        }

        @Test
        @DisplayName("로또번호 6개를 따음표로 구분해서 입력받을 수 있어야한다.")
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
        @DisplayName("번호를 입력할 때 빈 칸이나 null 이 들어오는 경우 예외를 반환한다.")
        void test2(String args) throws Exception {
            var exception = catchThrowable(() -> Lotto.create(args));

            assertThat(exception).isInstanceOf(InvalidLottoNumberException.class);
        }

        @Test
        @DisplayName("입력시 숫자 외의 문자가 입력된 경우 예외를 반환하다.")
        void test6() throws Exception {
            var numbers = "a,b,2,4,5,6";

            var exception = catchThrowable(() -> Lotto.create(numbers));

            assertThat(exception).isInstanceOf(InvalidLottoNumberException.class);
        }

        @Test
        @DisplayName("중복된 숫자가 입력된 경우 예외를 반환한다.")
        void test3() throws Exception {
            // Arrange
            var numbers = "1,2,2,4,5,6";
            // Act
            var exception = catchThrowable(() -> Lotto.create(numbers));
            // Assert
            assertThat(exception).isInstanceOf(DuplicatedLottoNumberException.class);
        }
    }
}
