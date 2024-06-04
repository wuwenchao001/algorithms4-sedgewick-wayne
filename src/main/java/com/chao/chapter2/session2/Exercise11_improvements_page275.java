/**
 * Explain the recursive trickery:
 * The roles of the input array and the auxiliary array are switched at each level of recursion,
 * eliminating the need to copy the array before merging.
 *
 * The key point here is that the merge() method always merges elements from the src array
 * and puts the sorted output in the dst array.
 * So, by switching the roles of src and dst at each level of recursion,
 * you ensure that the sorted output is always in the original array a,
 * and you don't need to copy elements to the auxiliary array before merging.
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.11 Improvements.
 * Implement the three improvements to mergesort that are described in the text on page 275:
 * (1) Add a cutoff for small subarrays,
 * (2) test whether the array is already in order,
 * (3) and avoid the copy by switching arguments in the recursive code.
 */
public class Exercise11_improvements_page275 {
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
            aux = a.clone(); // 这算不算copy,虽然不是lo到hi的小copy。
            sort(aux, a, 0, a.length - 1);
        }

        /**
         * The primary logic code for the solution.
         */
        private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
            if (hi - lo <= 10) {
                /// Improvement 1: Use insertion sort for small subarray[10].
                insertionSort(dst, lo, hi);
                return;
            }
            int mid = lo + (hi - lo) / 2;
            // Improvement 3: Eliminate the copy to the auxiliary array.
            //
            // The recursive calls such that the computation switches the roles of the src and dst at each level.
            sort(dst, src, lo, mid);
            sort(dst, src, mid + 1, hi);
            if (!less(src[mid+1], src[mid])) {
                // Improvement 2: Test whether the array is already in order.
                //
                // This arraycopy logic is a little differ from Exercise8.
                // Because two arrays are involved here.
                System.arraycopy(src, lo, dst, lo, hi - lo + 1);
                return;
            }
            merge(src, dst, lo, mid, hi);
        }

        private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
            int i = lo, j = mid+1;
            for (int k = lo; k <= hi; k++) {
                if      (i > mid)              dst[k] = src[j++];
                else if (j > hi)               dst[k] = src[i++];
                else if (less(src[j], src[i])) dst[k] = src[j++];
                else                           dst[k] = src[i++];
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void insertionSort(Comparable[] array, int low, int high) {
            for (int i = low; i <= high; i++) {
                for (int j = i; j > low && array[j - 1].compareTo(array[j]) > 0; j--) {
                    Comparable temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

