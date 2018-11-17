package com.ucandoit2.nacer.arrays;

import java.util.HashMap;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 10^7
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */
public class SubarrayWithGivenSum {

    public int solution (int[] A, int sum) {
        long cummulativeSum = 0;
        int startIndex = 0;
        int endIndex = -1;
        int length = A.length;
        HashMap<Long, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            cummulativeSum += A[i];

            if (cummulativeSum == sum) {
                endIndex = i;
                break;
            }

            if (hashMap.containsKey(cummulativeSum - sum)) {
                startIndex = hashMap.get(cummulativeSum - sum ) + 1;
                endIndex = i;
                break;
            }

            hashMap.put(cummulativeSum, i);
        }

        if (endIndex == -1) {
            System.out.println("subArray not found with sum = " + sum + " not found");
        }
        else {
            System.out.println("subArray with sum = " + sum + " is between " + startIndex + " and " + endIndex);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, -2, -20, 10};
        int sum = -10;

        int example = new SubarrayWithGivenSum().solution(A, -10);
    }
}
