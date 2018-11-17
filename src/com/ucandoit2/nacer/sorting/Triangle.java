package com.ucandoit2.nacer.sorting;

import java.util.Arrays;

/**
 * Determine whether a triangle can be built from a given set of edges.
 * <p>
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and
 * returns 0 otherwise.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 * <p>
 * A[0] = 10    A[1] = 50    A[2] = 5
 * A[3] = 1
 * the function should return 0.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class Triangle {
    public static void main(String[] args) {
        System.out.println("Triangle:\n\t" + new Triangle().solution(new int[]{10, 2, 5, 1, 8, 20}));
    }

    public int solution(int[] A) {

        // main idea: for any combination (A[i-2], A[i-1], A[i])
        // we just need to check if A[i-2] + A[i-1] > A[i] (important)
        // note: A[i-2] + A[i-1] is the max possible combination (needed to check)

        // Using "Arrays.sort(int[])" => O(N*log(N))
        Arrays.sort(A);

        // note: start from i=2 O(N)
        for (int i = 2; i < A.length; i++) {
            if ((long) A[i - 2] + (long) A[i - 1] > (long) A[i]) // note: using "long" for overflow cases
                return 1;
            // note: we just need one combination
        }

        // otherwise, return 0 (no triangular)
        return 0;
    }
}
