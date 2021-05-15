package com.ucancrackit2.nacer.fibonacciNumbers;

import java.math.BigInteger;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * <p>
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
 */
public class FibonaccIIterative {
    public static void main(String[] args) {
//        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(new BigInteger("10000")) <= 0; i = i.add(BigInteger.ONE)) {
//            System.out.println(i + " : " + new FibonaccIIterative().fibonacci(i));
//        }

        String theNumber = "1000000000";
        theNumber = "50";
        BigInteger theFibonacci;
        BigInteger n = BigInteger.valueOf(5_000_000);
        for (BigInteger i = n; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            long startTime = System.nanoTime();
            theFibonacci = new FibonaccIIterative().fibonacci(i);
            long stopTime = System.nanoTime();
            System.out.println("FIBONACCI(" + i + ") = " + theFibonacci);
            System.out.println("LENGTH >>> " + theFibonacci.toString().length() + " (digits)");
            System.out.println("RUNNING TIME >>> " + (stopTime - startTime) + " (nanoseconds)");
        }
    }

    public long fibonacci(long n) {
        if (n == 0)
            return 0;

        long a = 0, b = 1, c;

        for (long i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public BigInteger fibonacci(BigInteger n) {
        if (n.compareTo(new BigInteger("0")) == 0)
            return n;

        BigInteger a = new BigInteger("0"), b = new BigInteger("1"), c;

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            c = a.add(b);
            a = b;
            b = c;
        }

        return b;
    }
}