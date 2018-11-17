package com.codility.nacer.arrays;

import java.util.Arrays;

/**
 * Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 1000
 * -100 ≤ A[i] <= 100
 *
 * Example:
 * Input
 * 2
 * 3
 * 1 2 3
 * 4
 * -1 -2 -3 -4
 * Output
 * 6
 * -1
 */
public class ContiguousSubArrayMaxSum {
    public int solution(int[] A) {
        int startIndex = 0;
        int endIndex = 0;
        int currentMax = A[0];
        int maxSoFar = A[0];

        for (int i = 1; i < A.length; i++) {
            currentMax = Math.max(A[i], currentMax + A[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);

            if (currentMax + A[i] > currentMax) endIndex = i;
            if (A[i] == maxSoFar)  startIndex = i;
        }
        System.out.println("start: " + startIndex);
        System.out.println("end: " + endIndex);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        System.out.println("Maximum contiguous sum is "
                + new ContiguousSubArrayMaxSum().solution(a) );
    }
}
