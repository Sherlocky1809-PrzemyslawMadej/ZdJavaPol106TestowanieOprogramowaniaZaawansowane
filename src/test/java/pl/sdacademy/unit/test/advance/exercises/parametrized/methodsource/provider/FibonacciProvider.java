package pl.sdacademy.unit.test.advance.exercises.parametrized.methodsource.provider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class FibonacciProvider {

    public static Stream<Arguments> provideData() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(7, 13),
                Arguments.of(12, 144)
        );
    }

    //    public static Stream<Arguments> provideData1() {
//        return Stream.of(
//                Arguments.of(readFile("path/file1.xml"), readFile("path/resultFile1.xml")),
//                Arguments.of(readFile("path/file2.xml"), readFile("path/resultFile2.xml")),
//                Arguments.of(readFile("path/file3.xml"), readFile("path/resultFile3.xml"))
//        );
//    }
//
//    private static String readFile(String path) {
//
//        return null;
//    }
}
