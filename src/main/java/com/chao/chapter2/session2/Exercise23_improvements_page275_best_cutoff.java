/**
 * Explain the recursive trickery:
 * The roles of the input array and the auxiliary array are switched at each level of recursion,
 * eliminating the need to copy the array before merging.
 * <p>
 * The key point here is that the merge() method always merges elements from the src array
 * and puts the sorted output in the dst array.
 * So, by switching the roles of src and dst at each level of recursion,
 * you ensure that the sorted output is always in the original array a,
 * and you don't need to copy elements to the auxiliary array before merging.
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.23 Improvements.
 * Runempirical studies to evaluate the effectiveness of ??each?? of the three improvements to mergesort
 * that are described in the text (see Exercise 2.2.11).
 * Also,
 * compare the performance of the merge implementation given in the text with the merge described in Exercise 2.2.10.
 * <p>
 * <p>
 * In particular,
 * empirically determine the best value of the parameter
 * that decides when to switch to insertion sort for small subarrays.
 */
public class Exercise23_improvements_page275_best_cutoff {

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000, 64000};
        int[] cutoffs = {5, 10, 20, 33,  40, 80, 100, 200, 400};
        for (int size : sizes) {
            for (int cutoff : cutoffs) {
                Integer[] a = new Integer[size];
                for (int i = 0; i < size; i++) {
                    a[i] = StdRandom.uniform(1000);
                }
                long startTime = System.currentTimeMillis();
                Merge.sort(a, cutoff);
                long endTime = System.currentTimeMillis();
                System.out.println("Size: " + size + ", Cutoff: " + cutoff + ", Time: " + (endTime - startTime) + " ms");
            }
        }
    }

    private static class Merge {
        private static Comparable[] aux;

        public static void sort(Comparable[] a, int cutoff) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1, cutoff);
        }

        private static void sort(Comparable[] a, int lo, int hi, int cutoff) {
            if (hi <= lo + cutoff - 1) {
                Insertion.sort(a, lo, hi);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid, cutoff);
            sort(a, mid + 1, hi, cutoff);
            if (!less(a[mid + 1], a[mid])) return;
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
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
            return v.compareTo(w) < 0;
        }
    }

    private static class Insertion {
        public static void sort(Comparable[] a, int lo, int hi) {
            for (int i = lo; i <= hi; i++) {
                for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
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
    }
}
/*
approximately 30

Size: 1000, Cutoff: 5, Time: 2 ms
Size: 1000, Cutoff: 10, Time: 0 ms
Size: 1000, Cutoff: 20, Time: 0 ms
Size: 1000, Cutoff: 33, Time: 0 ms
Size: 1000, Cutoff: 40, Time: 0 ms
Size: 1000, Cutoff: 80, Time: 0 ms
Size: 1000, Cutoff: 100, Time: 0 ms
Size: 1000, Cutoff: 200, Time: 1 ms
Size: 1000, Cutoff: 400, Time: 3 ms
Size: 2000, Cutoff: 5, Time: 0 ms
Size: 2000, Cutoff: 10, Time: 0 ms
Size: 2000, Cutoff: 20, Time: 0 ms
Size: 2000, Cutoff: 33, Time: 0 ms
Size: 2000, Cutoff: 40, Time: 0 ms
Size: 2000, Cutoff: 80, Time: 1 ms
Size: 2000, Cutoff: 100, Time: 1 ms
Size: 2000, Cutoff: 200, Time: 0 ms
Size: 2000, Cutoff: 400, Time: 1 ms
Size: 4000, Cutoff: 5, Time: 1 ms
Size: 4000, Cutoff: 10, Time: 1 ms
Size: 4000, Cutoff: 20, Time: 0 ms
Size: 4000, Cutoff: 33, Time: 1 ms
Size: 4000, Cutoff: 40, Time: 1 ms
Size: 4000, Cutoff: 80, Time: 1 ms
Size: 4000, Cutoff: 100, Time: 0 ms
Size: 4000, Cutoff: 200, Time: 0 ms
Size: 4000, Cutoff: 400, Time: 0 ms
Size: 8000, Cutoff: 5, Time: 2 ms
Size: 8000, Cutoff: 10, Time: 2 ms
Size: 8000, Cutoff: 20, Time: 2 ms
Size: 8000, Cutoff: 33, Time: 1 ms
Size: 8000, Cutoff: 40, Time: 2 ms
Size: 8000, Cutoff: 80, Time: 1 ms
Size: 8000, Cutoff: 100, Time: 2 ms
Size: 8000, Cutoff: 200, Time: 2 ms
Size: 8000, Cutoff: 400, Time: 2 ms
Size: 16000, Cutoff: 5, Time: 4 ms
Size: 16000, Cutoff: 10, Time: 4 ms
Size: 16000, Cutoff: 20, Time: 3 ms
Size: 16000, Cutoff: 33, Time: 3 ms
Size: 16000, Cutoff: 40, Time: 3 ms
Size: 16000, Cutoff: 80, Time: 4 ms
Size: 16000, Cutoff: 100, Time: 5 ms
Size: 16000, Cutoff: 200, Time: 4 ms
Size: 16000, Cutoff: 400, Time: 4 ms
Size: 32000, Cutoff: 5, Time: 17 ms
Size: 32000, Cutoff: 10, Time: 4 ms
Size: 32000, Cutoff: 20, Time: 3 ms
Size: 32000, Cutoff: 33, Time: 3 ms
Size: 32000, Cutoff: 40, Time: 4 ms
Size: 32000, Cutoff: 80, Time: 3 ms
Size: 32000, Cutoff: 100, Time: 3 ms
Size: 32000, Cutoff: 200, Time: 5 ms
Size: 32000, Cutoff: 400, Time: 7 ms
Size: 64000, Cutoff: 5, Time: 7 ms
Size: 64000, Cutoff: 10, Time: 8 ms
Size: 64000, Cutoff: 20, Time: 7 ms
Size: 64000, Cutoff: 33, Time: 8 ms
Size: 64000, Cutoff: 40, Time: 7 ms
Size: 64000, Cutoff: 80, Time: 8 ms
Size: 64000, Cutoff: 100, Time: 11 ms
Size: 64000, Cutoff: 200, Time: 11 ms
Size: 64000, Cutoff: 400, Time: 14 ms
 */
