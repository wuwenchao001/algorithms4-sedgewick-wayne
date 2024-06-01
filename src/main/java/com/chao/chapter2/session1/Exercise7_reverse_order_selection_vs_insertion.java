/****************************
 * For an array in reverse order, Selection sort is generally faster.
 *
 * Selection sort doesn't take into account the order of the array.
 * It always makes N^2/2 comparisons and N exchanges, regardless of the initial order of the array.
 *
 * Insertion sort's running time depends on the initial order of the array.
 * For an array in reverse order, it makes ~N^2/2 comparisons and ~N^2/2 exchanges.
 *
 * @Result
 *     Selection sort time: 3 ms
 *     Insertion sort time: 6 ms
 ***********************/
package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

/**
 * Test which method runs faster for an array in reverse order, selection sort or insertion sort?
 */
public class Exercise7_reverse_order_selection_vs_insertion {
    public static void testSorts() {
        int N = 512;
        Integer[] a = new Integer[N];
        Integer[] b = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = N - i; // Reverse order
            b[i] = N - i; // Reverse order
        }

        long start = System.currentTimeMillis();
        Selection.sort(a);
        long end = System.currentTimeMillis();
        System.out.println("Selection sort time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Insertion.sort(b);
        end = System.currentTimeMillis();
        System.out.println("Insertion sort time: " + (end - start) + " ms");

    }

    /**
     * Unit test {@link #testSorts()}
     */
    public static void main() {
        testSorts();
    }
}
