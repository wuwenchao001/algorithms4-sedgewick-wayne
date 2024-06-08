package com.chao.chapter2.session1.util;

import java.util.Arrays;

public class Shell_with_half_gap {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                int temp = arr[i];

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100]; // replace with your array
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
