package com.ucancrackit2.nacer.ocadotaskthree;

public class Necklace {
    public static void main(String[] args) {
        System.out.println("Necklace:\n\t" + new Necklace().solution(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println("Necklace:\n\t" + new Necklace().solution(new int[]{2, 3, 4, 5, 8, 6, 1, 9, 10, 7, 0}));
    }

    public int solution(int[] A) {
        boolean[] visited = new boolean[A.length];
        int max = 1;
        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            max = calculateLength(1, i, A[i], A, visited, max);
        }
        return max;
    }

    private int calculateLength(int length, int index, int element, int[] A, boolean[] visited, int max) {
        if (index == element) {
            return Math.max(length, max);
        }
        visited[element] = true;
        return calculateLength(++length, index, A[element], A, visited, max);

    }
}
