package com.codility.nacer.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Check whether array A is a permutation.
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation, because value 2 is missing.
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * the function should return 1.
 * <p>
 * Given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class PermCheck {
    public static void main(String[] args) {
        System.out.println("PermCheck:\n\t" + new PermCheck().solution(new int[]{4, 1, 3, 2}));
    }

    public int solution(int[] A) {

        // to check "permutation"
        // the main idea is as follows:
        // 1. use set to remember which elements have appeared
        // 2. use "for loop" to check if all the elements from "1 to A.length" appeared
        // If all the elements have appeared, then "yes".
        // Otherwise, "no".

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        // check if "all" the elements from "1 to A.length" appeared
        for (int i = 1; i <= A.length; i++) {
            if (set.contains(i) == false)
                return 0; // not a permutation (A[i] is missing)
        }

        // if it contains all the elements (from "1 to A.length")
        // then, "yes"
        return 1;
    }
}
