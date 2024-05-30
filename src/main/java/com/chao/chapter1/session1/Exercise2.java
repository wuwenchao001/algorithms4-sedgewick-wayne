package com.chao.chapter1.session1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2 {
    public static void main(String[] args) {
        double resultA = (1 + 2.236) / 2;
        double resultB = 1 + 2 + 3 + 4.0;
        boolean resultC = 4.1 >= 4;
        String resultD = 1 + 2 + "3";

        StdOut.println("a) " + resultA);
        StdOut.println("b) " + resultB);
        StdOut.println("c) " + resultC);
        StdOut.println("d) " + resultD);
    }
}
/**
 * a) 1.618 double
 * b) 10.0  double
 * c) true  boolean
 * d) 33    String
 */