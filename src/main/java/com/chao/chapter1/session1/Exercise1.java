package com.chao.chapter1.session1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1 {
    public static void main(String[] args) {
        int resultA = (0 + 15) / 2;
        double resultB = 2.0e-6 * 100000000.1;
        boolean resultC = true && false || true && true;

        StdOut.println("a) " + resultA);
        StdOut.println("b) " + resultB);
        StdOut.println("c) " + resultC);
    }
}
/**
 * a) 7
 * b) 200.0000002
 * c) true
 */