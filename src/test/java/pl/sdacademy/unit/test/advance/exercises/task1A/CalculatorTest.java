package pl.sdacademy.unit.test.advance.exercises.task1A;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1A.provider.CalculatorProvider#provideData")
    void shouldReturnSumOfDigits(int a, int b) {
        // given
        int expected = a + b;
        // when
        int result = Calculator.addDigits(a, b);
        // then
        assertEquals(expected, result);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1A.provider.CalculatorProvider#provideData")
    void shouldReturnDifferenceOfDigits(int a, int b) {
        // given
        int expected = a - b;
        // when
        int result = Calculator.differDigits(a, b);
        // then
        assertEquals(expected, result);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("pl.sdacademy.unit.test.advance.exercises.task1A.provider.CalculatorProvider#provideData")
    void shouldReturnMultiplyOfDigits(int a, int b) {
        // given
        int expected = a * b;
        // when
        int result = Calculator.multiplyDigits(a, b);
        // then
        assertEquals(expected, result);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideDataForDivide")
    void shouldReturnExceptionIfProvideIsZero(int a, int b) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Calculator.divideDigits(a,b));

        assertThatThrownBy(() -> Calculator.divideDigits(a, b)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can't divide by zero!");
    }

    private static Stream<Arguments> provideDataForDivide() {
        return Stream.of(
                Arguments.of(12, 0),
                Arguments.of(15, 0)

        );
    }

    @Test
    void shouldReturnExceptionIfBIsZero() {
        // given
        int a = 5;
        int b = 0;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> Calculator.divideDigits(a,b));

        assertThatThrownBy(() -> Calculator.divideDigits(a, b))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("You can't divide by zero!");
    }

}