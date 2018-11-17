package com.ucandoit2.nacer.caterpillarMethod;

import java.util.Arrays;

/**
 * Count the number of triangles that can be built from a given set of edges.
 *
 * <p>
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if it is possible to build a
 * triangle with sides of lengths A[P], A[Q] and A[R]. In other words, triplet (P, Q, R) is triangular if
 * 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 12
 * There are four triangular triplets that can be constructed from elements of this array,
 * namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the number of triangular triplets in this array.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 12
 * the function should return 4, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..1,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N2);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class CountTriangles {
    public static void main(String[] args) {
        System.out.println("CountTriangles:\n\t" + new CountTriangles().solution(new int[]{10, 2, 5, 1, 8, 12}));
    }

    public int solution(int[] A) {

        int numTriangle = 0;

        // important: sort the edges
        // so that we just need to check if
        // "1st edge + 2nd edge > 3rd edge"
        Arrays.sort(A);

        // Using "Caterpillar method"
        // so we can have O(n^2), not O(n^3)
        for (int i = 0; i < A.length - 2; i++) {

            // the leftEnd and rightEnd of the "Caterpillar"
            int leftEnd = i + 1;
            int rightEnd = i + 2;

            while (leftEnd < A.length - 1) {

                // key point of "Caterpillar method"
                if (rightEnd < A.length && A[i] + A[leftEnd] > A[rightEnd]) {
                    rightEnd++; // increase the Caterpillar
                } else {
                    // note: need to minus "1"
                    // because the rightEnd is not included
                    numTriangle = numTriangle + (rightEnd - leftEnd - 1);
                    leftEnd++; // decrease the Caterpillar
                }
            }
        }

        return numTriangle;
    }
}
