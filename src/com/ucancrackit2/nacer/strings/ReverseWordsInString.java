package com.ucancrackit2.nacer.strings;

/**
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 * <p>
 * Input:
 * The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
 * <p>
 * Output:
 * For each test case, in a new line, output a single line containing the reversed String.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S| <= 2000
 * <p>
 * Example:
 * Input:
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 * <p>
 * Output:
 * much.very.program.this.like.i
 * mno.pqr
 */
public class ReverseWordsInString {
    public static void main(String[] args) {
        String string = " one..t.ss ";
        System.out.println(new ReverseWordsInString().solution(string));
    }

    private String solution(String string) {
        string = string.trim();
        System.out.println(string);
        String[] words = string.split("[.]");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) result.append(word).append(".");

        return result.toString().trim().substring(0, result.length() - 1);
    }
}
