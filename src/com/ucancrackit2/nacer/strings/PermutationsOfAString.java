package com.ucancrackit2.nacer.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, print all permutations of a given string.
 * <p>
 * Input:
 * The first line of input contains an integer T, denoting the number of test cases.
 * Each test case contains a single string S in capital letter.
 * <p>
 * Output:
 * For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 * <p>
 * Example:
 * Input:
 * 2
 * ABC
 * ABSG
 * Output:
 * ABC ACB BAC BCA CAB CBA
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 */
public class PermutationsOfAString {

    public static void main(String[] args) {
        String string = "taxi";
        new PermutationsOfAString().solution(string);
    }

    private void permute(String string, int left, int right, Set<String> set) {

        if (left == right) {
            set.add(string);
        } else {
            for (int i = left; i <= right; i++) {
                string = swapChars(string, left, i);
                permute(string, left + 1, right, set);
                string = swapChars(string, left, i);
            }
        }
    }

    private void solution(String string) {
        Set<String> permutations = new HashSet<>();
        permute(string, 0, string.length() - 1, permutations);
        System.out.println("permutations: " + permutations);
    }

    private String swapChars(String string, int i, int j) {
        char[] charArray = string.toCharArray();

        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }
}
