package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 2.2.26 Array creation.
 * Use SortCompare to get a rough idea of the effect on performance on your machine of
 * creating aux[] in merge() rather than in sort().
 */
public class Exercise26_aux_creation {

    //  In Java, an inner class cannot have static declarations.
    public static class MergesortWithAuxInSort {
        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];  // in sort(){}
            sort(a, aux, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);
        }

        private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;

            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
                else a[k] = aux[i++];
            }
        }
    }

    public static class MergesortWithAuxInMerge {
        public static void sort(Comparable[] a) {
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            Comparable[] aux = new Comparable[hi - lo + 1];  // in merge(){}

            // Copy to aux[]
            for (int k = lo; k <= hi; k++) {
                aux[k - lo] = a[k];
            }

            // Merge back to a[]
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++ - lo];
                else if (j > hi) a[k] = aux[i++ - lo];
                else if (aux[j - lo].compareTo(aux[i - lo]) < 0) a[k] = aux[j++ - lo];
                else a[k] = aux[i++ - lo];
            }
        }
    }

    public class SortCompare {
        public static double time(String alg, Double[] a) {
            Stopwatch timer = new Stopwatch();
            if (alg.equals("MergesortWithAuxInSort")) MergesortWithAuxInSort.sort(a);
            if (alg.equals("MergesortWithAuxInMerge")) MergesortWithAuxInMerge.sort(a);
            return timer.elapsedTime();
        }

        public static double timeRandomInput(String alg, int N, int T) {
            double total = 0.0;
            Double[] a = new Double[N];
            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform();
                total += time(alg, a);
            }
            StdOut.printf("total sorting time of %s is %.2f\n", alg, total);
            return total;
        }
    }

    public static void main(String[] args) {
        String alg1;
        String alg2;
        int N;
        int T;
        if (args != null && args.length > 0) {
            alg1 = args[0];
            alg2 = args[1];
            N = Integer.parseInt(args[2]);
            T = Integer.parseInt(args[3]);
        } else {
            alg1 = "MergesortWithAuxInSort";
            alg2 = "MergesortWithAuxInMerge";
            N = 100000; // Integer.parseInt(args[2]);
            T = 3;    //Integer.parseInt(args[3]);
        }

        double t1 = SortCompare.timeRandomInput(alg1, N, T);
        double t2 = SortCompare.timeRandomInput(alg2, N, T);
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}