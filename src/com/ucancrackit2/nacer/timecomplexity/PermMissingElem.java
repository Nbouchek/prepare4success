package com.ucancrackit2.nacer.timecomplexity;

/**
 * Find the missing element in a given permutation.
 * <p>
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which
 * means that exactly one element is missing.
 * <p>
 * Your goal is to find that missing element.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A, returns the value of the missing element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println("PermMissingElem:\n\t" + new PermMissingElem().solution(new int[]{2, 3, 1, 5}));
    }

    public int solution(int[] A) {
        // Using the concept of "Sum = (ceiling + floor) * height /2"
        // So---> Sum = (1 + N+1) * N /2
        // the missing element can be found by minus other elements

        // note: need to use "long" to avoid potential bugs (large numbers)
        long ceiling = A.length + 1;
        long floor = 1;
        long height = A.length + 1; // note: need to plus extra "1"
        // because there is one element "missing"!
        // be careful about this (important)
        //
        //int high = A.length +1;
        //int low = 1;
        //int height = A.length + 1;
        //int sum = (high +low) * height /2; // main idea
        //
        long missingNumber = (ceiling + floor) * height / 2; // initial setting (sum)

        for (int aA : A) missingNumber = missingNumber - aA; // minus other elements

        return (int) missingNumber; // return the missing element (long->int)
    }
}
