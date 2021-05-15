package com.ucancrackit2.nacer.collections;


import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {

        System.out.println("*** Deque as a Stack");
        // Deque as a Que using add remove
        Deque<String> theQue = new ArrayDeque<>();

        theQue.add("One");
        theQue.add("Two");
        theQue.add("Three");

        while (theQue.size() > 0) {
            System.out.println("" + theQue.remove());
        }

        System.out.println("*** Deque as a Que");
        // Deque as a Stack using pop/push
        Deque<String> theStack = new ArrayDeque<>();
        theStack.push("Four");
        theStack.push("Five");
        theStack.push("Six");

        while (theStack.size() > 0) {
            System.out.println("" + theStack.pop());
        }
    }
}
