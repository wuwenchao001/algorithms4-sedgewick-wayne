package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortCompare_string_parameter;

public class Exercise25_insertion_sort_without_exchanges {
    public static void main(String[] args) {
        SortCompare_string_parameter.compare(new String[]{"InsertionSortWithoutExchanges", "Insertion", "100", "10"});
    }

    public class InsertionSortWithoutExchanges {
        public static void sort(Comparable[] a) {
            int N = a.length;
            for (int i = 1; i < N; i++) {
                Comparable key = a[i];
                int j = i;
                while (j > 0 && less(key, a[j - 1])) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = key;
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }
}
