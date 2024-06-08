package com.chao.chapter2.session2;

import java.util.Arrays;

/**
 * 2.2.20 Indirect sort.
 * Develop and implement a version of mergesort that does not rearrange the array,
 * but returns an int[] array perm such that perm[i] is the index of the i-th smallest entry in the array.
 */
public class Exercise20_indirect_sort {

    private static void merge(Comparable[] arr, int[] indices, int[] aux, int low, int mid, int high) {
        System.arraycopy(indices, low, aux, low, high - low + 1);

        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                indices[k] = aux[j++];
            } else if (j > high) {
                indices[k] = aux[i++];
            } else if (arr[aux[i]].compareTo(arr[aux[j]]) <= 0) {
                indices[k] = aux[i++];
            } else {
                indices[k] = aux[j++];
            }
        }
    }

    private static void sort(Comparable[] arr, int[] indices, int[] aux, int low, int high) {
        if (high <= low) return;

        int mid = low + (high - low) / 2;

        sort(arr, indices, aux, low, mid);
        sort(arr, indices, aux, mid + 1, high);
        merge(arr, indices, aux, low, mid, high);
    }

    public static int[] sort(Comparable[] arr) {
        int n = arr.length;
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        int[] aux = new int[n];
        sort(arr, indices, aux, 0, n - 1);

        return indices;
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 4, 1, 3, 5};
        int[] indices = sort(arr);
        System.out.println("Indices of sorted elements: " + Arrays.toString(indices));
    }
}
