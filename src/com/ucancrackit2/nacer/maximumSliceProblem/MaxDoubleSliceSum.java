package com.ucancrackit2.nacer.maximumSliceProblem;

/**
 * Find the maximal sum of any double slice.
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
 * <p>
 * The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... +
 * A[Z − 1].
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * contains the following example double slices:
 * <p>
 * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
 * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
 * double slice (3, 4, 5), sum is 0.
 * The goal is to find the maximal sum of any double slice.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 2
 * A[2] = 6
 * A[3] = -1
 * A[4] = 4
 * A[5] = 5
 * A[6] = -1
 * A[7] = 2
 * the function should return 17, because no double slice of array A has a sum of greater than 17.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        System.out.println("MaxDoubleSliceSum:\n\t" + new MaxDoubleSliceSum().solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    }

    public int solution(int[] A) {

        // (X, Y, Z)
        // 1st slice: A[X+1] + ... + A[Y-1]
        // 2nd slice: A[Y+1] + ... + A[Z-1]
        // Key Point:
        // The array will be split at "Y"

        // main idea:
        // if the middle point is "Y",
        // find "maxLeft" and "maxRight"

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];

        // 1) find "maxLeft"
        // maxLeft[i] is the maximum sum "contiguous subsequence" ending at index i
        // note: because it is "contiguous", we only need the ending index (important)
        for (int i = 1; i < A.length; i++) {   // be careful: from i=1 (because of maxLeft[i-1])
            maxLeft[i] = Math.max(0, maxLeft[i - 1] + A[i]); //golden slice algorithm: Math.max(0, maxLeft[i-1]+A[i] )
        }

        // 2) find "maxRight"
        // maxRight[i] is the maximum sum "contiguous subsequence" starting at index i
        // note: because it is "contiguous", we only need the starting index (important)
        for (int i = A.length - 2; i >= 0; i--) {   // be careful: from i=A.length-2 (because of maxLeft[i+1])
            maxRight[i] = Math.max(0, maxRight[i + 1] + A[i]); //golden slice algorithm: Math.max(0, maxRight[i+1]+A[i] )
        }

        // 3) find the maximum of "maxLeft + maxRight"
        int maxDoubleSlice = 0;
        for (int i = 1; i < A.length - 1; i++) { // where "i" means "Y" in this problem
            if (maxLeft[i - 1] + maxRight[i + 1] > maxDoubleSlice)   // be careful: left end at "i-1" and right begins at "i+1"
                maxDoubleSlice = maxLeft[i - 1] + maxRight[i + 1];  // be careful: "not" maxLeft[i] + maxRight[i]
        }

        return maxDoubleSlice;
    }
}
