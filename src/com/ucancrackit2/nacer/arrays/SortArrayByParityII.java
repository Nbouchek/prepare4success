package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] A = {4, 1, 2, 1};
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(A)));
    }

    public int[] sortArrayByParityII(int[] A) {
        int[] odd = new int[A.length / 2];
        int[] even = new int[A.length / 2];

        int m = 0;
        int n = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] % 2 == 0)
                even[m++] = A[i];
            else
                odd[n++] = A[i];
        m = 0;
        n = 0;
        for (int i = 0; i < A.length; i++)
            A[i] = i % 2 == 0 ? even[m++] : odd[n++];

        return A;
    }
}
