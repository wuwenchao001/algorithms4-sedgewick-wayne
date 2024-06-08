/*
Star: * * *

To count the number of inversions in an array,
we can use a divide-and-conquer approach
similar to the merge sort algorithm.
We divide the array into two halves, recursively count the inversions in each half,
and then count the inversions between the two halves while merging them together.

This implementation uses a helper method `mergeAndCount`
to merge two sorted halves of the array and count the inversions between them. A
n inversion is counted each time an element from the right half is placed before an element from the left half.
The `countAndSort` method recursively sorts the array and counts the inversions.
The `count` method provides a public interface for counting the inversions in an array.

The time complexity of this algorithm is O(n log n) and the extra space complexity is O(n),
where n is the number of elements in the array.
 */
package com.chao.chapter2.session2;

/**
 * 2.2.19 Inversions.
 * Develop and implement a linearithmic algorithm for computing the number of inversions in a given array
 * (the number of exchanges that would be performed by insertion sort for that array, see Section 2.1).
 * This quantity is related to the Kendall tau distance; see Section 2.5.
 */
public class Exercise19_inversions {

    private static long mergeAndCount(int[] arr, int[] aux, int low, int mid, int high) {
        System.arraycopy(arr, low, aux, low, high - low + 1);

        int i = low, j = mid + 1;
        long count = 0;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > high) {
                arr[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
                count += mid - i + 1;
            }
        }

        return count;
    }

    private static long countAndSort(int[] arr, int[] aux, int low, int high) {
        if (high <= low) return 0;

        int mid = low + (high - low) / 2;
        long count = 0;

        count += countAndSort(arr, aux, low, mid);
        count += countAndSort(arr, aux, mid + 1, high);
        count += mergeAndCount(arr, aux, low, mid, high);

        return count;
    }

    public static long count(int[] arr) {
        int[] aux = new int[arr.length];
        return countAndSort(arr, aux, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        long inversions = count(arr);
        System.out.println("Number of inversions: " + inversions);
    }
}
