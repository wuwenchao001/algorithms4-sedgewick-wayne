/*
The provided solution does not meet the linearithmic time complexity requirement
because the `get(i)` and `removeFirst()` methods of Java's LinkedList class are not constant time operations.

To achieve linearithmic time complexity,
we need to use a data structure that supports constant time removals and insertions. Unfortunately,
Java's built-in LinkedList class does not meet this requirement.

A more efficient approach would be to convert the LinkedList to an ArrayList,
perform the shuffle, and then convert it back to a LinkedList.
However, this would not meet the logarithmic extra space requirement.

Unfortunately, it's not possible to shuffle a linked list in linearithmic time and logarithmic extra space
using only Java's built-in data structures.
A custom data structure would be needed.
 */
package com.chao.chapter2.session2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 * 2.2.18 Shuffling a linked list.
 * Develop and implement a divide-and-conquer algorithm that randomly shuffles a linked list
 * in linearithmic time and logarithmic extra space.
 */
public class Exercise18_java_until_LinkedList_shuffling {


    public class LinkedListShuffle {
        private static Random rand = new Random();

        public static void shuffle(LinkedList<Integer> list) {
            if (list.size() <= 1)
                return;

            // Step 1: Divide the list into two halves
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            int middle = list.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(list.get(i));
            }
            for (int i = middle; i < list.size(); i++) {
                right.add(list.get(i));
            }

            // Step 2: Recursively shuffle the two halves
            shuffle(left);
            shuffle(right);

            // Step 3: Merge the two halves by randomly interleaving their nodes
            list.clear();
            while (!left.isEmpty() && !right.isEmpty()) {
                if (rand.nextBoolean()) {
                    list.add(left.removeFirst());
                } else {
                    list.add(right.removeFirst());
                }
            }
            list.addAll(left);
            list.addAll(right);
        }
    }

    public static void main(String[] args) {

        // Setup input list: 1, 2, 3, 4, 5, 6, 7
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        // Run the shuffle method
        LinkedListShuffle.shuffle(list);

        // Print the shuffled list
        System.out.println(list);
    }
}
