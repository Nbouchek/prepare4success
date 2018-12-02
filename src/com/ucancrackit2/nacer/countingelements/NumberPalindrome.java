package com.ucancrackit2.nacer.countingelements;

/**
 * Palindrome number in java: A palindrome number is a number that is same after reverse.
 * For example 545, 151, 34543, 343, 171, 48984 are the palindrome numbers.
 * It can also be a string like LOL, MADAM etc.
 */
public class NumberPalindrome {
    public static void main(String[] args) {
        System.out.println(new NumberPalindrome().isNumberPalindrome(454));
        System.out.println(new NumberPalindrome().isNumberPalindrome(45));
        System.out.println(new NumberPalindrome().isNumberPalindrome(0));
    }

    public boolean isNumberPalindrome(int n) {
        StringBuffer numberString = new StringBuffer(Integer.toString(n));
        return Integer.toString(n).equals(numberString.reverse().toString());
    }
}
