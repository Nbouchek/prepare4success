package com.codility.nacer.ocadotaskone;

import java.util.Arrays;

class Median {
    public static void main(String[] args) {
        System.out.println("Median:\n\t" + new Median().solution(new int[]{1, 2, 5, 10, 20, 1}));
    }

    public int solution(int[] A) {
        System.out.println(Arrays.toString(A));
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        if (A.length % 2 == 0) {
            return A[A.length / 2];
        }
        return A[(A.length - 1) / 2];
    }
}
