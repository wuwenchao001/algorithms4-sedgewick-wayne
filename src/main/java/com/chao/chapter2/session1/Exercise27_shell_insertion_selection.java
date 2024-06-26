package com.chao.chapter2.session1;

import com.chao.chapter2.session1.util.SortCompare;
import com.chao.chapter2.session1.util.SortType;
import edu.princeton.cs.algs4.StdOut;

public class Exercise27_shell_insertion_selection {

    public static void main(String[] args) {
        int N = 128;
        int T = 100; // number of trials

        while (N <= 1024) { // stop at 1024 for example
            StdOut.printf("Array size: %d\n", N);
            SortCompare.compare(SortType.SHELL, SortType.INSERTION, N, T);
            SortCompare.compare(SortType.SHELL, SortType.SELECTION, N, T);
            N *= 2; // double the array size
        }
    }
}
