package com.ucancrackit2.nacer.caterpillarMethod;

import java.util.Arrays;

/**
 * Find the minimal absolute value of a sum of two elements.
 *
 * <p>
 * Let A be a non-empty array consisting of N integers.
 * <p>
 * The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
 * The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
 * The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
 * The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
 * The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
 * The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
 * The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices
 * in this array.
 * <p>
 * For example, given the following array A:
 * <p>
 * A[0] =  1
 * A[1] =  4
 * A[2] = -3
 * the function should return 1, as explained above.
 * <p>
 * Given array A:
 * <p>
 * A[0] = -8
 * A[1] =  4
 * A[2] =  5
 * A[3] =-10
 * A[4] =  3
 * the function should return |(−8) + 5| = 3.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MinAbsSumOfTwo {
    public static void main(String[] args) {
        System.out.println("MinAbsSumOfTwo:\n\t" + new MinAbsSumOfTwo().solution(new int[]{1, 4, -3}));
    }

    public int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int tail = 0;
        int head = N - 1;
        int minAbsSum = Math.abs(A[tail] + A[head]);
        while (tail <= head) {
            int currentSum = A[tail] + A[head];
            minAbsSum = Math.min(minAbsSum, Math.abs(currentSum));
            // If the sum has become
            // positive, we should know that the head can be moved left
            if (currentSum <= 0)
                tail++;
            else
                head--;
        }
        return minAbsSum;
    }
}
