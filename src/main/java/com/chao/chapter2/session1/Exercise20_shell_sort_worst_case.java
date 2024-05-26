package com.chao.chapter2.session1;

public class Exercise20_shell_sort_worst_case {
//}
//public class ShellSort {
    private static final int[] INCREMENTS = {40, 13, 4, 1};

    // Shell sort algorithm
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Iterate over the increments
        for (int h : INCREMENTS) {
            // Perform insertion sort with gap h
            for (int i = h; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > key) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = key;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];

        for (int i = 1; i <= 100; i++) {
            array[i-1] = i;
        }

        // Print the original array
        System.out.println("Original array:");
        printArray(array);

        // Sort the array using Shell sort
        shellSort(array);

        // Print the sorted array
        System.out.println("\nSorted array:");
        printArray(array);
    }

    // Utility method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

