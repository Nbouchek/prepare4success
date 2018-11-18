package com.ucandoit2.nacer.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class SmallestPositiveIntegerMissing {
    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int aA : A)
            if (aA > 0)
                map.put(aA, aA);
        if (map.isEmpty()) {
            return 1;
        }

        for (var i = 0; i < map.keySet().size(); i++) {
            if (!(map.containsKey(i + 1))) return i + 1;
        }

        return map.size() + 1;
    }

    public static void main(String[] args) {
        int [] array = {1, 3, 6, 4, 1, 2};
        System.out.println(new SmallestPositiveIntegerMissing().solution(array));

        array = new int[]{-1, -3};
        System.out.println(new SmallestPositiveIntegerMissing().solution(array));

        array = new int[]{1, 2, 3};
        System.out.println(new SmallestPositiveIntegerMissing().solution(array));
    }
}
