package com.ucancrackit2.nacer.stacksandqueues;

import java.util.Stack;

/**
 * Cover "Manhattan skyline" using the minimum number of rectangles.
 * <p>
 * You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be
 * constant; however, it should have different heights in different places. The height of the wall is specified by an
 * array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In
 * particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.
 * <p>
 * The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to
 * compute the minimum number of blocks needed to build the wall.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] H); }
 * <p>
 * that, given an array H of N positive integers specifying the height of the wall, returns the minimum number of
 * blocks needed to build it.
 * <p>
 * For example, given array H containing N = 9 integers:
 * <p>
 * H[0] = 8    H[1] = 8    H[2] = 5
 * H[3] = 7    H[4] = 9    H[5] = 8
 * H[6] = 7    H[7] = 4    H[8] = 8
 * the function should return 7. The figure shows one possible arrangement of seven blocks.
 * <p>
 * <p>
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array H is an integer within the range [1..1,000,000,000].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class StoneWall {
    public static void main(String[] args) {
        System.out.println("StoneWall:\n\t" + new StoneWall().solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

    public int solution(int[] H) {

        // main idea: need to use "stack" to check when we need a new block

        Stack<Integer> integerStack = new Stack<>();
        int numBlock = 0;

        // note: H[i] is the ith height of the wall
        for (int i = 0; i < H.length; i++) {

            // step 1: "stack is not empty" AND "from high to low"
            // then, "pop" (it is the key point, be careful)
            while (integerStack.isEmpty() == false && integerStack.peek() > H[i]) {
                integerStack.pop();
            }
            // step 2: if the stack is empty
            if (integerStack.isEmpty()) {
                numBlock++;     // add a block
                integerStack.push(H[i]);  // push the height
            }
            // step 3: the height is the same: do nothing
            else if (integerStack.peek() == H[i]) {
            }
            // step 4: from low to high
            else if (integerStack.peek() < H[i]) {
                numBlock++;    // add a block
                integerStack.push(H[i]); // push the height
            }
        }

        return numBlock;
    }
}
