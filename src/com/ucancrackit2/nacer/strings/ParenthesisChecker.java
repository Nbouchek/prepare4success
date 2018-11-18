package com.ucancrackit2.nacer.strings;

import java.util.Stack;

/**
 * Given an expression string exp. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the program should print 'balanced' for exp = “[()]{}{[()()]()}” and 'not balanced' for exp = “[(])”
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.  Each test case consists of a string of expression, in a separate line.
 * <p>
 * Output:
 * Print 'balanced' without quotes if the pair of parenthesis is balanced else print 'not balanced' in a separate line.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ |s| ≤ 100
 * <p>
 * Example:
 * Input:
 * 3
 * {([])}
 * ()
 * ([]
 * <p>
 * Output:
 * balanced
 * balanced
 * not balanced
 */
public class ParenthesisChecker {
    public int solution(String theString) {
        int length = theString.length();
        if (length == 0) return 1;
        Stack<Character> theStack = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (theString.charAt(i) == '(') theStack.push(')');
            else if (theString.charAt(i) == '{') theStack.push('}');
            else if (theString.charAt(i) == '[') theStack.push(']');
            else if (theString.charAt(i) == ')' || theString.charAt(i) == '}' || theString.charAt(i) == ']') {
                if (theStack.isEmpty() || theStack.pop() != theString.charAt(i)) return 0;
            }
        }
        return theStack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println("ParenthesisChecker;\n\t" + new ParenthesisChecker().solution("[[{()}][][]]"));
    }
}
