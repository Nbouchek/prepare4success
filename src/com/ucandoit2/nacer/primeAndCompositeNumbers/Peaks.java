package com.ucandoit2.nacer.primeAndCompositeNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Divide an array into the maximum number of same-sized blocks, each of which should contain an index P such that
 * A[P - 1] < A[P] > A[P + 1].
 * <p>
 * A non-empty array A consisting of N integers is given.
 * <p>
 * A peak is an array element which is larger than its neighbors. More precisely, it is an index P such that
 * 0 < P < N − 1,  A[P − 1] < A[P] and A[P] > A[P + 1].
 * <p>
 * For example, the following array A:
 * <p>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * has exactly three peaks: 3, 5, 10.
 * <p>
 * We want to divide this array into blocks containing the same number of elements. More precisely, we want to choose a number K that will yield the following blocks:
 * <p>
 * A[0], A[1], ..., A[K − 1],
 * A[K], A[K + 1], ..., A[2K − 1],
 * ...
 * A[N − K], A[N − K + 1], ..., A[N − 1].
 * What's more, every block should contain at least one peak. Notice that extreme elements of the blocks (for example A[K − 1] or A[K]) can also be peaks, but only if they have both neighbors (including one in an adjacent blocks).
 * <p>
 * The goal is to find the maximum number of blocks into which the array A can be divided.
 * <p>
 * Array A can be divided into blocks as follows:
 * <p>
 * one block (1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). This block contains three peaks.
 * two blocks (1, 2, 3, 4, 3, 4) and (1, 2, 3, 4, 6, 2). Every block has a peak.
 * three blocks (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). Every block has a peak. Notice in particular that the first
 * block (1, 2, 3, 4) has a peak at A[3], because A[2] < A[3] > A[4], even though A[4] is in the adjacent block.
 * However, array A cannot be divided into four blocks, (1, 2, 3), (4, 3, 4), (1, 2, 3) and (4, 6, 2), because the
 * (1, 2, 3) blocks do not contain a peak. Notice in particular that the (4, 3, 4) block contains two peaks: A[3] and
 * A[5].
 * <p>
 * The maximum number of blocks that array A can be divided into is three.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A consisting of N integers, returns the maximum number of blocks into which A can be
 * divided.
 * <p>
 * If A cannot be divided into some number of blocks, the function should return 0.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1
 * A[1] = 2
 * A[2] = 3
 * A[3] = 4
 * A[4] = 3
 * A[5] = 4
 * A[6] = 1
 * A[7] = 2
 * A[8] = 3
 * A[9] = 4
 * A[10] = 6
 * A[11] = 2
 * the function should return 3, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [0..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(log(N)));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */

public class Peaks {
    public static void main(String[] args) {
        System.out.println("Peaks:\n\t" + new Peaks().solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
    }

    public int solution(int[] A) {

        // main idea:
        // 1) find all the peaks, and put them into a List
        // 2) try to divide the array into a number of groups,
        //    and check if all the groups have at least one peak
        //--> if yes, return the "number of groups"

        // use "List" to store all the peaks
        List<Integer> peaksIndexList = new ArrayList<>();

        // 1) find the peaks (and store them)
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) { // A[i] > A[i-1], A[i] > A[i+1]
                peaksIndexList.add(i);
            }
        }

        // 2) check the number of Blocks
        int N = A.length;

        // from the "biggest possible number" to smaller number
        for (int numBlocks = N; numBlocks >= 1; numBlocks--) {

            if (N % numBlocks == 0) { // it is divisible

                int blockSize = N / numBlocks;
                int ithOkBlock = 0;  // the ith block has peak(s)

                // test all the peaks
                // if a peak is found in the ith block
                // then, go to the (i+1)th block
                for (int peaksIndex : peaksIndexList) {
                    if (peaksIndex / blockSize == ithOkBlock) { // peak in the ith block
                        ithOkBlock++; // go to check (i+1)th block
                    }
                }

                // ithOkBlock: the number of blocks having peak(s)
                // if all the blocks have peak(s)
                // then, return the number of blocks
                // note: we test from the biggest possible number
                // so, once we find it, we can just return it
                // (no need to check the smaller possible numbers)
                if (ithOkBlock == numBlocks) {
                    return numBlocks;
                }
            }
        }

        return 0;
    }
}
