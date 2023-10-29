package domain;

import org.example.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    public static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 23, 311, 487, 653, 947})
    public void testIsPrime(int number){
        assertTrue(calculator.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 12, 488, 512})
    public void testIsNotPrime(int number){
        assertFalse(calculator.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {32, 64, 2, 20, 30, 26})
    public void testIsEven(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 15, 29, 25})
    public void testIsNotEven(int number) {
        assertFalse(calculator.isEven(number));
    }

    @ParameterizedTest
    @CsvSource({"23,23", "46,23", "115,23", "184,23", "207,23", "230,23"})
    public void testIsMultipleOfTwentyThree(int number, int divisor) {
        assertTrue(calculator.isMultiple(number, divisor));
    }

    @ParameterizedTest
    @CsvSource({"26,23", "231,23", "2301,23", "462,23", "4645,23"})
    public void testIsNotMultipleOfTwentyThree(int number, int divisor) {
        assertFalse(calculator.isMultiple(number, divisor));
    }
}
