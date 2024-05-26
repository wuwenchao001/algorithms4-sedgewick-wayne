package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise26_insertion_sort_primitive_types {
    public static void main(String[] args) {
        SortCompare.compare(new String[]{"InsertionSortPrimitive", "InsertionSort", "1000", "10"});
    }

    public static class InsertionSortPrimitive {
        public static void sort(int[] a) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                int key = a[i];
                int j = i;
                while (j > 0 && key < a[j - 1]) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = key;
            }
        }
    }

    public static class InsertionSort {
        public static void sort(Integer[] a) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                    exch(a, j, j-1);
                }
            }
        }

        private static boolean less(Integer v, Integer w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Integer[] a, int i, int j) {
            Integer swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }

    public static class SortCompare {
        public static double time(String alg, Integer[] a) {
            Stopwatch timer = new Stopwatch();
            if (alg.equals("InsertionSort")) InsertionSort.sort(a);
            return timer.elapsedTime();
        }

        public static double timePrimitive(String alg, int[] a) {
            Stopwatch timer = new Stopwatch();
            if (alg.equals("InsertionSortPrimitive")) InsertionSortPrimitive.sort(a);
            return timer.elapsedTime();
        }

        public static double timeRandomInput(String alg, int N, int T)  {
            double total = 0.0;
            Integer[] a = new Integer[N];  // Integer
            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(1000000);
                total += time(alg, a);
            }
            return total;
        }

        public static double timeRandomInputPrimitive(String alg, int N, int T)  {
            double total = 0.0;
            int[] a = new int[N];   // primitive int
            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(1000000);
                total += timePrimitive(alg, a);
            }
            return total;
        }

        public static void compare(String[] args) {
            String alg1 = args[0];
            String alg2 = args[1];
            int N = Integer.parseInt(args[2]);
            int T = Integer.parseInt(args[3]);
            double t1 = timeRandomInputPrimitive(alg1, N, T);
            double t2 = timeRandomInput(alg2, N, T);
            StdOut.printf("For %d random integers\n    %s is", N, alg1);
            StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
        }
    }
}
