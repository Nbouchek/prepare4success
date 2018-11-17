package com.ucandoit2.nacer.sieveOfEratosthenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Count the semiprime numbers in the given range [a..b]
 * <p>
 * A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.
 * <p>
 * A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.
 * <p>
 * You are given two non-empty arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.
 * <p>
 * Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.
 * <p>
 * For example, consider an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * The number of semiprimes within each of these ranges is as follows:
 * <p>
 * (1, 26) is 10,
 * (4, 10) is 4,
 * (16, 20) is 0.
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] P, int[] Q); }
 * <p>
 * that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.
 * <p>
 * For example, given an integer N = 26 and arrays P, Q such that:
 * <p>
 * P[0] = 1    Q[0] = 26
 * P[1] = 4    Q[1] = 10
 * P[2] = 16   Q[2] = 20
 * the function should return the values [10, 4, 0], as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..50,000];
 * M is an integer within the range [1..30,000];
 * each element of arrays P, Q is an integer within the range [1..N];
 * P[i] ≤ Q[i].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(log(N))+M);
 * expected worst-case space complexity is O(N+M) (not counting the storage required for input arguments).
 */
public class CountSemiprimes {
    public static void main(String[] args) {
        System.out.println("CountSemiprimes:\n\t" + Arrays.toString(new CountSemiprimes().solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20})));
    }

    public int[] solution(int N, int[] P, int[] Q) {

        // main idea:
        // using "sieve of Eratosthenes"
        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

        boolean[] primeArray = new boolean[N + 1]; // note: plus one for "0"

        // initial settting (sieve of Eratosthenes)
        Arrays.fill(primeArray, true); // initial setting: all primes
        primeArray[0] = false;         // not prime
        primeArray[1] = false;         // not prime
        int sqrtN = (int) Math.sqrt(N);
        // sieve of Eratosthenes
        for (int i = 1; i < sqrtN; i++) {
            if (primeArray[i] == true) // prime
            {
                int j = i + i;
                for (j = j; j <= N; j = j + i) {
                    primeArray[j] = false; // not prime
                }
            }
        }

        // store all primes in "List"
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (primeArray[i] == true) {
                primeList.add(i);    // "i" is prime
            }
        }

        // find "semiprimes"
        boolean[] semiprimeArray = new boolean[N + 1]; // note: plus one for "0"
        Arrays.fill(semiprimeArray, false); // initial setting: all "not" semiprimes
        long semiprimeTemp; // using "long" (be careful)
        // for "primeList.size()"
        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i; j < primeList.size(); j++) {
                semiprimeTemp = (long) primeList.get(i) * (long) primeList.get(j); // semiprimes
                if (semiprimeTemp > N) {
                    break;
                } else {
                    semiprimeArray[(int) semiprimeTemp] = true; // semiprimes
                }
            }
        }

        // compute "cumulative Count of semiprimes"
        int[] semiprimeCumulateCount = new int[N + 1]; // note: plus one for "0"
        for (int i = 1; i <= N; i++) {
            semiprimeCumulateCount[i] = semiprimeCumulateCount[i - 1]; // cumulative
            if (semiprimeArray[i] == true) {
                semiprimeCumulateCount[i]++; // semiprimes
            }
        }

        // compute "results" (for each query)
        int numQuery = Q.length;
        int[] result = new int[numQuery];
        for (int i = 0; i < numQuery; i++) {
            result[i] = semiprimeCumulateCount[Q[i]] - semiprimeCumulateCount[P[i] - 1]; // note: "P[i]-1" (not included)
        }
        return result;
    }
}
