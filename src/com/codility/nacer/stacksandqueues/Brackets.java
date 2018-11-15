package com.codility.nacer.stacksandqueues;

import java.util.Stack;

/**
 * Determine whether a given string of parentheses (multiple types) is properly nested.
 * <p>
 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
 * <p>
 * S is empty;
 * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(String S); }
 * <p>
 * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
 * <p>
 * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0,
 * as explained above.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..200,000];
 * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
 */
public class Brackets {
    public static void main(String[] args) {
        System.out.println("Brackets;\n\t" + new Brackets().solution("{[()()]}"));
    }

    public int solution(String theString) {

        // main idea: use "Stack" (push and pop)

        //special case
        if (theString.length() == 0)
            return 1;

        // new Stack<Character>()
        Stack<Character> stack = new Stack<>();

        // scan the string (just one pass)
        for (int i = 0; i < theString.length(); i++) {
            // note: push "its pair"
            if (theString.charAt(i) == '(') {
                stack.push(')');
            } else if (theString.charAt(i) == '[') {
                stack.push(']');
            } else if (theString.charAt(i) == '{') {
                stack.push('}');
            }
            // pop and check
            else if (theString.charAt(i) == ')' || theString.charAt(i) == ']' || theString.charAt(i) == '}') {
                // important: check if the stack is empty or not (be careful)
                if (stack.isEmpty() == true) {
                    return 0;
                } else {
                    char temp = stack.pop(); // check if the stack is empty before pop!!!
                    if (temp != theString.charAt(i)) { // not a pair
                        return 0;
                    }
                }
            }
        }
        // note: check if the stack is empty or not (be careful)
        if (!stack.isEmpty()) {
            return 0;
        } else {
            return 1;
        }
    }
}
