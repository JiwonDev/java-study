package com.sasung;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalTest {

    @Test
    @DisplayName("calculate - 정상적으로 덧셈을 계산한다.")
    void calculate() throws Exception {
        // 준비
        StringCal service = new StringCal();

        // 테스트
        int result = service.calculate("1+1");

        // 검증 -> 1+1을 실행한 결과는 2이다.
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("공백을 입력하면 0을 반환한다.")
    void emptyInput() throws Exception {
        // 준비
        StringCal service = new StringCal();

        // 테스트
        int result = service.calculate("     ");

        // 결과
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("올바르지 않은 연산식을 입력하면 0을 반환한다.")
    void failCalculate() throws Exception {
        // 준비
        StringCal service = new StringCal();

        // 테스트
        int result1 = service.calculate("1+++1");
        int result2 = service.calculate("1^1&2");

        assertThat(result1).isZero();
        assertThat(result2).isZero();
    }

    @Test
    @DisplayName("양수를 입력한 경우 0을 반환한다.")
    void numberOnly() throws Exception {
        // 준비
        StringCal service = new StringCal();
        String source1 = "12311";
        String source2 = "1";

        // 테스트
        int result1 = service.calculate(source1);
        int result2 = service.calculate(source2);

        assertSoftly(soft -> {
            soft.assertThat(result1).isZero();
            soft.assertThat(result2).isZero();
        });
    }

}
