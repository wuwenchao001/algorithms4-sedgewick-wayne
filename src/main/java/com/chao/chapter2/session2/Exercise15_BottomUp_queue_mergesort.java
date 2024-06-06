package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.Queue;

/**
 * 2.2.15 Bottom-up queue mergesort.
 * Develop a bottom-up mergesort implementation based on the following approach: G
 * iven N items, create N queues, each containing one of the items.
 * Create a queue of the N queues.
 * Then repeatedly apply the merging operation of Exercise 2.2.14 to the first two queues
 * and reinsert the merged queue at the end.
 * Repeat until the queue of queues contains only one queue.
 */
public class Exercise15_BottomUp_queue_mergesort {

    public static class BottomUpQueueMergeSort {
        public static Queue<Comparable> sort(Comparable[] items) {
            Queue<Queue<Comparable>> queues = new Queue<Queue<Comparable>>();

            // Step 1: Create N queues, each containing one of the items
            for (Comparable item : items) {
                Queue<Comparable> singleItemQueue = new Queue<Comparable>();
                singleItemQueue.enqueue(item);
                queues.enqueue(singleItemQueue);
            }

            // Step 2: Repeatedly merge the first two queues and reinsert the merged queue at the end
            while (queues.size() > 1) {
                Queue<Comparable> q1 = queues.dequeue();
                Queue<Comparable> q2 = queues.dequeue();
                Queue<Comparable> merged = MergeQueues.merge(q1, q2);
                queues.enqueue(merged);
            }

            // Step 3: The queue of queues contains only one queue, return it
            return queues.dequeue();
        }
    }

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
        // Create an array of unsorted integers
        Integer[] items = {5, 1, 9, 3, 7, 6, 8, 2, 4, 0};

        // Sort the array using bottom-up queue mergesort
        Queue<Comparable> sorted = BottomUpQueueMergeSort.sort(items);

        // Print the sorted items
        for (Comparable item : sorted) {
            System.out.println(item);
        }
    }
}
