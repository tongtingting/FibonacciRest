package de.robertz.fibonaccirest.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsCalculatorTest {

    private static final int MAX_FIB_NUMBER = 71;

    private static final int[] FIB_NUMBERS = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};

    @Test
    void testIterative() {
        for (int i = 0; i < FIB_NUMBERS.length; i++) {
            assertEquals(FunctionsCalculator.calculateFibonacciIterative(i + 1), FIB_NUMBERS[i]);
        }
    }

    @Test
    void testMoivreBinet() {
        for (int i = 0; i < FIB_NUMBERS.length; i++) {
            assertEquals(FunctionsCalculator.calculateFibonacciMoivreBinet(i + 1), FIB_NUMBERS[i]);
        }
    }

    @Test
    void calculateFibonacci() {
        for (int i = 1; i < MAX_FIB_NUMBER; i++) {
            assertEquals(FunctionsCalculator.calculateFibonacciIterative(i), FunctionsCalculator.calculateFibonacciMoivreBinet(i), "Miscalculation with n: " + i);
        }
    }
}