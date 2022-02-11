package com.jiwon.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

@Disabled("확인, 학습용 테스트")
@DisplayName("함수형 인터페이스 학습 테스트")
final class FunctionalStudyTest {

    @TestFactory
    @DisplayName("reduce 동작 확인용 테스트")
    Collection<DynamicTest> empty_reduce_test() throws Exception {
        // Arrange
        long[] emptyList = {};
        long[] oneList = {100L};
        long[] twoList = {100L, 200L};

        // Act & Assert
        return Arrays.asList(
            dynamicTest("배열이 비었다면 .orElse(값) 을 반환한다.", () -> {
                var result = Arrays.stream(emptyList).reduce(Long::sum).orElse(0L);
                assertThat(result).isEqualTo(0L);
            }),
            dynamicTest("배열의 값이 1개라면 해당 값을 그대로 반환한다.", () -> {
                var result = Arrays.stream(oneList).reduce(Long::sum).orElse(0L);
                assertThat(result).isEqualTo(100L);
            }),
            dynamicTest("배열의 값이 2개 이상이라면 reduce(연산)을 진행한다.", () -> {
                var result = Arrays.stream(twoList).reduce(Long::sum).orElse(0L);
                assertThat(result).isEqualTo(100L + 200L);
            })
        );

    }

}
