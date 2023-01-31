package pl.sdacademy.unit.test.advance.exercises.task1A;

public class Calculator {

    public static int addDigits(int a, int b) {
        return a + b;
    }

    public static int differDigits(int a, int b) {
        return a - b;
    }

    public static int multiplyDigits(int a, int b) {
        return a * b;
    }

    public static int divideDigits(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        }
        return a / b;
    }
}
