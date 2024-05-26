package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortType;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exercise26_insertion_sort_primitive_types_usingSortType {
    public static void main(String[] args) {
        SortCompare.compare(SortType.INSERTION_PRIMITIVE, SortType.INSERTION, 1000, 10);
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
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
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
        public static void compare(SortType sortType1, SortType sortType2, int N, int T) {
            //double t1;
            //t1 = (sortType1 == SortType.INSERTION_PRIMITIVE) ? timeRandomInputPrimitive(sortType1, N, T) : timeRandomInput(sortType1, N, T);
            double t1 = timeRandomInputPrimitive(sortType1, N, T);
            double t2 = timeRandomInput(sortType2, N, T);
            StdOut.printf("For %d random integers\n    %s is", N, sortType1);
            StdOut.printf(" %.1f times faster than %s\n", t2 / t1, sortType2);
        }

        // for Integer type
        public static double time(SortType sortType, Integer[] a) {
            Stopwatch timer = new Stopwatch();
            if (sortType == SortType.INSERTION) InsertionSort.sort(a);
            return timer.elapsedTime();
        }
        public static double timeRandomInput(SortType sortType, int N, int T) {
            double total = 0.0;
            Integer[] a = new Integer[N];
            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(1000000);
                total += time(sortType, a);
            }
            return total;
        }

        // for int primitive type
        public static double timePrimitive(SortType sortType, int[] a) {
            Stopwatch timer = new Stopwatch();
            if (sortType == SortType.INSERTION_PRIMITIVE) InsertionSortPrimitive.sort(a);
            return timer.elapsedTime();
        }
        public static double timeRandomInputPrimitive(SortType sortType, int N, int T) {
            double total = 0.0;
            int[] a = new int[N];
            for (int t = 0; t < T; t++) {
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(1000000);
                total += timePrimitive(sortType, a);
            }
            return total;
        }
    }
}

