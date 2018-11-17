package com.ucandoit2.nacer.fibonacciNumbers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Count the minimum number of jumps required for a frog to get to the other side of a river
 * <p>
 * Count the minimum number of jumps required for a frog to get to the other side of a river.
 * <p>
 * The Fibonacci sequence is defined using the following recursive formula:
 * <p>
 * F(0) = 0
 * F(1) = 1
 * F(M) = F(M - 1) + F(M - 2) if M >= 2
 * A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river
 * (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K)
 * is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves,
 * but only in the direction of the bank at position N.
 * <p>
 * The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A
 * represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a position without a leaf;
 * 1 represents a position containing a leaf.
 * The goal is to count the minimum number of jumps in which the frog can get to the other side of the river
 * (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every
 * position containing a leaf.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to
 * the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 0
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * A[5] = 0
 * A[6] = 1
 * A[7] = 0
 * A[8] = 0
 * A[9] = 0
 * A[10] = 0
 * the function should return 3, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class FibFrog {
    public static void main(String[] args) {
        System.out.println("FibFrog:\n\t" + new FibFrog().solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
    }

    public int solution(int[] A) {
        // note: cannot use "List" (both java.util.* and java.awt.* have "List")
        ArrayList<Integer> fibonacci = new ArrayList<>();

        fibonacci.add(0); // note: f(0) = 0 (as in the quesion)
        fibonacci.add(1);
        // note: using "while" is better than "for" (avoid errors)

        while (true) {
            int temp1 = fibonacci.get(fibonacci.size() - 1);
            int temp2 = fibonacci.get(fibonacci.size() - 2);

            fibonacci.add(temp1 + temp2);

            // if already bigger than length, then break;
            if (temp1 + temp2 > A.length) {
                break;
            }
        }

        // reverse "List": from big to small
        Collections.reverse(fibonacci);

        // use "queue" with "point"
        // point(x,y) = point("position", "number of steps")
        ArrayList<Point> queue = new ArrayList<>();

        queue.add(new Point(-1, 0)); // position:-1, steps:0

        // index: the current index for queue element
        int index = 0;
        while (true) {
            // cannot take element from queue anymore
            if (index == queue.size()) {
                return -1;
            }

            // take element from queue
            Point current = queue.get(index);

            // from big to small
            for (Integer n : fibonacci) {
                int nextPosition = current.x + n;

                // case 1: "reach the other side"
                if (nextPosition == A.length) {
                    // return the number of steps
                    return current.y + 1;
                }

                // case 2: "cannot jump"
                // note: nextPosition < 0 (overflow, be careful)
                else if ((nextPosition > A.length) || (nextPosition < 0) || (A[nextPosition] == 0)) {
                    // note: do nothing
                }

                // case 3: "can jump" (othe cases)
                else {
                    // jump to next position, and step+1
                    Point temp = new Point(nextPosition, current.y + 1);
                    // add to queue
                    queue.add(temp);

                    A[nextPosition] = 0; // key point: for high performance~!!
                }
            }

            index++; // take "next element" from queue
        }
    }
}
