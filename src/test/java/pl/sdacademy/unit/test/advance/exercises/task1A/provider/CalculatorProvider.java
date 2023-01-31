package pl.sdacademy.unit.test.advance.exercises.task1A.provider;

import org.junit.jupiter.params.provider.Arguments;
import pl.sdacademy.unit.test.advance.exercises.task1A.Calculator;

import java.util.stream.Stream;

public class CalculatorProvider {

    public static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(2,5),
                Arguments.of(10,5),
                Arguments.of(0,5)
        );
    }

}

