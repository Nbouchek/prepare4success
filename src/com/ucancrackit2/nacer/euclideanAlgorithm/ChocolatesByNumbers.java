package com.ucancrackit2.nacer.euclideanAlgorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 * <p>
 * There are N chocolates in a circle. Count the number of chocolates you will eat.
 * <p>
 * Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle,
 * numbered from 0 to N − 1.
 * <p>
 * You start to eat the chocolates. After eating a chocolate you leave only a wrapper.
 * <p>
 * You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat
 * the following one.
 * <p>
 * More precisely, if you ate chocolate number X, then you will next eat the chocolate with number
 * (X + M) modulo N (remainder of division).
 * <p>
 * You stop eating when you encounter an empty wrapper.
 * <p>
 * For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.
 * <p>
 * The goal is to count the number of chocolates that you will eat, following the above rules.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N, int M); }
 * <p>
 * that, given two positive integers N and M, returns the number of chocolates that you will eat.
 * <p>
 * For example, given integers N = 10 and M = 4. the function should return 5, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N and M are integers within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N+M));
 * expected worst-case space complexity is O(log(N+M)).
 */
public class ChocolatesByNumbers {
    public static void main(String[] args) {
        System.out.println("ChocolatesByNumbers:\n\t" + new ChocolatesByNumbers().solution(10, 4));
    }

    public int solution(int N, int M) {

        Set<Integer> set = new HashSet<>();

        int currentNumber = 0;
        set.add(currentNumber); // the 1st chocolate
        int numChocolate = 1;   // eat the 1st one

        while (true) {
            currentNumber = (currentNumber + M) % N;
            if (set.contains(currentNumber) == true) {
                break;
            } else {
                numChocolate++; // eat one more chocolate
                set.add(currentNumber); // record its number
            }
        }

        return numChocolate;
    }
}
