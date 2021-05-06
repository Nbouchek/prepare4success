package com.ucancrackit2.nacer.linkedLists;

public class LengthOfLinkedList {
    public int solution(int[] A) {
        int count = 0;
        int i = 0;
        return getCount(A, i, count);
    }

    private int getCount(int[] A, int i, int count) {
        if (A[i] == -1) return ++count;

        return getCount(A, A[i], ++count);
    }

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 4, 7, 5, -1, 6};
        System.out.println(new LengthOfLinkedList().solution(array));
    }
}
