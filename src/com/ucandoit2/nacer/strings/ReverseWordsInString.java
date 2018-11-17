package com.ucandoit2.nacer.strings;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReverseWordsInString {
    private String solution(String string) {
        System.out.println(string);

        String[] words = string.split(" ");
        for (int i = 0; i < words.length/2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        StringBuilder result= new StringBuilder();
        for (String word : words) result.append(word).append(" ");

        return result.toString();
    }

    public static void main(String[] args) {
        String string = "one two three";
        System.out.println(new ReverseWordsInString().solution(string));
    }
}
