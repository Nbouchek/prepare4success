package com.ucancrackit2.nacer.arrays;

import java.util.Arrays;
import java.util.Random;

public class WinterSummerParition {

    private static int[] randomTemperatures(int n) {
        int[] ts = new int[n];
        for (int i = 0; i < ts.length; ++i) {
            ts[i] = i;
        }
        Random random = new Random(10);
        for (int i = 0; i < ts.length; ++i) {
            int j = i + random.nextInt(ts.length - i);
            int t = ts[i];
            ts[i] = ts[j];
            ts[j] = t;
        }
        return ts;
    }

    public int solution(int[] T) {
        int count = 1;
        int summerCount = 0;
        int winterMax = T[0];
        int summerMax = Integer.MIN_VALUE;
        for (int i = 1; i < T.length; i++) {
            int elem = T[i];
            if (elem <= winterMax) {
                if (summerCount > 0) {
                    count += summerCount;
                    summerCount = 0;
                    winterMax = summerMax;
                }
                count++;
            } else {
                summerMax = Math.max(summerMax, elem);
                summerCount++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] ts = randomTemperatures(64);
        System.out.println(Arrays.toString(ts));
        System.out.println(new WinterSummerParition().solution(ts));

    }
}
