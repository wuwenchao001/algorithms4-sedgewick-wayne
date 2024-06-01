/**
 * Algorithm 2.1, how selection sort sorts the array E A S Y Q U E S T I O N
 * Answer: select the minimum one by one.
 */
package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1 {
    private static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min].compareTo(a[j]) > 0) min = j;
            }
            if (i != min) {
                Comparable v = a[i]; // may change a[i] many times in the i-th loop
                a[i] = a[min];
                a[min] = v;
            }
            // print current array
            for (int i1 = 0; i1 < a.length; i1++) {
                StdOut.print(a[i1]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        Character[] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        selectionSort(a);
    }
}
