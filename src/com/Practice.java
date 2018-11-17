package com;

import java.util.Arrays;

public class Practice {
    /**
     *
     * @param A input array
     * @param k rotation parameter
     * @param toTheRight whether to rotate right or left
     * @return rotated array
     */
    private int[] rotate(int[] A, int k, boolean toTheRight) {
        int length = A.length;
        int[] result = new int[length];
        int direction = toTheRight ? 1 : -1;

        for (int i = 0; i < length; i++) {
            result[i] = A[( i + direction * k)%length];
        }
        return result;
    }

    /**+
     *
     * @param A input array
     */
    private int oddOccurence(int[] A) {

        // sort
        // iterate in steps of 2
        // return when adjacent elements are not equal

        int unpaired = A[0];
        int length = A.length;
        for (int i = 1; i < length; i++) {
            unpaired ^= A[i];
        }
        return unpaired;
    }

    public static void main(String[] args) {

        int[] testrotate = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Practice().rotate(testrotate, 2, true)));

        int[] testOddOccurence = new int[]{9, 12, 9, 3, 3, 7, 9, 7, 12};
        System.out.println(Arrays.toString(testOddOccurence));
        System.out.println(new Practice().oddOccurence(testOddOccurence));
    }
}
