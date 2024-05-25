package com.chao.chapter2.session1;

import java.util.Arrays;

public class Exercise16_certification {
    public static void main(String[] args) {
        Integer[] integers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        boolean result = check(integers);
        System.out.println("Is the array sorted and preserves the set of objects? " + result);
    }

    public static boolean check(Comparable[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        Comparable[] original = Arrays.copyOf(array, array.length);

        Arrays.sort(array);

//        Arrays.stream(original).iterator().forEachRemaining(System.out::print);
//        System.out.println();
//        Arrays.stream(array).iterator().forEachRemaining(System.out::print);
//        System.out.println();

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                return false;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (containObject(original, array[i])) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean containObject(Comparable[] array, Comparable target) {
        int existence = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) {
                existence++;
                break;
            }
        }
        return existence > 0;
    }
}
