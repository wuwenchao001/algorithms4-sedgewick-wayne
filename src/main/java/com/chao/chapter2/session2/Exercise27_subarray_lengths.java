/*
The length of the other subarrays should be
a geometric sequence of numbers from 1 to N, with the common ratio of 2.

Like N = 100
subarray: 50, 25, 13, 7, 4, 2, 1

total length of the other subarray: 102
total counts of the other subarray: 7
when the first subarray exhausts, average length of the other subarray: 14
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.27 Subarray lengths.
 * Run mergesort for large random arrays,
 * and make an empirical determination of the average length of the other subarray
 * when the first subarray exhausts,
 * as a function of N (the sum of the two subarray sizes for a given merge).
 */
public class Exercise27_subarray_lengths {

    public static class MergesortWithAuxInMerge {
        private static int totalSubarraysLength = 0;
        private static int totalSubarraysCount = 0;

        public static void sort(Comparable[] a) {
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) {
                // when the first subarray exhausts
                int average = totalSubarraysLength / totalSubarraysCount;
                StdOut.println("total length of the other subarray: " + totalSubarraysLength);
                StdOut.println("total counts of the other subarray: " + totalSubarraysCount);
                StdOut.println("when the first subarray exhausts, average length of the other subarray: " + average);
                // stop the program here
                System.exit(0);
            }
            int mid = lo + (hi - lo) / 2;
            totalSubarraysCount++;
            totalSubarraysLength += mid - lo + 1;
            sort(a, lo, mid);
            totalSubarraysCount++;
            totalSubarraysLength += hi - mid + 1;
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        private static void merge(Comparable[] a, int lo, int mid, int hi) {
            Comparable[] aux = new Comparable[hi - lo + 1];

            for (int k = lo; k <= hi; k++) {
                aux[k - lo] = a[k];
            }

            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++ - lo];
                else if (j > hi) a[k] = aux[i++ - lo];
                else if (aux[j - lo].compareTo(aux[i - lo]) < 0) a[k] = aux[j++ - lo];
                else a[k] = aux[i++ - lo];
            }
        }

        public static void reset() {
            totalSubarraysLength = 0;
            totalSubarraysCount = 0;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = StdRandom.uniform(100);
        }
        MergesortWithAuxInMerge.sort(a);
    }
}
