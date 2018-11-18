package com.ucancrackit2.nacer.sorting;

import java.util.Arrays;

/**
 * Compute the number of intersections in a sequence of discs.
 * <p>
 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers,
 * specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
 * <p>
 * We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common
 * point (assuming that the discs contain their borders).
 * <p>
 * The figure below shows discs drawn for N = 6 and A as follows:
 * <p>
 * A[0] = 1
 * A[1] = 5
 * A[2] = 2
 * A[3] = 1
 * A[4] = 4
 * A[5] = 0
 * <p>
 * <p>
 * There are eleven (unordered) pairs of discs that intersect, namely:
 * <p>
 * discs 1 and 4 intersect, and both intersect with all the other discs;
 * disc 2 also intersects with discs 0 and 3.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of
 * intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
 * <p>
 * Given array A shown above, the function should return 11, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [0..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        System.out.println("NumberOfDiscIntersections:\n\t" + new NumberOfDiscIntersections().solution(new int[]{1, 5, 2, 1, 4, 0}));
    }

    public int solution(int[] A) {

        // main idea:
        // 1. store all the "lowerPoints points" and "upperPoints points" of the discs
        // 2. count the intersections (if one upperPoints point > one lowerPoints point)

        // note: use "long" for big numbers (be careful)
        long[] lowerPoints = new long[A.length];
        long[] upperPoints = new long[A.length];

        for (int i = 0; i < A.length; i++) {
            lowerPoints[i] = i - (long) A[i]; // note: lowerPoints = center - A[i]
            upperPoints[i] = i + (long) A[i]; // note: upperPoints = center + A[i]
        }

        // "sort" the "lowerPoints points" and "upperPoints points"
        Arrays.sort(upperPoints);
        Arrays.sort(lowerPoints);

        int intersection = 0; // number of intersections
        int j = 0; // for the lowerPoints points

        // scan the upperPoints points
        for (int i = 0; i < A.length; i++) {

            // for the current "j" (lowerPoints point)
            while (j < A.length && upperPoints[i] >= lowerPoints[j]) {
                intersection = intersection + j; // add j intersections
                intersection = intersection - i; // minus "i" (avoid double count)
                j++;
            }
        }

        // for the overflow cases
        if (intersection > 10_000_000)
            return -1;

        return intersection; // number of intersections
    }
}
