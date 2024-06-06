package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * 2.2.14 Merging sorted queues.
 * Develop a static method that takes two queues of sorted items as arguments
 * and returns a queue that results from merging the queues into sorted order.
 */
public class Exercise14_merging_sorted_queues {

    public static class MergeQueues {
        public static Queue<Comparable> merge(Queue<Comparable> q1, Queue<Comparable> q2) {
            Queue<Comparable> result = new Queue<Comparable>();

            while (!q1.isEmpty() && !q2.isEmpty()) {
                if (less(q1.peek(), q2.peek())) {
                    result.enqueue(q1.dequeue());
                } else {
                    result.enqueue(q2.dequeue());
                }
            }

            while (!q1.isEmpty()) {
                result.enqueue(q1.dequeue());
            }

            while (!q2.isEmpty()) {
                result.enqueue(q2.dequeue());
            }

            return result;
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
        // Generate two sorted queues.
        Queue<Comparable> q1 = new Queue<Comparable>();
        Queue<Comparable> q2 = new Queue<Comparable>();

        // Populate the first queue with sorted integers
        for (int i = 0; i < 10; i += 1) {
            q1.enqueue(2 * i +1);
        }

        // Populate the second queue with sorted integers
        for (int i = 0; i < 10; i += 1) {
            q2.enqueue(2 * i);
        }

        // Merge the two queues
        Queue<Comparable> result = MergeQueues.merge(q1, q2);

        // Print the result
        for (Comparable item : result) {
            StdOut.println(item);
        }

    }
}
