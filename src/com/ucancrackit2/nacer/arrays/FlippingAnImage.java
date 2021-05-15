package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;

/**
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0]
 * horizontally results in [0, 1, 1].
 * <p>
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1]
 * results in [1, 0, 0].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * <p>
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class FlippingAnImage {
    public static void main(String[] args) {
        int[][] array = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};

        System.out.println("*** THE ARRAY ****");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("*** FLIPPED-INVERTED ****");
        array = (new FlippingAnImage().solution(array));
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] solution(int[][] A) {
        int width = A[0].length;
        for (int[] row : A)
            for (int i = 0; i < (width + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[width - 1 - i] ^ 1;
                row[width - 1 - i] = tmp;
            }
        return A;
    }
}
