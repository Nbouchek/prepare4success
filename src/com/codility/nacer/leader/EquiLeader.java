package com.codility.nacer.leader;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1]
 * are the same.
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * The leader of this array is the value that occurs in more than half of the elements of A.
 * <p>
 * An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2],
 * ..., A[N − 1] have leaders of the same value.
 * <p>
 * For example, given array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * we can find two equi leaders:
 * <p>
 * 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 * 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 * The goal is to count the number of equi leaders.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 4
 * A[1] = 3
 * A[2] = 4
 * A[3] = 4
 * A[4] = 4
 * A[5] = 2
 * the function should return 2, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class EquiLeader {
    public static void main(String[] args) {
        System.out.println("EquiLeader:\n\t" + new EquiLeader().solution(new int[]{4, 3, 4, 4, 4, 2}));
    }

    public int solution(int[] A) {

        // special case
        if (A.length == 0)
            return 0;

        // The key point:
        // Only the "leader of the whole array" can have an "equi leader"
        // Assume a value Y is "not" the leader of the whole array.
        // Can value Y have an equi leader?
        // The answer is NO.

        // Based on this condition, to solve this problem,
        // 1. we first find the leader of the whole array.
        // 2. after finding a leader (if any),
        //    we then scan the whole array again.

        // 1. find the leader of an array
        // ---> we use "hashMap"
        Map<Integer, Integer> map = new HashMap<>();

        // map(key, value) ---> map(number, count)
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                map.put(A[i], map.get(A[i]) + 1);
            }
        }

        // find the maxValue and maxCount
        int maxValue = A[0];
        int maxCount = 1;
        // important: Using "for( int j: map.keySet() )"
        for (int j : map.keySet()) {
            int curCount = map.get(j);
            if (curCount > maxCount) {
                maxCount = curCount;
                maxValue = j;
            }
        }

        // check "if there is a leader"
        int leaderValue = 0;
        int leaderCount = 0;
        if (maxCount > (0.5) * (A.length)) {
            leaderValue = maxValue;
            leaderCount = maxCount;
        } else {
            return 0; // no leader ---> no equi leaders
        }

        // note: cannot use (1/2) * (A.length)
        // This is because (1/2) will be "zeor"
        // Instead, we can use (0.5) * (A.length) (be careful)

        // 2. scan the whole array again
        int numEquiLeaders = 0; // number of equi leaders
        int leftLeaderCount = 0; // number of leaders in left side

        // scan the array
        for (int i = 0; i < A.length; i++) {
            // find a leader (in left side)
            if (A[i] == leaderValue) {
                leftLeaderCount++;
            }

            // if the leader is "a leader in left side" (more than half)
            if (leftLeaderCount > (0.5) * (i + 1)) {
                // then, check right side
                int rightLeaderCount = leaderCount - leftLeaderCount;
                // if the leader is "a leader in right side" (more than half)
                if (rightLeaderCount > (0.5) * (A.length - i - 1)) {
                    numEquiLeaders++; // leader in both sides (then, equi leaders++)
                }
            }
        }
        // return number of equi leaders
        return numEquiLeaders;
    }
}
