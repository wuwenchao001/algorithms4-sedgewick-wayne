package com.chao.chapter2.session1.utils;

import edu.princeton.cs.algs4.*;

public class SortCompareType {
    public static void main(String[] args) {
        if (args.length < 4) {
            StdOut.println("Usage: java SortCompare_generic <sortType1> <sortType2> <arraySize> <trials>");
            return;
        }

        SortType alg1;
        SortType alg2;
        try {
            alg1 = SortType.valueOf(args[0].toUpperCase());
            alg2 = SortType.valueOf(args[1].toUpperCase());
        } catch (IllegalArgumentException e) {
            StdOut.println("Invalid sort type. Valid types are: INSERTION, SELECTION, SHELL, MERGE, QUICK, HEAP");
            return;
        }

        int N;
        int T;
        try {
            N = Integer.parseInt(args[2]);
            T = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            StdOut.println("Array size and number of trials must be integers.");
            return;
        }

        compare(alg1, alg2, N, T);
    }

    public static void compare(SortType sortType1, SortType sortType2, int N, int T) {
        double t1 = timeRandomInput(sortType1, N, T);
        double t2 = timeRandomInput(sortType2, N, T);
        StdOut.printf("For %d random integers\n    %s is", N, sortType1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, sortType2);
    }

    public static double timeRandomInput(SortType sortType, int N, int T) {
        double total = 0.0;
        for (int t = 0; t < T; t++) {
            Double[] a = generateRandomInput(N);
            total += time(sortType, a);
        }
        return total;
    }

    private static Double[] generateRandomInput(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform();
        return a;
    }

    public static double time(SortType sortType, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (sortType == SortType.INSERTION) Insertion.sort(a);
        if (sortType == SortType.SELECTION) Selection.sort(a);
        if (sortType == SortType.SHELL) Shell.sort(a);

        return timer.elapsedTime();
    }
}