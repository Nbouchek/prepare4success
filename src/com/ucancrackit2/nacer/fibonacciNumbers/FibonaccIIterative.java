package com.ucancrackit2.nacer.fibonacciNumbers;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * <p>
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 */
public class FibonaccIIterative {
    public static void main(String[] args) {
        System.out.println(new FibonaccIIterative().fibonacci(3));
    }

    public int fibonacci(int n) {
        if (n == 0)
            return 0;

        int a = 0, b = 1, c;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
