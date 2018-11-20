package com.ucancrackit2.nacer.stacksandqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array in order of their appearance in the array. If no such element exists, output -1
 * <p>
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases.Then T test cases follow. Each test case consists of two lines. The first line contains an integer N denoting the size of the array. The Second line of each test case contains N space separated positive integers denoting the values/elements in the array A.
 * <p>
 * Output:
 * For each test case, print in a new line, the next greater element for each array element separated by space in order.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1018
 * Example:
 * Input
 * 1
 * 4
 * 1 3 2 4
 * Output
 * 3 4 4 -1
 * <p>
 * Explanation:
 * Testcase1: In the array, the next larger element to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? since it doesn't exist hence -1.
 */
public class NextLargerElementInArray {
    public static void main(String[] args) {
        int array[] = {11, 13, 21, 3};
        System.out.println(Arrays.toString(new NextLargerElementInArray().solution(array)));
    }

    private int[] solution(int[] array) {

        Stack<Integer> stack = new Stack<>();
        int nextGreaterElemet[] = new int[array.length];

        // iterate for rest of the elements
        for (int i = array.length - 1; i >= 0; i--) {

            // if stack is not empty, then
            // pop an element from stack.
            // If the popped element is smaller
            // than next, then
            //  a) print the pair
            //  b) keep popping while elements are
            // smaller and stack is not empty

            while (!stack.empty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            nextGreaterElemet[i] = stack.empty() ? -1 : stack.peek();
            stack.push(array[i]);

        }

        return nextGreaterElemet;
    }
}
