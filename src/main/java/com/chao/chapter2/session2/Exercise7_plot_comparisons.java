/**
 * TODO 没看到上界啊？？upper bound 6N lg N 哪里来的？
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise7_plot_comparisons {
    public static void main(String[] args) {
        plotComparisons();
    }

    public static void plotComparisons() {
        int maxN = 1000;
        StdDraw.setXscale(0, maxN);
        StdDraw.setYscale(0, maxN * Math.log(maxN) / Math.log(10));
        StdDraw.setPenRadius(0.01);

        for (int N = 100; N < maxN; N++) {
            Integer[] a = new Integer[N];
            Integer[] b = new Integer[N/2];
            for (int i = 0; i < N/2; i++) {
                a[i] = StdRandom.uniform(-1000, 1000);
                b[i] = a[i];
            }
            for (int i = N/2; i < N; i++) {
                a[i] = StdRandom.uniform(-1000, 1000);
            }

            MergeTopDown.sort(a);
            int comparesN = MergeTopDown.getComparisons();
            StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.point(N, comparesN);

            MergeTopDown.sort(b);
            int comparesN_2 = MergeTopDown.getComparisons();
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.point(N, comparesN_2);

            StdDraw.setPenColor(StdDraw.BLACK);
            if (comparesN < comparesN_2) {      // no black dot if C(N+1) > C(N) for all N > 0
                StdDraw.point(N, 100);
            }

            StdOut.println("N = " + N + ", C(N) = " + comparesN + ", C(N+1) = " + comparesN_2);
        }
    }

    public static class MergeTopDown {
        private static Comparable[] aux;
        private static int comparisons;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            comparisons = 0;
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            comparisons++; // compare
            return v.compareTo(w) < 0;
        }

        public static int getComparisons() {
            return comparisons;
        }
    }

    public static class MergeBottomUp {
        private static Comparable[] aux;
        private static int comparisons;

        public static void sort(Comparable[] a) {
            int N = a.length;
            aux = new Comparable[N];
            comparisons = 0;
            for (int sz = 1; sz < N; sz = sz + sz)
                for (int lo = 0; lo < N - sz; lo += sz + sz)
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            comparisons++; // compare
            return v.compareTo(w) < 0;
        }

        public static int getComparisons() {
            return comparisons;
        }
    }
}
