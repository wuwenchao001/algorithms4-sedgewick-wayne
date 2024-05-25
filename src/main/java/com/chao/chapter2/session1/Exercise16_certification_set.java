package com.chao.chapter2.session1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Exercise16_certification_set {


    // This method checks if the sort() method sorts the array correctly
    // and maintains the original set of objects.
    public static <T extends Comparable<? super T>> boolean check(T[] array) {
        // Convert the array to a set to keep track of the original elements.
        Set<T> originalSet = new HashSet<>(Arrays.asList(array));

        // Sort the array using the sort() method.
        sort(array);

        // Check if the array is sorted.
        boolean isSorted;
        isSorted = isSorted(array);

        // Check if the sorted array contains the same set of objects.
        Set<T> sortedSet = new HashSet<>(Arrays.asList(array));
        boolean isSameSet = sortedSet.equals(originalSet);

        // Return true if both checks pass.
        return isSorted && isSameSet;
    }

    // Dummy sort() method for demonstration purposes.
    // You should replace this with the actual sort() method you are using.
    private static <T> void sort(T[] array) {
        // This is a placeholder. Replace with your actual sorting logic.
        Arrays.sort(array);
    }

    // Helper method to check if the array is sorted.
    private static <T extends Comparable<? super T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false; // Array is not sorted.
            }
        }
        return true; // Array is sorted.
    }

    // Example usage
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 1, 2, 4, 56, 2};
        boolean result = check(numbers);
        System.out.println("Is the array sorted correctly and contains the same set of objects? " + result);
    }
}
