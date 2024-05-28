package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortCompare;
import com.chao.chapter2.session1.utils.SortType;
import edu.princeton.cs.algs4.StdOut;

public class Exercise29_shell_sort_increments {
    public static void main(String[] args) {
        SortCompare.compare(SortType.SHELLSORT_INCREMENT,SortType.SHELL_2_3, 100000, 3);
    }


    public class ShellSort_increment {

        public static void sort(Comparable[] a) {
            int N = a.length;
            int[] increments = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
            int hIndex = increments.length - 1;

            while (hIndex >= 0 && increments[hIndex] >= N) {
                hIndex--;
            }

            while (hIndex >= 0) {
                int h = increments[hIndex];
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                        exch(a, j, j - h);
                }
                hIndex--;
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

        private static void show(Comparable[] a) {
            for (int i = 0; i < a.length; i++)
                StdOut.print(a[i] + " ");
            StdOut.println();
        }

        public static boolean isSorted(Comparable[] a) {
            for (int i = 1; i < a.length; i++)
                if (less(a[i], a[i - 1])) return false;
            return true;
        }
    }
}