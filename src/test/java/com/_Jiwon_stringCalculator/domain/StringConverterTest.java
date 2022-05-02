package com._Jiwon_stringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringConverterTest {

    private final StringConverter service = new StringConverter();

    @Test
    @DisplayName("연산식이 적힌 문자열을 토큰으로 변환한다.")
    void successConversion() throws Exception {
        var result1 = service.convert("1+2+3+4");
        var result2 = service.convert("1+2");

        assertSoftly(soft -> {
            soft.assertThat(result1).contains(1D, 2D, 3D, 4D);
            soft.assertThat(result2).contains(1D, 2D);
        });
    }

    @Test
    @DisplayName("토큰으로 변환할 수 없는 경우 빈 리스트를 반환한다.")
    void failConversion() throws Exception {
        var result1 = service.convert("+++++");
        var result2 = service.convert("1+++13+3+4");
        var result3 = service.convert("1     1  1");

        assertSoftly(soft -> {
            soft.assertThat(result1).isEmpty();
            soft.assertThat(result2).isEmpty();
            soft.assertThat(result3).isEmpty();
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열이나 null 을 입력하면 예외를 반환한다.")
    void emptyOrNull(String nullAndEmpty) throws Exception {
        var exception = catchException(
            () -> service.convert(nullAndEmpty)
        );

        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }
}
