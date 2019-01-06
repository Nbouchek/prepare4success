package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] B = new TransposeMatrix().transpose(A);
        for (int[] el : B) {
            System.out.println("" + Arrays.toString(el));
        }

    }

    private int[][] transpose(int[][] A) {
        int[][] B = new int[A[0].length][A.length];

        for (int i = 0; i < A[0].length; i++)
            for (int j = 0; j < A.length; j++)
                B[i][j] = A[j][i];

        return B;
    }
}
