package com.ucandoit2.nacer.tasksFromIndeedPrime2015;

/**
 * You would like to set a password for a bank account. However, there are three restrictions on the format of the
 * password:
 * <p>
 * it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
 * there should be an even number of letters;
 * there should be an odd number of digits.
 * You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and
 * removing, the spaces. The goal is to choose the longest word that is a valid password. You can assume that if there
 * are K spaces in string S then there are exactly K + 1 words.
 * <p>
 * For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A"
 * and "pass007". Thus the longest password is "pass007" and its length is 7. Note that neither "test" nor "?xy1" is a
 * valid password, because "?" is not an alphanumerical character and "test" contains an even number of digits (zero).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a non-empty string S consisting of N characters, returns the length of the longest word from the string
 * that is a valid password. If there is no such word, your function should return −1.
 * <p>
 * For example, given S = "test 5 a0A pass007 ?xy1", your function should return 7, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..200];
 * string S consists only of printable ASCII characters and spaces.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class LongestPassword {
    public static void main(String[] args) {
        System.out.println("LongestPassword:\n\t" + new LongestPassword().solution("test 5 a0A pass007 ?xy1"));
    }

    public int solution(String password) {
        String[] words = password.replaceAll("\\s+", " ").split(" ");
        int maxLength = -1;
        for (String word : words) {
            if (word.matches("^[0-9a-zA-Z]*$") &&
                    word.replaceAll("[0-9]+", "").length() % 2 == 0 &&
                    word.replaceAll("[a-zA-Z]+", "").length() % 2 == 1) {
                maxLength = Math.max(maxLength, word.length());
            }
        }
        return maxLength;
    }
}
