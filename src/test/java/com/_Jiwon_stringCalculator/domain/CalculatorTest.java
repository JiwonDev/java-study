package com._Jiwon_stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator service = new Calculator();

    @Test
    @DisplayName("정상적인 리스트를 입력받고 덧셈 계산 결과를 반환한다.")
    void calculatePlus() throws Exception {
        var result1 = service.calculate(List.of(1D, 2D, 3D));
        var result2 = service.calculate(List.of(1.1, 2.2, 3.3, 4.4));
        var result3 = service.calculate(List.of(-1.1, -2.2, 0D, 0D, 0D));

        assertSoftly(soft -> {
            soft.assertThat(result1).isEqualTo(1D + 2D + 3D);
            soft.assertThat(result2).isEqualTo(1.1 + 2.2 + 3.3 + 4.4);
            soft.assertThat(result3).isEqualTo((-1.1) + (-2.2));
        });
    }

    @Test
    @DisplayName("빈 리스트를 입력하면 0을 반환한다.")
    void inputEmptyList() throws Exception {
        var result = service.calculate(new ArrayList<>());

        assertThat(result).isZero();
    }

    @Test
    @DisplayName("0만 있는 리스트를 입력하면 0을 반환한다.")
    void inputListOfZero() throws Exception {
        var result1 = service.calculate(List.of(0D));
        var result2 = service.calculate(List.of(0D, 0D));
        var result3 = service.calculate(List.of(0D, 0D, 0D, 0D));

        assertSoftly(soft -> {
            soft.assertThat(result1).isZero();
            soft.assertThat(result2).isZero();
            soft.assertThat(result3).isZero();
        });
    }

}
