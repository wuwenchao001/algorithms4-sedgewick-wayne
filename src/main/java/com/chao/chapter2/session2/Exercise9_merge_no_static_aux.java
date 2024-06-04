// The edu.princeton.cs.algs4.Merge use this kind of no static aux, too.

package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Merge that does not use a static array.
 * Do not make aux[] local to merge() to avoid the overhead of creating.
 * Hint : Pass the auxiliary array as an argument to the recursive sort().
 */
public class Exercise9_merge_no_static_aux {
    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = StdRandom.uniform(10);
        }
        Merge.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i]);
        }
    }

    private static class Merge {

        public static void sort(Comparable[] a) {
            Comparable[] aux = new Comparable[a.length];
            sort(a, aux, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            if (less(a[mid + 1], a[mid])) {
                merge(a, aux, lo, mid, hi);
            }
        }

        public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++)
                aux[k] = a[k];
            for (int k = lo; k <= hi; k++)
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) a[k] = aux[j++];
                else a[k] = aux[i++];
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}

