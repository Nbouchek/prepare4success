package com.codility.nacer.prefixsums;

/**
 * Count the number of passing cars on the road.
 * <p>
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive
 * cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is
 * traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * the function should return 5, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class PassingCars {
    public static void main(String[] args) {
        System.out.println("PassingCars:\n\t" + new PassingCars().solution(new int[]{0, 1, 0, 1, 1}));
    }

    public int solution(int[] A) {
        // note: find number of pairs (P, Q)
        // where P < Q (important)
        // try to use "one pass" solution (low time complexity)

        int numEast = 0; // initial
        int numPass = 0; // initial

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) { // to east
                numEast++;
            }
            if (A[i] == 1) { // to west
                numPass = numPass + numEast;
            }
            // note: just look back "numEast"
            //       that will be the number of cars can be paired
            //       (with the current car)
        }

        // note 1: can use "_" for a big value
        // note 2: "numPass < 0" is for the "overflow" cases
        //         when "overflow" occurs, the value will "< 0" (important)
        if (numPass > 1_000_000_000 || numPass < 0)
            return -1;
        else
            return numPass;
    }
}
