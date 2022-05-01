package de.robertz.fibonaccirest.math;

public final class FunctionsCalculator {

    private FunctionsCalculator() {

    }

    //TODO add overflow detection and return -1 if overflow detected. Overflow happens if n > 71

    /**
     * calculates the nth fibonacci number with an iterative approach
     *
     * @param n the nth number to calculate
     * @return the nth fibonacci number or -1 if it could not be calculated
     */
    public static long calculateFibonacciIterative(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 3) {
            return 1;
        }

        // initialized with the first and second fibonacci number
        long firstPredecessor = 1;
        long secondPredecessor = 1;
        long successor = 0;

        // start at 2 since we already have the first two numbers
        for (int i = 2; i < n; i++) {
            successor = firstPredecessor + secondPredecessor;

            secondPredecessor = firstPredecessor;
            firstPredecessor = successor;
        }

        return successor;
    }

    /**
     * calculates the nth fibonacci number with the approach from Moivre Binet
     *
     * @param n the nth number to calculate
     * @return the nth fibonacci number or -1 if it could not be calculated
     * @see <a href="https://de.wikipedia.org/wiki/Fibonacci-Folge#Berechnung">Wikipedia-Fibonacci</a>
     */
    public static long calculateFibonacciMoivreBinet(int n) {

        if (n < 1) {
            return -1;
        }

        double sqrtOfFive = Math.sqrt(5);
        double factor = (1 / sqrtOfFive);
        double secTerm = Math.pow((1 + sqrtOfFive) / 2, n);
        double thirdTerm = Math.pow((1 - sqrtOfFive) / 2, n);
        return (long) (factor * (secTerm - thirdTerm));
    }
}
