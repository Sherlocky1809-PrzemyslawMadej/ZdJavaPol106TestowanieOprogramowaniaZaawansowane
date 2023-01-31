package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    private final String path = "pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider.FibonacciProvider#provideData";

    @ParameterizedTest
//    @MethodSource("caly_package.NazwaKlasy#nazwaMetody)
    @MethodSource(path)
    void shouldReturnCorrectValue(int input, int expectedResult) {
//  when
        int result = Fibonacci.getValueFromIndex(input);
//        then
        assertEquals(expectedResult, result);
        assertThat(result).isEqualTo(expectedResult);

    }

}