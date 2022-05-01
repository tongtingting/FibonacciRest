package de.robertz.fibonaccirest.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsCalculatorTest {

    private static final int MAX_FIB_NUMBER = 71;

    @Test
    void calculateFibonacci() {
        for (int i = 1; i < MAX_FIB_NUMBER; i++) {
            assertEquals(FunctionsCalculator.calculateFibonacciIterative(i), FunctionsCalculator.calculateFibonacciMoivreBinet(i), "Miscalculation with n: " + i);
        }
    }
}