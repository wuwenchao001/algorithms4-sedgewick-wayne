package com.chao.chapter2.session1.util;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Page 259 ALGORITHM 2.3 Shellsortw
public class Shell_algorithm_2_3 {

    public static void sort(Comparable[] a) {  // Sort a[] into increasing order.
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1) {  // h-sort the array.
            for (int i = h; i < N; i++) {  // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                //
                //  Explain why local h-sort uses the insertion form:
                // The less-than condition is inside the for loop.
                // Because i increase (and j decrease).
                // Increasing i means that the previous part, starting from the beginning,
                // has been sequenced at a larger h interval, or at the current h interval.
                //
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            }
            h = h / 3;
        }
    }

    // See page 245 for less(), exch(), isSorted(), and main().
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {  // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {  // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {  // Read strings from standard input, sort them, and print.
        String[] a = StdIn.readLine().split("\\s");
        sort(a);
        assert isSorted(a);
        show(a);
    }

}

