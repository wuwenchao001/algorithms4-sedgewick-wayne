package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
    private static void insertionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
                Comparable temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
            // print temporary arry
            for (int i1 = 0; i1 < a.length; i1++) {
                StdOut.print(a[i1]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        Character[] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        insertionSort(a);
    }
}
/**
 * EASYQUESTION
 * AESYQUESTION
 * AESYQUESTION
 * AESYQUESTION
 * AEQSYUESTION
 * AEQSUYESTION
 * AEEQSUYSTION
 * AEEQSSUYTION
 * AEEQSSTUYION
 * AEEIQSSTUYON
 * AEEIOQSSTUYN
 * AEEINOQSSTUY
 */
