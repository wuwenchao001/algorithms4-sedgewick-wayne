/**
 * TODO 没看到上界啊？？upper bound 6N lg N 哪里来的？
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise6_plot_accesses {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MergeTopDown.sort(a.clone());
        MergeBottomUp.sort(a.clone());
        StdOut.println("Bottom-up mergesort accesses: " + MergeBottomUp.getAccesses() + "\n" +
                "Top-down mergesort accesses: " + MergeTopDown.getAccesses());

        plot();
    }

    public static void plot() {
        int maxN = 512;
        StdDraw.setXscale(0, maxN);
        StdDraw.setYscale(0, 6 * maxN * Math.log(maxN) / Math.log(10));
        StdDraw.setPenRadius(0.01);
        for (int N = 1; N <= maxN; N++) {
            Integer[] a = new Integer[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform(-1000, 1000);
            }
            MergeTopDown.sort(a.clone());
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(N, MergeTopDown.getAccesses());

            MergeBottomUp.sort(a.clone());
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.point(N, MergeBottomUp.getAccesses());

            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.point(N, 6 * N * Math.log(N) / Math.log(10));
        }
    }

    public static class MergeTopDown {
        private static Comparable[] aux;
        private static int accesses;

        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            accesses = 0;
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
                accesses += 2; // array read and write
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                    accesses += 2; // array read and write
                } else if (j > hi) {
                    a[k] = aux[i++];
                    accesses += 2; // array read and write
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    accesses += 4; // two array reads and two writes
                } else {
                    a[k] = aux[i++];
                    accesses += 4; // two array reads and two writes
                }
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            accesses += 2; // two array reads
            return v.compareTo(w) < 0;
        }

        public static int getAccesses() {
            return accesses;
        }
    }

    public static class MergeBottomUp {
        private static Comparable[] aux;
        private static int accesses;

        public static void sort(Comparable[] a) {
            int N = a.length;
            aux = new Comparable[N];
            accesses = 0;
            for (int sz = 1; sz < N; sz = sz + sz)
                for (int lo = 0; lo < N - sz; lo += sz + sz)
                    merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
                accesses += 2; // array read and write
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                    accesses += 2; // array read and write
                } else if (j > hi) {
                    a[k] = aux[i++];
                    accesses += 2; // array read and write
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    accesses += 4; // two array reads and two writes
                } else {
                    a[k] = aux[i++];
                    accesses += 4; // two array reads and two writes
                }
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            accesses += 2; // two array reads
            return v.compareTo(w) < 0;
        }

        public static int getAccesses() {
            return accesses;
        }
    }
}
