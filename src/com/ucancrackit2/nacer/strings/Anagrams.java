package com.ucancrackit2.nacer.strings;

import java.util.Arrays;

public class Anagrams {
    private static int NO_OF_CHARS = 256;

    private static int getNoOfChars() {
        return NO_OF_CHARS;
    }

    public static void setNoOfChars(int noOfChars) {
        NO_OF_CHARS = noOfChars;
    }

    public boolean solution(char[] string1, char[] string2) {
        // Create 2 count arrays and initialize
        // all values as 0
        int[] count1 = new int[getNoOfChars()];
        Arrays.fill(count1, 0);
        int[] count2 = new int[getNoOfChars()];
        Arrays.fill(count2, 0);
        int i;

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i <string1.length && i < string2.length ;
             i++)
        {
            count1[string1[i]]++;
            count2[string2[i]]++;
        }

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (string1.length != string2.length)
            return false;

        // Compare count arrays
        for (i = 0; i < getNoOfChars(); i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
    public static void main(String[] args) {
        char[] str1 = ("geeksforgeeksssg").toCharArray();
        char[] str2 = ("forgeeksgeeks").toCharArray();

        if ( new Anagrams().solution(str1, str2) )
            System.out.println("The two strings are" +
                    "anagram of each other");
        else
            System.out.println("The two strings are not"+
                    " anagram of each other");
    }
}
