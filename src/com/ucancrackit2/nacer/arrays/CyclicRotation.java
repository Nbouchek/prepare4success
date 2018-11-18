package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;

/**
 * Rotate an array to the right by a given number of steps.
 * <p>
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one
 * index, and the last element of the array is moved to the first place. For example, the rotation of array
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class CyclicRotation {

    public static void main(String[] args) {
        System.out.println("CyclicRotation:\n\t" + Arrays.toString(new CyclicRotation().solution(new int[]{1, 2, 4, 5}, 2)));
    }

    public int[] solution(int[] A, int K) {
        // Using the concept of "mod" (to make it cyclic)
        int[] newArray = new int[A.length]; // a new array

        for (int i = 0; i < A.length; i++) {
            int newPosition = (i + K) % A.length; // using "mod" to do Cyclic Rotation
            newArray[newPosition] = A[i]; // put A[i] to the new position
        }

        return newArray; // return new array
    }
}