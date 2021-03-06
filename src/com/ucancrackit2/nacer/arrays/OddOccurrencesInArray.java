package com.ucancrackit2.nacer.arrays;

/**
 * Find value that occurs in odd number of elements.
 * <p>
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each
 * element of the array can be paired with another element that has the same value, except for one element that is left
 * unpaired.
 * <p>
 * For example, in array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired
 * element.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * the function should return 7, as explained in the example above.
 * <p>
 * Assume that:
 * <p>
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] theArray = new int[]{9, 3, 9, 3, 9, 7, 9, 7, 12};
        System.out.println("OddOccurrencesInArray:\n\t" + new OddOccurrencesInArray().solution(theArray));
    }

    public int solution(int[] A) {
        // Using the concept of "XOR" (^)
        // when there is a pair A and B
        // A^B will be zero
        // A^B^C (where C is not paired),
        // then A^B^C = C

        // special case
        if (A.length == 0)
            return 0;

        int unpaired = A[0]; // initial

        for (int i = 1; i < A.length; i++) {
            unpaired = unpaired ^ A[i]; // xor
        }

        return unpaired; // return the unpaired value
    }
}
