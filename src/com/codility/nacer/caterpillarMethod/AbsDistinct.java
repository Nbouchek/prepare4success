package com.codility.nacer.caterpillarMethod;

import java.util.HashSet;
import java.util.Set;

/**
 * Compute number of distinct absolute values of sorted array elements.
 *
 * <p>
 * A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order. The absolute
 * distinct count of this array is the number of distinct absolute values among the elements of the array.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of
 * this array, namely 0, 1, 3, 5 and 6.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = -5
 * A[1] = -3
 * A[2] = -1
 * A[3] =  0
 * A[4] =  3
 * A[5] =  6
 * the function should return 5, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 * array A is sorted in non-decreasing order.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class AbsDistinct {
    public static void main(String[] args) {
        System.out.println("AbsDistinct:\n\t" +
                new AbsDistinct().solution(new int[]{-5, -3, -1, 0, 3, 6}));
    }

    public int solution(int[] A) {

        // using "Set"
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            // note: using "Math.abs(int)"
            if (set.contains(Math.abs(A[i])) == false) {
                set.add(Math.abs(A[i]));
            } else {
                // do nothing (already existed in the set)
            }
        }

        return set.size();
    }
}
