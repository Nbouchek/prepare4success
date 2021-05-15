package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;

/**
 * Given an n sized unsorted array, find median and mode using counting sort technique.
 */
public class FindModeInArray {
    public static void main(String[] args) {
        int[] array = {2, 2, 2, 1, 1, 5, 5, 5, 5};
        System.out.println(new FindModeInArray().solution(array));
    }

    public int solution(int[] A) {
        if (A.length < 1) return -1;

        int maxValue = Arrays.stream(A).max().getAsInt();
        int[] frequency = new int[maxValue + 1];

        int modeIndex = A[0];
        for (int i = 0; i < A.length; i++) {
            frequency[A[i]]++;
            if (frequency[A[i]] > modeIndex) modeIndex = i;
        }

        for (int j : A) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int j : A) {
            System.out.print(frequency[j] + " ");
        }
        System.out.println();
        return A[modeIndex];
    }
}
