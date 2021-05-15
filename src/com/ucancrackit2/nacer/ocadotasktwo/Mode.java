package com.ucancrackit2.nacer.ocadotasktwo;

import java.util.HashMap;

public class Mode {
    public static void main(String[] args) {
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{0, 0, 0, 1, 4, 5, 6, 0, 1}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{8, 8}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{10, 10, 9}));
        System.out.println("Mode:\n\t" + new Mode().solution(new int[]{9, 10, 9}));
    }

    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = -1;
        for (int aA : A) {
            if (hashMap.get(aA) != null) {
                int counter = 1 + hashMap.get(aA);
                hashMap.put(aA, counter);
                if (counter > result) {
                    result = aA;
                }
            } else {
                hashMap.put(aA, 1);
            }
        }
        return result > -1 ? result : A[0];
    }
}
