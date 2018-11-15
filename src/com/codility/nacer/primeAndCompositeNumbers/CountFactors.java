package com.codility.nacer.primeAndCompositeNumbers;

/**
 * Count factors of given number n.
 * <p>
 * A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.
 * <p>
 * For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the number of its factors.
 * <p>
 * For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24.
 * There are no other factors of 24.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(sqrt(N));
 * expected worst-case space complexity is O(1).
 */
public class CountFactors {
    public static void main(String[] args) {
        System.out.println("CountFactors:\n\t" + new CountFactors().solution(24));
    }

    public int solution(int N) {

        // main idea:
        // check from 1 to "sqrt_of_N"
        // then, taking its pair into consideration
        // ---> numFactor = numFactor * 2;

        int sqrtN = (int) Math.sqrt(N);
        int numFactor = 0; // number of factors

        // check if i is a factor or not (by using N % i ==0)
        for (int i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                numFactor++;
            }
        }

        numFactor = numFactor * 2; // add its pair

        // be careful: check if "sqrtN * sqrtN == N"
        if (sqrtN * sqrtN == N) {
            numFactor = numFactor - 1; // minus one: avoid double counting
        }

        return numFactor;
    }
}
