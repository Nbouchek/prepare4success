package com.ucancrackit2.nacer.countingelements;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the earliest time when a frog can jump to the other side of a river.
 * <p>
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river
 * (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the
 * river.
 * <p>
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position
 * where one leaf falls at time K, measured in seconds.
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only
 * when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when
 * all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is
 * negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the
 * river.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int X, int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can
 * jump to the other side of the river.
 * <p>
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * <p>
 * For example, given X = 5 and array A such that:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * the function should return 6, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(X) (not counting the storage required for input arguments).
 */
public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println("FrogRiverOne:\n\t" + new FrogRiverOne().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    public int solution(int X, int[] A) {
        // the main ideas:
        // 1. create a "set", and put "1~X" into the set first.
        // 2. when a number matches a number in the set,
        //    then remove the number from the set.
        // 3. when the set becomes "empty",
        //    all the numbers "1~X" have appeared

        Set<Integer> set = new HashSet<>();

        // put "1~X" into the set first
        for (int i = 1; i <= X; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) { // when a number appears,
                set.remove(A[i]);             // then, remove it from the set
            }
            if (set.isEmpty()) {        // nothing in the set
                return i;                     // In second i, "1~X" have all appeared
            }
        }

        // not all the elements "1~X" appeared
        return -1;
    }
}
