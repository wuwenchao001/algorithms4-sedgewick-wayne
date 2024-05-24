package com.chao.chapter2.session1;

import java.util.Arrays;
import java.util.Comparator;

public class Exercise16_certification {
    public static boolean check(Object[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        Object[] original = Arrays.copyOf(array, array.length);

        Arrays.sort(array, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                // Assuming the objects implement Comparable
                // Otherwise, you'd need a different way to compare them
                if (o1 instanceof Comparable && o2 instanceof Comparable) {
                    Comparable c1 = (Comparable) o1;
                    Comparable c2 = (Comparable) o2;
                    return c1.compareTo(c2);
                } else {
                    throw new ClassCastException("Objects must implement Comparable");
                }
            }
        });

        // Check if the sorted array contains the same elements in the same relative order
        for (int i = 0; i < array.length; i++) {
            // If the elements are not equal or the original is not found in the sorted array, return false
            if (!containsInOrder(original, array[i], i)) {
                return false;
            }
        }

        // All elements are found in the same relative order
        return true;
    }

    private static boolean containsInOrder(Object[] array, Object target, int index) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                // If we found the target, check if it's in the same relative position or earlier
                if (i <= index) {
                    return true;
                } else {
                    // If the target is found later, it violates the relative order
                    return false;
                }
            }
        }
        // If the target is not found, it violates the set of objects
        return false;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5}; // {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        boolean result = check(integers);
        System.out.println("Is the array sorted and preserves the set of objects? " + result);
    }

}
