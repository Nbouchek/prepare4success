package com.codility.nacer.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the smallest positive integer that does not occur in a given sequence.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in
 * A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MissingInteger {
    public static void main(String[] args) {
        System.out.println("MissingInteger:\n\t" + new MissingInteger().solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    public int solution(int[] A) {
        //special case
        if (A.length == 0) {
            return 1;
        }

        // Using "set" to check if an element has appeared
        // note: need to "import java.util.*" (important)
        Set<Integer> set = new HashSet<Integer>();

        // add elements into the set
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        // note: the missing number is not possible bigger than (A.length)
        //       because there are only (A.length) numbers
        for (int i = 1; i <= A.length; i++) {
            if (set.contains(i) != true) // the 1st missing element
                return i;
        }

        // means: there are no missing numbers from 1 to A.length
        // Therefore, the missing number is "A.length+1" (important)
        return A.length + 1;
    }
}
