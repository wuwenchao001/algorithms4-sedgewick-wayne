package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1isFull {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(5);
        StdOut.printf("Is full when empty? Expected false: %s \n", s.isFull());
        for (int i = 0; i < 5; i++) {
//            s.push(StdIn.readString());
            s.push("item" + i);
        }
        StdOut.printf("Is full when empty? Expected true: %s \n", s.isFull());
        StdOut.println("(" + s.size() + " left on stack)");
    }

    public static class FixedCapacityStackOfStrings {
        private final String[] a; // stack entries
        private int N;      // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        /**
         * Solution key code
         *
         * @return boolean
         */
        public boolean isFull() {
            return N == a.length;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }
    }
}
