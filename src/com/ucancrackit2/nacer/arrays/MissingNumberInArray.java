package com.ucancrackit2.nacer.arrays;

/**
 * Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing
 * number is to be found.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * For each test case first line contains N, size of array. The ssubsequent line contains N-1 array elements.
 * <p>
 * Output:
 * Print the missing number in array.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 5
 * 10
 * 1 2 3 4 5 6 7 8 10
 * <p>
 * Output:
 * 4
 * 9
 * <p>
 * Explanation:
 * Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 */
public class MissingNumberInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(" Missing number = " + new MissingNumberInArray().solution(array));
    }

    public int solution(int[] A) {
        int length = A.length;
        long sum = 0;
        for (int aA : A) {
            sum += aA;
        }
        return (int) ((length + 1) * (length + 2) / 2 - sum);
    }
}
