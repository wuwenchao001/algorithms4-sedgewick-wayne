/**
 *  Since this condition is checked once for each recursive call to sort(),
 *  and the sort() method is called N times for an array of length N
 *  (once for each element),
 *  the total number of comparisons is linear in the size of the array.
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Exercise8_merge_sorted_linear_mid_compares {
    public static void main(String[] args) {
        int maxN = 5000;

        StdDraw.setXscale(0, maxN);
        StdDraw.setYscale(0, maxN);
        StdDraw.setPenRadius(0.01);

        for (int N = 1000; N <= maxN; N++) {
            Integer[] a = new Integer[N];
            for (int i = 0; i < N; i++) {
                a[i] = i; // Sorted array
            }
            Merge.sort(a);
            int comparisons = Merge.getComparisons();
            double ratio = comparisons / (double) N; //  approximate 1
            StdOut.println(ratio);

            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.point(N, comparisons);
        }
    }

    private static class Merge {
        private static Comparable[] aux;
        private static int comparisons = 0;

        public static int getComparisons() {
            return comparisons;
        }

        public static void sort(Comparable[] a) {
            comparisons = 0;
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            if (less(a[mid+1],a[mid])) { // Merge or not
                merge(a, lo, mid, hi);
            }
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
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
            comparisons++;
            return v.compareTo(w) < 0;
        }
    }
}

