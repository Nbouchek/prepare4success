package com.ucancrackit2.nacer.stacksandqueues;

import java.util.Stack;

/**
 * Determine whether a given string of parentheses (single type) is properly nested.
 * <p>
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0,
 * as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..1,000,000];
 * string S consists only of the characters "(" and/or ")".
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
 */
public class Nesting {
    public static void main(String[] args) {
        System.out.println("Nesting:\n\t" + new Nesting().solution("(()(())())"));
    }

    public int solution(String theString) {
        // special case 1: empty string
        if (theString.length() == 0)
            return 1;
            // special case 2: odd length
        else if (theString.length() % 2 == 1)
            return 0;

        // main idea: use "stack" to check
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < theString.length(); i++) {
            if (theString.charAt(i) == '(') {
                stack.push(')'); // note: push its pair (be careful)
            } else if (theString.charAt(i) == ')') {
                // before pop: need to check if stack is empty (important)
                if (stack.isEmpty() == true) {
                    return 0;
                } else {
                    char temp = stack.pop();
                    if (temp != ')') {
                        return 0;
                    }
                }
            }
        }

        // be careful: if stack is "not empty" -> return 0
        if (!stack.isEmpty())
            return 0;
        else
            return 1;
    }
}
