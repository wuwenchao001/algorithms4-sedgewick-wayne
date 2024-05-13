package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.StdOut;

public class LinkedNodeStack {

    private Node first = null;
    private int N = 0;

    private static class Node {
        Node next;
        int data;
    }

    public void push(int data) {
        Node oldFirst = first;
        first = new Node();
        first.data = data;
        first.next = oldFirst;
        N++;
    }
    public int pop() {
        int data = 0;
        if (this.isNotEmpty()) {
            data = first.data;
            first = first.next;
            N--;
        }
        return data;
    }
    public int peek() {
        if (this.isNotEmpty()) {
            return first.data;
        }
        return -1;
    }
    public int size() {
        return N;
    }
    public boolean isNotEmpty() {
        return N > 0;
    }

    public static void main(String[] args) {
        LinkedNodeStack linkedStack = new LinkedNodeStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);

        StdOut.print(linkedStack.peek());

        for (int i = 0; i < 3; i++) {
            int popped = linkedStack.pop();
            StdOut.print(popped);
        }
    }
}
