package com.ucancrackit2.nacer.arrays;

/**
 * Given an n sized unsorted array, find median and mode using counting sort technique.
 */
public class FindModeInArray {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 1, 1, 5, 5, 5, 5};
        System.out.println(new FindModeInArray().solution(array));
    }

    public int solution(int[] A) {
        if (A.length < 1 || A == null) return -1;

        int maxValue = A[A.length - 1];
        for (int i = 1; i < A.length; i++)
            if (A[i] > maxValue) maxValue = A[i];
        int[] frequency = new int[maxValue + 1];

        int modeIndex = A[0];
        for (int i = 0; i < A.length; i++) {
            frequency[A[i]]++;
            if (frequency[A[i]] > modeIndex) modeIndex = i;
        }

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < A.length; i++) {
            System.out.print(frequency[A[i]] + " ");
        }
        System.out.println();
        return A[modeIndex];
    }
}
