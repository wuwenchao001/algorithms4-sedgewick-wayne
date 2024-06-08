package com.chao.chapter2.session1.util;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class SortCompare30 {

    public static double time(SortType alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case INSERTION:
                Insertion.sort(a);
                break;
            case SELECTION:
                Selection.sort(a);
                break;
            // Add more sorting algorithms as needed
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(SortType alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        Random rand = new Random();
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = rand.nextDouble();
            total += time(alg, a);
        }
        return total;
    }

    public static void compare(SortType alg1, SortType alg2, int N, int T) {
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }

    public static void main(String[] args) {
        SortType alg1 = SortType.valueOf(args[0].toUpperCase());
        SortType alg2 = SortType.valueOf(args[1].toUpperCase());
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        compare(alg1, alg2, N, T);
    }
}
