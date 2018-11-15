package com.codility.nacer.dynamicProgramming;

/**
 * Given array of integers, find the lowest absolute sum of elements.
 *
 * <p>
 * For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
 * <p>
 * val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
 * <p>
 * (Assume that the sum of zero elements equals zero.)
 * <p>
 * For a given array A, we are looking for such a sequence S that minimizes val(A,S).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S)
 * for all possible sequences S of N integers from the set {−1, 1}.
 * <p>
 * For example, given array:
 * <p>
 * A[0] =  1
 * A[1] =  5
 * A[2] =  2
 * A[3] = -2
 * your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..20,000];
 * each element of array A is an integer within the range [−100..100].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*max(abs(A))2);
 * expected worst-case space complexity is O(N+sum(abs(A))) (not counting the storage required for input arguments).
 */
public class MinAbsSum {
    public static void main(String[] args) {
        System.out.println("MinAbsSum:\n\t" + new MinAbsSum().solution(new int[]{1, 5, 2, -2}));
    }

    public int solution(int[] A) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            max = Math.max(max, A[i]);
            sum += A[i];
        }

        int[] counts = new int[max + 1];
        for (int number : A) {
            counts[number]++;
        }

        boolean[] reaches = new boolean[sum / 2 + 1];
        reaches[0] = true;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            int[] remains = new int[reaches.length];
            for (int j = 0; j < remains.length; j++) {
                remains[j] = reaches[j] ? counts[i] : -1;
            }
            for (int j = 0; j + i < remains.length; j++) {
                if (remains[j] > 0) {
                    remains[j + i] = Math.max(remains[j + i], remains[j] - 1);
                }
            }
            for (int j = 0; j < remains.length; j++) {
                if (remains[j] >= 0) {
                    reaches[j] = true;
                }
            }
        }

        for (int i = reaches.length - 1; ; i--) {
            if (reaches[i]) {
                return sum - i - i;
            }
        }
    }

}
