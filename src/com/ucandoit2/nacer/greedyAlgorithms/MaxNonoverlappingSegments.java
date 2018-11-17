package com.ucandoit2.nacer.greedyAlgorithms;

/**
 * Find a maximal set of non-overlapping segments.
 *
 * <p>
 * Located on a line are N segments, numbered from 0 to N − 1, whose positions are given in arrays A and B.
 * For each I (0 ≤ I < N) the position of segment I is from A[I] to B[I] (inclusive). The segments are sorted by their
 * ends, which means that B[K] ≤ B[K + 1] for K such that 0 ≤ K < N − 1.
 * <p>
 * Two segments I and J, such that I ≠ J, are overlapping if they share at least one common point. In other words,
 * A[I] ≤ A[J] ≤ B[I] or A[J] ≤ A[I] ≤ B[J].
 * <p>
 * We say that the set of segments is non-overlapping if it contains no two overlapping segments. The goal is to find
 * the size of a non-overlapping set containing the maximal number of segments.
 * <p>
 * For example, consider arrays A, B such that:
 * <p>
 * A[0] = 1    B[0] = 5
 * A[1] = 3    B[1] = 6
 * A[2] = 7    B[2] = 8
 * A[3] = 9    B[3] = 9
 * A[4] = 9    B[4] = 10
 * The segments are shown in the figure below.
 * <p>
 * <p>
 * <p>
 * The size of a non-overlapping set containing a maximal number of segments is 3. For example, possible sets are
 * {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}. There is no non-overlapping set with four segments.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A, int[] B); }
 * <p>
 * that, given two arrays A and B consisting of N integers, returns the size of a non-overlapping set containing a
 * maximal number of segments.
 * <p>
 * For example, given arrays A, B shown above, the function should return 3, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..30,000];
 * each element of arrays A, B is an integer within the range [0..1,000,000,000];
 * A[I] ≤ B[I], for each I (0 ≤ I < N);
 * B[K] ≤ B[K + 1], for each K (0 ≤ K < N − 1).
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MaxNonoverlappingSegments {
    public static void main(String[] args) {
        System.out.println("MaxNonoverlappingSegments:\n\t" +
                new MaxNonoverlappingSegments().solution(new int[]{1, 3, 7, 9, 9}, new int[]{5, 6, 8, 9, 10}));
    }

    public int solution(int[] A, int[] B) {

        // main idea:
        // Using "greedy" method to find non-overlapping segments

        // because the segments are sorted by their rightEnds
        // we use "for loop" from rightEnd to left
        // and just need to keep the "value of leftEnd" (key point)

        // spcial case
        if (A.length == 0)
            return 0;

        int N = A.length;
        // keep the value of leftEnd: A[i]
        // the 1st segment: A[N-1]
        int currentLeftEnd = A[N - 1];
        int numNonOverlap = 1;

        for (int i = N - 2; i >= 0; i--) {
            // if "rightEnd < leftEnd", nonOverlap++
            // and update the value of leftEnd
            if (B[i] < currentLeftEnd) {
                numNonOverlap++;
                currentLeftEnd = A[i];
            }
            // if "leftnEnd is shorter",
            // update the value of leftEnd (important)
            if (A[i] > currentLeftEnd) {
                currentLeftEnd = A[i];
            }
        }

        return numNonOverlap;
    }
}
