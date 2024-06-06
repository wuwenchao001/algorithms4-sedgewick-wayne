/*
The running time of this algorithm is proportional to N (the array size)
plus the number of maximal increasing sequences in the array.

This is because each merge operation takes time proportional to the size of the sequences being merged,
and the total size of all sequences is N.
The number of merge operations is equal to the number of maximal increasing sequences minus 1.
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.Queue;

/**
 * 2.2.16
 * Natural mergesort.
 * Write a version of bottom-up mergesort that takes advantage of order in the array
 * by proceeding as follows
 * each time it needs to find two arrays to merge: find a sorted subarray
 * (by incrementing a pointer until finding an entry that is smaller than its predecessor in the array),
 * then find the next, then merge them.
 * <p>
 * Analyze the running time of this algorithm in terms of the array size
 * and the number of maximal increasing sequences in the array.
 */
public class Exercise16_natural_mergesort {

    /**
     * use queue
     */
    public class NaturalMergeSort {
        public static Queue<Comparable> sort(Comparable[] items) {
            Queue<Queue<Comparable>> queues = new Queue<Queue<Comparable>>();

            // Step 1: Create queues for each sorted subarray
            int i = 0;
            while (i < items.length) {
                Queue<Comparable> sortedSubarray = new Queue<Comparable>();
                do {
                    sortedSubarray.enqueue(items[i]);
                    i++;
                } while (i < items.length && less(items[i - 1], items[i]));
                queues.enqueue(sortedSubarray);
            }

            // Step 2: Repeatedly merge the first two queues and reinsert the merged queue at the end
            while (queues.size() > 1) {
                Queue<Comparable> q1 = queues.dequeue();
                Queue<Comparable> q2 = queues.dequeue();
                Queue<Comparable> merged = MergeQueues.merge(q1, q2);
                queues.enqueue(merged);
                /*
                Here is a problem that always merge with the bigger sorted "merged",
                as "merged" always firstly dequeued out.
                TODO: randomly merge two queue
                As the queue size is random, so sometimes "merged" is small continuously small.
                Just let it go.
                 */
            }

            // Step 3: The queue of queues contains only one queue, return it
            return queues.dequeue();
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    /**
     * Exercise 14
     */
    public class MergeQueues {
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

    /**
     * no queue
     */
    public class NaturalMergeSortNoQueue {
        public static void sort(Comparable[] items) {
            Comparable[] aux = new Comparable[items.length];

            int low = 0;
            while (low < items.length) {
                int mid = low;
                while (mid < items.length - 1 && less(items[mid], items[mid + 1])) {
                    mid++;
                }

                if (mid == items.length - 1) {
                    if (low != 0) {
                        merge(items, aux, 0, low - 1, mid);
                    }
                    break;
                }

                int high = mid + 1;
                while (high < items.length - 1 && less(items[high], items[high + 1])) {
                    high++;
                }

                merge(items, aux, low, mid, high);
                merge(items, aux, 0, low - 1, high);  // This line of code is also very time-consuming
                low = high + 1;
            }
        }

        private static void merge(Comparable[] items, Comparable[] aux, int low, int mid, int high) {
            for (int k = low; k <= high; k++) {
                aux[k] = items[k];
            }

            int i = low, j = mid + 1;
            for (int k = low; k <= high; k++) {
                if (i > mid) {
                    items[k] = aux[j++];
                } else if (j > high) {
                    items[k] = aux[i++];
                } else if (less(aux[j], aux[i])) {
                    items[k] = aux[j++];
                } else {
                    items[k] = aux[i++];
                }
            }
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
        // Create an array of unsorted integers
        Integer[] items = {5, 1, 9, 3, 7, 6, 8, 2, 4, 0};

        // Sort the array using bottom-up queue mergesort
        Queue<Comparable> sorted = NaturalMergeSort.sort(items);

        // Print the sorted items
        for (Comparable item : sorted) {
            System.out.println(item);
        }

        Integer[] items2 = {5, 1, 9, 3, 7, 6, 8, 2, 4, 0};
        NaturalMergeSortNoQueue.sort(items2);
        for (Comparable item : items2) {
            System.out.println(item);
        }
    }
}
