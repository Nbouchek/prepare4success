package com.ucandoit2.nacer.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, print all permutations of a given string.
 *
 * Input:
 * The first line of input contains an integer T, denoting the number of test cases.
 * Each test case contains a single string S in capital letter.
 *
 * Output:
 * For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.
 *
 * Constraints:
 * 1 ≤ T ≤ 10
 * 1 ≤ size of string ≤ 5
 *
 * Example:
 * Input:
 * 2
 * ABC
 * ABSG
 * Output:
 * ABC ACB BAC BCA CAB CBA
 * ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 */
public class PermutationsAfAString {

    private void solution(String string) {
        Set<String> permutations = new HashSet<>();
        permute(string, 0, string.length()-1, permutations);
        System.out.println("permutations: " + permutations.toString());
    }

    private void permute(String string, int left, int right, Set<String> set) {

        if (left == right) {
            System.out.println(string);
            set.add(string);
        }
        else {
            for (int i = left; i <= right; i++) {
                string = swapChars(string, left, i);
                permute(string, left + 1, right, set);
                string = swapChars(string, left, i);
            }
        }
    }

    private String swapChars(String a, int i, int j)
    {
        char[] charArray = a.toCharArray();

        char temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String string = "exit";
        new PermutationsAfAString().solution(string);
    }
}
