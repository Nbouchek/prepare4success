package com.ucandoit2.nacer.sieveOfEratosthenes;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Calculate the number of elements of an array that are not divisors of each element.
 * <p>
 * You are given an array A consisting of N integers.
 * <p>
 * For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the
 * divisors of A[i]. We say that these elements are non-divisors.
 * <p>
 * For example, consider integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * For the following elements:
 * <p>
 * A[0] = 3, the non-divisors are: 2, 6,
 * A[1] = 1, the non-divisors are: 3, 2, 3, 6,
 * A[2] = 2, the non-divisors are: 3, 3, 6,
 * A[3] = 3, the non-divisors are: 2, 6,
 * A[4] = 6, there aren't any non-divisors.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns a sequence of integers representing the amount of
 * non-divisors.
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
 * A[1] = 1
 * A[2] = 2
 * A[3] = 3
 * A[4] = 6
 * the function should return [2, 4, 3, 2, 0], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..50,000];
 * each element of array A is an integer within the range [1..2 * N].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        System.out.println("CountNonDivisibl\n\t" + Arrays.toString(new CountNonDivisible().solution(new int[]{3, 1, 2, 3, 6})));
    }

    public int[] solution(int[] A) {

        // main idea:
        // using "HashMap" to count

        // map1(key, value)
        HashMap<Integer, Integer> map1 = new HashMap<>();
        // key: the elements, value, count of elements
        for (int i = 0; i < A.length; i++) {
            if (map1.containsKey(A[i]) == false) {
                map1.put(A[i], 1); // add new element
            } else {
                map1.put(A[i], map1.get(A[i]) + 1); // count++
            }
        }

        // map2(key, value)
        HashMap<Integer, Integer> map2 = new HashMap<>();
        // key: the elements, value, count of "number of non-divisors" of elements
        for (int n : map1.keySet()) {
            int numDivisors = 0;
            // find divisors from 1 to sqrt(n)
            int sqrtN = (int) Math.sqrt(n);
            for (int i = 1; i <= sqrtN; i++) {
                if (n % i == 0) { // means: i could be a divisor
                    int anotherDivisor = n / i;

                    if (map1.containsKey(i) == true) {
                        numDivisors = numDivisors + map1.get(i);
                    }
                    if (anotherDivisor != i) { // avoid double count (be careful)
                        if (map1.containsKey(anotherDivisor) == true) {
                            numDivisors = numDivisors + map1.get(anotherDivisor);
                        }
                    }
                }
            }

            int numNonDivisors = A.length - numDivisors;
            map2.put(n, numNonDivisors);
        }

        // results: number of non-divisors
        int[] results = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            results[i] = map2.get(A[i]);
        }

        return results;
    }
}
