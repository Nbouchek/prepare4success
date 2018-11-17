package com.ucandoit2.nacer.iterations;

/**
 * Find longest sequence of zeros in binary representation of an integer.
 * <p>
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at
 * both ends in the binary representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has
 * binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20
 * has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation
 * 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N
 * doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its
 * longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation
 * '100000' and thus no binary gaps.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println("BinaryGap:\n\t" + new BinaryGap().solution(455));
    }

    public int solution(int N) {
        int max_gap = 0;
        int current_gap = 0;
        boolean counting = false;

        // Using the "concept of bit manipulation" and "& operation"
        while (N != 0) {
            if (counting == false) {    // for the first "1"
                if ((N & 1) == 1) {      // note: cannot use n&1 withoug "()"
                    counting = true;  // start to count
                }
            } else {                    // counting = true
                if ((N & 1) == 0) {      // note: cannot use n&1 withoug "()"
                    current_gap++;
                } else { // N & 1 == 1
                    max_gap = Math.max(max_gap, current_gap);
                    current_gap = 0; // reset
                }
            }

            N = N >> 1; // shift by one (right side)
            // note: cannot just write "N >> 1"
        }

        return max_gap;
    }
}
