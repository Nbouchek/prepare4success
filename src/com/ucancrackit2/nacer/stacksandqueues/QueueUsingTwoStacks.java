package com.ucancrackit2.nacer.stacksandqueues;

/**
 * Implement a Queue using 2 stacks s1 and s2 .
 * <p>
 * Input Format:
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
 * First line of each test case contains an integer Q denoting the number of queries .
 * A Query Q is of 2 Types
 * (i) 1 x   (a query of this type means  pushing 'x' into the queue)
 * (ii) 2     (a query of this type means to pop element from queue and print the poped element)
 * The second line of each test case contains Q queries seperated by space.
 * <p>
 * Output Format:
 * The output for each test case will  be space separated integers having -1 if the queue is empty else the element poped out from the queue .
 * You are required to complete the two methods push which take one argument an integer 'x' to be pushed into the quee  and pop which returns a integer poped out from othe queue.
 * <p>
 * Your Task:
 * Since this is a function problem, you don't need to take inputs. Just complete the provided functions.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= Q <= 100
 * 1 <= x <= 100
 * <p>
 * Example:
 * Input
 * 1
 * 5
 * 1 2 1 3 2 1 4 2
 * Output
 * 2 3
 * <p>
 * Explanation:
 * Testcase1:
 * 1 2    the quee will be {2}
 * 1 3    the queue will be {2 3}
 * 2       poped element will be 2 the queue will be {3}
 * 1 4    the queue will be {3 4}
 * 2       poped element will be 3
 * <p>
 * <p>
 * Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.
 */
public class QueueUsingTwoStacks {

    public static void main(String[] args) {

    }
}
