/*
Star: * * *

Use a custom linked list data structure that supports constant time removals and insertions at both ends of the list.
This can be achieved by maintaining pointers to both the head and tail of the list,
and updating these pointers whenever nodes are added or removed.
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.18 Shuffling a linked list.
 * Develop and implement a divide-and-conquer algorithm that randomly shuffles a linked list
 * in linearithmic time and logarithmic extra space.
 */
public class Exercise18_LinkedList_shuffling {


    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;

        void add(int val) {
            Node node = new Node(val);
            if (tail != null) {
                tail.next = node;
            } else {
                head = node;
            }
            tail = node;
        }

        int remove() {
            if (head == null) throw new RuntimeException("List is empty");
            int val = head.val;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return val;
        }

        boolean isEmpty() {
            return head == null;
        }

        int size() {
            int size = 0;
            for (Node node = head; node != null; node = node.next) {
                size++;
            }
            return size;
        }
    }

    public class LinkedListShuffle {

        public static void shuffle(LinkedList list) {
            if (list.size() <= 1)
                return;

            // Step 1: Divide the list into two halves
            LinkedList left = new LinkedList();
            LinkedList right = new LinkedList();
            int middle = list.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(list.remove());
            }
            while (!list.isEmpty()) {
                right.add(list.remove());
            }

            // Step 2: Recursively shuffle the two halves
            shuffle(left);
            shuffle(right);

            // Step 3: Merge the two halves by randomly interleaving their nodes
            while (!left.isEmpty() && !right.isEmpty()) {
                if (StdRandom.bernoulli()) {
                    list.add(left.remove());
                } else {
                    list.add(right.remove());
                }
            }
            while (!left.isEmpty()) {
                list.add(left.remove());
            }
            while (!right.isEmpty()) {
                list.add(right.remove());
            }
        }
    }

    public static void main(String[] args) {

        // Create a linked list with the elements 1, 2, 3, 4, 5, 6, 7
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }

        // Shuffle the list
        LinkedListShuffle.shuffle(list);

        // Print the shuffled list
        for (Node node = list.head; node != null; node = node.next) {
            StdOut.print(node.val + " ");
        }
        StdOut.println();
    }
}

/*
Proposition:

The time complexity of the shuffle algorithm is linearithmic (O(n log n))
and the extra space complexity is logarithmic (O(log n)).


Proof:

    Time Complexity:

The shuffle algorithm is a divide-and-conquer algorithm similar to merge sort.
It divides the linked list into two halves, recursively shuffles each half, and then merges the halves together.
The time complexity of this process can be described by the recurrence relation T(n) = 2T(n/2) + O(n),
where T(n) is the time complexity of shuffling a list of n elements.

The first term, 2T(n/2), represents the time to recursively shuffle the two halves of the list.
Each recursive call processes half of the elements of the current call,
so there are log n levels of recursion, and each level takes O(n) time, for a total of O(n log n) time.

The second term, O(n), represents the time to merge the shuffled halves together.
Merging involves iterating over all n elements of the list, so it takes O(n) time.

Therefore, the total time complexity of the shuffle algorithm is O(n log n) + O(n) = O(n log n).


    Space Complexity:

The extra space used by the shuffle algorithm is the space for the recursive call stack.
Each recursive call to the shuffle method creates a new level on the call stack,
and each level uses a constant amount of space to store its local variables (the left and right lists).

Because the shuffle method divides the list into two halves at each level of recursion,
the maximum depth of the recursion (and therefore the maximum size of the call stack) is log n.
Therefore, the extra space complexity of the shuffle algorithm is O(log n).
TODO: check the difference between the former Comparable[n], which is ~N space.
 */
