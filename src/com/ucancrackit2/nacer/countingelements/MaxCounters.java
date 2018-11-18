package com.ucancrackit2.nacer.countingelements;

import java.util.Arrays;

/**
 * Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all
 * counters to current maximum.
 * <p>
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers
 * representing the values of the counters.
 * <p>
 * The sequence should be returned as:
 * <p>
 * a structure Results (in C), or
 * a vector of integers (in C++), or
 * a record Results (in Pascal), or
 * an array of integers (in any other programming language).
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N+M);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class MaxCounters {
    public static void main(String[] args) {
        System.out.println("MaxCounters:\n\t" + Arrays.toString(new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public int[] solution(int N, int[] A) {
        // 1. key point: maintain the max value
        int max = 0;

        // 2. key point: maintain the current_min (very important!!!)
        // so, we can move "the 2nd for-loop" outside "the 1st for-loop"
        // by maintaining "min"
        int min = 0;

        // new integer array
        int[] myArray = new int[N];

        /* no need to initialize (because the values are "0" by default)
        for(int i=0; i<myArray.length; i++){
            myArray[i] =0;
        }
        */

        for (int aA : A) {
            if (aA >= 1 && aA <= N) { // normal case

                // important: check the "min" before "increasing by 1"
                if (myArray[aA - 1] < min) {
                    myArray[aA - 1] = min; // update it to "min"
                }

                myArray[aA - 1]++;  // increased by 1

                if (myArray[aA - 1] > max) { // maintain max
                    max = myArray[aA - 1];
                }
            } else if (aA == N + 1) {      // special case
                /* cannot use for-loop (will take too much time)
                for(int j=0; j<myArray.length; j++){
                    myArray[j] = max;
                }
                // instead, we maintain "min", so we can move the for-loop outside */
                min = max; // all the values should be bigger than "max"
                // therefore, "min = max"
            }
        }

        // move the 2nd for-loop outside the 1st for-loop
        // update some elements who have not been updated yet
        for (int j = 0; j < myArray.length; j++) {
            if (myArray[j] < min) {
                myArray[j] = min; // update it to "min"
            }
        }

        return myArray;
    }
}
