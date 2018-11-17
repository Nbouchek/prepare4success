package com.ucandoit2.nacer.strings;

/**
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 *
 * Input:
 * The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.
 *
 * Output:
 * For each test case, in a new line, output a single line containing the reversed String.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= |S| <= 2000
 *
 * Example:
 * Input:
 * 2
 * i.like.this.program.very.much
 * pqr.mno
 *
 * Output:
 * much.very.program.this.like.i
 * mno.pqr
 */
public class ReverseWordsInString {
    private String solution(String string) {
        System.out.println(string);
        string = string.trim();
        String[] words = string.split("[.]");
        for (int i = 0; i < words.length/2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        StringBuilder result= new StringBuilder();
        for (String word : words) result.append(word).append(".");

        return result.toString().trim().substring(0, result.length()-1);
    }

    public static void main(String[] args) {
        String string = " one.t ";
        System.out.println(new ReverseWordsInString().solution(string));
    }
}
