package de.robertz.fibonaccirest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class FibonacciControllerTest {

    private static final int ITERATION_AMOUNT = 1000000;
    @Autowired
    private FibonacciController fibonacciController;
    private Random rnd;

    @BeforeEach
    void resetRandom() {
        rnd = new Random(123456);
    }

    /**
     * Quick execution speed test for {@link de.robertz.fibonaccirest.controller.FibonacciController#handleFibonacci(int)}
     * Changing the USE_CACHE variable has to be done manually
     */
    @Test
    void executionSpeed() {
        long totalTime = 0;
        for (int i = 0; i < ITERATION_AMOUNT; i++) {
            int n = rnd.nextInt(70);
            long start = System.currentTimeMillis();
            fibonacciController.handleFibonacci(n);
            long dif = System.currentTimeMillis() - start;
            totalTime += dif;
        }
        System.out.println("Execution time: " + totalTime);
    }
}