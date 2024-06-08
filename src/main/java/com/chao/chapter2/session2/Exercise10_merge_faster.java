/**
 * This eliminates the need to check if either half of the array is exhausted in the inner loop.
 *
 * In the merge step, we start from the beginning of the first half and the end of the second half,
 * and move towards the middle.
 * This way,we don't need to check if either half is exhausted, because when `i` and `j` meet,
 * we know we've processed all elements.
 */

package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Faster merge, merge() that copies the second half of a[] to aux[] in decreasing order
 * and then does the merge back to a[].
 * This change allows you to remove the code to test that each of the halves has been exhausted from the inner loop.
 * Note: The resulting sort is not stable (see page 341).
 */
public class Exercise10_merge_faster {
    public static void main(String[] args) {
        Integer[] a = new Integer[100];
        for (int i = 0; i < 100; i++) {
            a[i] = StdRandom.uniform(10);
        }
        Merge.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public class Merge {

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

        /**
         * The primary logic code for the solution.
         */
        public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
            int i = lo, j = hi;
            for (int k = lo; k <= mid; k++)
                aux[k] = a[k];
            for (int k = mid+1; k <= hi; k++)
                aux[k] = a[hi-k+mid+1];
            for (int k = lo; k <= hi; k++)
                if (less(aux[j], aux[i])) a[k] = aux[j--];
                else                       a[k] = aux[i++];
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}

