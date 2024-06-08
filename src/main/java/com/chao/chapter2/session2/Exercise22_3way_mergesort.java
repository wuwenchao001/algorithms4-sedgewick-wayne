package com.chao.chapter2.session2;

import java.util.Arrays;

/**
 * 2.2.22 3-way mergesort.
 * Suppose instead of dividing in half at each step,
 * you divide into thirds, sort each third, and combine using a 3-way merge.
 * What is the order of growth of the overall running time of this algorithm?
 */
public class Exercise22_3way_mergesort {

    private static void merge(Comparable[] arr, Comparable[] aux, int low, int mid1, int mid2, int high) {
        int i = low, j = mid1, k = mid2;

        for (int m = low; m <= high; m++) {
            if (i >= mid1) {
                if (j >= mid2) {
                    aux[m] = arr[k++];
                } else if (k > high) {
                    aux[m] = arr[j++];
                } else if (arr[j].compareTo(arr[k]) <= 0) {
                    aux[m] = arr[j++];
                } else {
                    aux[m] = arr[k++];
                }
            } else if (j >= mid2) {
                if (arr[i].compareTo(arr[k]) <= 0) {
                    aux[m] = arr[i++];
                } else {
                    aux[m] = arr[k++];
                }
            } else if (k > high) {
                if (arr[i].compareTo(arr[j]) <= 0) {
                    aux[m] = arr[i++];
                } else {
                    aux[m] = arr[j++];
                }
            } else if (arr[i].compareTo(arr[j]) <= 0) {
                if (arr[i].compareTo(arr[k]) <= 0) {
                    aux[m] = arr[i++];
                } else {
                    aux[m] = arr[k++];
                }
            } else {
                if (arr[j].compareTo(arr[k]) <= 0) {
                    aux[m] = arr[j++];
                } else {
                    aux[m] = arr[k++];
                }
            }
        }

        System.arraycopy(aux, low, arr, low, high - low + 1);
    }

    private static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if (high <= low) return;

        int mid1 = low + (high - low) / 3;
        int mid2 = low + 2 * (high - low) / 3 + 1;

        sort(arr, aux, low, mid1);
        sort(arr, aux, mid1 + 1, mid2);
        sort(arr, aux, mid2 + 1, high);
        merge(arr, aux, low, mid1 + 1, mid2 + 1, high);
    }

    public static void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 4, 1, 3, 5};
        sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
/*
The order of growth of the running time of the 3-way mergesort algorithm is O(n log n),
where n is the number of elements in the array.

This is because the algorithm divides the array into three parts at each level,
and there are log3(n) levels (since we're dividing by 3 at each level).
At each level, a total of n elements are processed (since each element gets merged once per level).
Therefore, the total work done is proportional to n times log3(n), which simplifies to O(n log n) in Big O notation.

It's worth noting that the base of the logarithm does not change the order of growth when using Big O notation,
so we typically write O(n log n) instead of O(n log3(n)).
This is because loga(n) = logb(n) / logb(a),
so changing the base of the logarithm is equivalent to multiplying by a constant,
and in Big O notation, we ignore constant factors.
 */
