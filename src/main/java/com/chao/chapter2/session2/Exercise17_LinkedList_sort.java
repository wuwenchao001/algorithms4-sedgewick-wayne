package com.chao.chapter2.session2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 2.2.17 Linked-list sort.
 * Implement a natural mergesort for linked lists.
 * (This is the method of choice for sorting linked lists
 * because it uses no extra space and is guaranteed to be linearithmic.)
 */
public class Exercise17_LinkedList_sort {


    public class NaturalMergeSort {
        public static LinkedList<Integer> naturalMergeSort(LinkedList<Integer> list) {
            if (list.size() <= 1)
                return list;

            int middle = list.size() / 2;
            LinkedList<Integer> left = new LinkedList<>(); // extra space
            LinkedList<Integer> right = new LinkedList<>(); // extra space

            for (int i = 0; i < middle; i++) {
                left.add(list.get(i));
            }

            for (int i = middle; i < list.size(); i++) {
                right.add(list.get(i));
            }

            return merge(naturalMergeSort(left), naturalMergeSort(right));
        }

        private static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
            LinkedList<Integer> result = new LinkedList<>();

            while (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() <= right.peek()) {
                    result.add(left.remove());
                } else {
                    result.add(right.remove());
                }
            }

            result.addAll(left);
            result.addAll(right);

            return result;
        }
    }

    public static void main(String[] args) {

        // Setup input list: 4 -> 2 -> 1 -> 3...
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(4, 2, 1, 3, 9, 5, 8, 6, 7, 6));

        // Run the naturalMergeSort method
        LinkedList<Integer> sortedList = NaturalMergeSort.naturalMergeSort(list);

        // Check the sorted list: 1 -> 2 -> 3 -> 4...
        assert Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 8, 9) == sortedList;
    }
}
