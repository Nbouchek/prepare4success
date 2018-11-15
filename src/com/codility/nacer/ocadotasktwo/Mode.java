package com.codility.nacer.ocadotasktwo;

import java.util.HashMap;

public class Mode {
    public static void main(String[] args) {
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{0, 0, 0, 1, 1, 1, 1, 1, 1}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{8, 8}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{10, 10, 9}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{9, 10, 9}));
    }

    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = -1;
        for (int i = 0; i < A.length; i++) {
            if (hashMap.get(A[i]) != null) {
                int counter = 1 + hashMap.get(A[i]);
                hashMap.put(A[i], counter);
                if (counter > result) {
                    result = A[i];
                }
            } else {
                hashMap.put(A[i], 1);
            }
        }
        return result > -1 ? result : A[0];
    }
}
