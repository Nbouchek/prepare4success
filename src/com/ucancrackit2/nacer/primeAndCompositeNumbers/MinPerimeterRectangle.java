package com.ucancrackit2.nacer.primeAndCompositeNumbers;

/**
 * Find the minimal perimeter of any rectangle whose area equals N.
 * <p>
 * An integer N is given, representing the area of some rectangle.
 * <p>
 * The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
 * <p>
 * The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be
 * only integers.
 * <p>
 * For example, given integer N = 30, rectangles of area 30 are:
 * <p>
 * (1, 30), with a perimeter of 62,
 * (2, 15), with a perimeter of 34,
 * (3, 10), with a perimeter of 26,
 * (5, 6), with a perimeter of 22.
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.
 * <p>
 * For example, given an integer N = 30, the function should return 22, as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(sqrt(N));
 * expected worst-case space complexity is O(1).
 */
public class MinPerimeterRectangle {
    public static void main(String[] args) {
        System.out.println("MinPerimeterRectangle:\n\t" + new MinPerimeterRectangle().solution(30));
    }

    public int solution(int N) {

        // main idea:
        // try to find the one "closest to sqrt(N)"

        int sqrtN = (int) Math.sqrt(N);
        int perimeter = (2) + (N * 2); // perimeter = (A*2)+(B*2)

        for (int i = sqrtN; i > 0; i--) { // from the one closest to sqrt(N)
            if (N % i == 0) {             // key point: "N % i ==0"
                int B = N / i;
                perimeter = (i * 2) + (B * 2);
                break;                  // be careful: break from the for-loop
            }
        }

        return perimeter;
    }
}
