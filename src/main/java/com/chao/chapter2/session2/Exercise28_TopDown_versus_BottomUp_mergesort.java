package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.MergeBU;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 2.2.28 Top-down versus bottom-up. Use SortCompare to compare top-down and bottom-up mergesort
 * for N=10^3, 10^4, 10^5, and 10^6.
 */
public class Exercise28_TopDown_versus_BottomUp_mergesort {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int N : sizes) {
            Double[] a = new Double[N];
            Double[] b = new Double[N];
            for (int i = 0; i < N; i++) {
                double value = StdRandom.uniform();
                a[i] = value;
                b[i] = value;
            }

            Stopwatch timer1 = new Stopwatch();
            Merge.sort(a);
            double time1 = timer1.elapsedTime();

            Stopwatch timer2 = new Stopwatch();
            MergeBU.sort(b);
            double time2 = timer2.elapsedTime();

            StdOut.printf("For N = %d, top-down mergesort took %.2f seconds, bottom-up mergesort took %.2f seconds\n", N, time1, time2);


        }
    }
}
