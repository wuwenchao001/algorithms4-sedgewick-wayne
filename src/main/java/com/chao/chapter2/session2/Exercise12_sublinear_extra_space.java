package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 2.2.12 Sublinear extra space.
 * Develop a merge implementation that reduces the extra space requirement to max(M, N/M),
 * based on the following idea:
 * Divide the array into N/M blocks of size M (for simplicity in this description, assume that N is a multiple of M).
 * Then,
 * (i) considering the blocks as items with their first key as the sort key, sort them using --selection-- sort;
 * (ii) run through the array merging the first block with the second,
 * then the second block with the third, and so forth.
 */
public class Exercise12_sublinear_extra_space {
    public static void main(String[] args) {
        Integer[] a = new Integer[100];
        for (int i = 0; i < 100; i++) {
            a[i] = StdRandom.uniform(10);
        }

        Merge.sort(a, 10);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]);
        }
    }

    public static class Merge {
        public static void sort(Comparable[] a, int M) {
            int N = a.length;
            Comparable[] aux = new Comparable[M];

            // Sort blocks of size M. Should be selection sort...@~@
            for (int i = 0; i < N; i += M)
//                selectionSort(a, i, Math.min(i+M, N));
                Arrays.sort(a, i, Math.min(i + M, N));

            // Sequentially merge blocks
            for (int i = 0; i < N - M; i += M)
                merge(a, aux, i, i + M - 1, Math.min(i + 2 * M - 1, N - 1));
        }

        private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;

            // Copy to aux[], length <= M
            System.arraycopy(a, lo, aux, 0, mid - lo + 1);

            // Merge back to a[]
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)              a[k] = a[j++];
                else if (j > hi)               a[k] = aux[i++ - lo];
                else if (less(a[j], aux[i - lo])) a[k] = a[j++];  // will k > j? no
                else                           a[k] = aux[i++ - lo];
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}

