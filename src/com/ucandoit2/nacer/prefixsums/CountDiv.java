package com.ucandoit2.nacer.prefixsums;

/**
 * Compute number of integers divisible by k in range [a..b].
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * <p>
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by
 * K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * <p>
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible
 * by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Assume that:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(1);
 * expected worst-case space complexity is O(1).
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println("CountDiv:\n\t" + new CountDiv().solution(6, 11, 2));
    }

    public int solution(int A, int B, int K) {
        // need to achieve low complexity O(1)
        // using math equation (low complexity)

        // number of divisible values smaller than B
        int numB = (int) Math.floor(B / K);
        // note: take "Math.floor" which is the basic number

        // number of divisible values smaller than A
        int numA = (int) Math.floor(A / K);
        // note: take "Math.floor" which is the basic number

        // number of divisible numbers
        int numDiv = numB - numA;

        // note: plus one (if A % K == 0)
        // because "A" is also divisble
        // without "plus", "A" will be deducted
        int plus = 0;
        if (A % K == 0)
            plus = 1;

        // numDiv + plus
        numDiv = numDiv + plus;

        // return the number of K-divisible values between A and B
        return numDiv;
    }
}
