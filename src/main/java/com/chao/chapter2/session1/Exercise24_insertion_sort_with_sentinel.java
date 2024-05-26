package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortCompare;

public class Exercise24_insertion_sort_with_sentinel {
    public static void main(String[] args) {
        SortCompare.compare(new String[]{"Insertion", "InsertionSortWithSentinel", "1000", "10"});
    }

    public class InsertionSortWithSentinel {
        public static void sort(Comparable[] a) {
            int N = a.length;
            int exchanges = 0;
            for (int i = N - 1; i > 0; i--) {
                if (less(a[i], a[i - 1])) {
                    exch(a, i, i - 1);
                    exchanges++;
                }
            }
            if (exchanges == 0) return;

            for (int i = 2; i < N; i++) {
                Comparable v = a[i];
                int j = i;
                while (less(v, a[j - 1])) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = v;
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable swap = a[i];
            a[i] = a[j];
            a[j] = swap;
        }
    }

}
