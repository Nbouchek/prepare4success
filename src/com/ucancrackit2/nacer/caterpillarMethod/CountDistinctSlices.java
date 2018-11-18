package com.ucancrackit2.nacer.caterpillarMethod;

/**
 * Count the number of distinct slices (containing only unique numbers).
 *
 * <p>
 * An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A are
 * less than or equal to M.
 * <p>
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements
 * A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual
 * number occurs more than once in the slice.
 * <p>
 * For example, consider integer M = 6 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 * <p>
 * The goal is to calculate the number of distinct slices.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int M, int[] A); }
 * <p>
 * that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
 * <p>
 * If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
 * <p>
 * For example, given integer M = 6 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 5
 * A[3] = 5
 * A[4] = 2
 * the function should return 9, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..M].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(M) (not counting the storage required for input arguments).
 */
public class CountDistinctSlices {
    public static void main(String[] args) {
        System.out.println(new CountDistinctSlices().solution(6, new int[]{3, 4, 5, 5, 2}));
    }

    public int solution(int M, int[] A) {

        // This solution is more clever, and much faster O(n)

        // main idea:
        // use "boolean[]" to record if an integer is already seen
        // also use "leftEnd" and "rightEnd"

        boolean[] seen = new boolean[M + 1]; // from 0 to M
        // Arrays.fill(seen, false); // note: "false" by default

        int leftEnd = 0;
        int rightEnd = 0;
        int numSlice = 0;

        // key point: move the "leftEnd" and "rightEnd" of a slice
        while (leftEnd < A.length && rightEnd < A.length) {

            // case 1: distinct (rightEnd)
            if (seen[A[rightEnd]] == false) {
                // note: not just +1
                // there could be (rightEnd - leftEnd + 1) combinations (be careful)
                numSlice = numSlice + (rightEnd - leftEnd + 1);
                if (numSlice >= 1_000_000_000)
                    return 1_000_000_000;

                // increase the slice to right by "1" (important)
                seen[A[rightEnd]] = true;
                rightEnd++;
            }
            // case 2: not distinct
            else {
                // decrease the slice from left by "1" (important)
                // remove A[leftEnd] from "seen" (be careful)
                seen[A[leftEnd]] = false;
                leftEnd++;
            }
        }

        return numSlice;
    }
}
