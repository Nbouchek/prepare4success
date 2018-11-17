package com.ucandoit2.nacer.prefixsums;

/**
 * Find the minimal average of any slice containing at least two elements.
 * <p>
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called
 * a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum
 * of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals
 * (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * contains the following example slices:
 * <p>
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the
 * minimal average. If there is more than one slice with a minimal average, you should return the smallest starting
 * position of such a slice.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 2
 * A[2] = 2
 * A[3] = 5
 * A[4] = 1
 * A[5] = 5
 * A[6] = 8
 * the function should return 1, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MinAvgTwoSlice {
    public static void main(String[] args) {
        System.out.println("MinAvgTwoSlice:\n\t" + new MinAvgTwoSlice().solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    public int solution(int[] A) {

        // main idea:
        // we know from the problem description
        // that the slices have a minimum length of 2.
        // The trick to this problem is that the min average slice has "the length of 2 or 3"
        // So, we only need to calculate the avg of the slices of length 2 and 3

        // note: return the start position (of the min average slice)

        // note: because we will use "/", we need to use "float" (not "int")
        float min = Integer.MAX_VALUE;
        int minStartPosition = 0;   // to store the start position

        // note: for "i< A.length -2"
        for (int i = 0; i < A.length - 2; i++) {

            // note: need to use "float"
            float avg2 = (float) (A[i] + A[i + 1]) / 2;         // avg of length of 2
            float avg3 = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;  // avg of length of 3

            // for debugging
            // System.out.println(i + " " + avg2 + " " + avg3);

            // take the smaller one
            float curMinAvg = Math.min(avg2, avg3);

            // keep the smallest one
            if (curMinAvg < min) {
                min = curMinAvg;
                minStartPosition = i;
            }
        }

        // note: for the last missing case
        // case: avg of length of 2 "A[A.length-2] + A[A.length-1]"
        int avg_2 = (A[A.length - 2] + A[A.length - 1]) / 2;
        if (avg_2 < min) {
            minStartPosition = A.length - 2;
        }

        return minStartPosition;
    }
}
