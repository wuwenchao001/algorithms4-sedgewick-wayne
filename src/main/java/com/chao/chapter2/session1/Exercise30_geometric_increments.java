package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.List;

public class Exercise30_geometric_increments {

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1000000, 1000000);
        }

        int bestT = 0;   // If you extend the range of values of t to Double,
        double bestTime = Double.POSITIVE_INFINITY; // you may have even more extreme minimum times

        for (int t = 2; t <= 10; t++) {
            Integer[] b = a.clone();
            Stopwatch timer = new Stopwatch();
            GeometricIncrement.sort(b, t);
            double time = timer.elapsedTime();
            if (time < bestTime) {
                bestTime = time;
                bestT = t;
            }
            assert GeometricIncrement.isSorted(b);
        }

        StdOut.printf("Best t: %d, Best time: %.2f\n", bestT, bestTime);
    }

    public class GeometricIncrement {

        public static void sort(Comparable[] a, int t) {
            int N = a.length;
            List<Integer> increments = new ArrayList<>();
            for (int h = 1; h < N; h *= t) {
                increments.add(h);
            }

            for (int k = increments.size() - 1; k >= 0; k--) {
                int h = increments.get(k);
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                        exch(a, j, j - h);
                }
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        public static boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1])) return false;
            return true;
        }
    }
}
