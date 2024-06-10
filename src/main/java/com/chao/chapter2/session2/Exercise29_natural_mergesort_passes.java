/*
I really don't understand what is meant by "passes" here.
Is it the number of passes？ or the number of successful merge passes?

Let's do it as merge passes.

For N = 1000, natural mergesort took 505 passes
For N = 1000000, natural mergesort took 499603 passes

For normal Merge, it should Merge 2N times, right?
 */
package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.29 Natural mergesort.
 * Determine empirically the number of passes needed in a natural mergesort (see Exercise 2.2.16)
 * for random Long keys with N=10^3, 10^6, and 10^9.
 * Hint: You do not need to implement a sort (or even generate full 64-bit keys) to complete this exercise.
 */
public class Exercise29_natural_mergesort_passes {

    public class NaturalMergeSort {
        public static int sort(Comparable[] items) {
            Queue<Queue<Comparable>> queues = new Queue<Queue<Comparable>>();
            int passes = 0;

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
                Queue<Comparable> merged = Exercise14_merging_sorted_queues.MergeQueues.merge(q1, q2);
                queues.enqueue(merged);
                passes++;
            }

            // Step 3: The queue of queues contains only one queue, return the number of passes
            return passes;
        }

        private static boolean less(Comparable v, Comparable w) {
            return v.compareTo(w) < 0;
        }
    }

    public static void main(String[] args) {
//        int[] sizes = {1000, 1000000, 1000000000};
        int[] sizes = {1000, 1000000};

        for (int N : sizes) {
            // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            //	at java.base/java.lang.Double.valueOf(Double.java:632)
            //
            // an array of size 10^9 may cause an OutOfMemoryError if your JVM does not have enough heap space.
            // You can increase the heap space using the -Xmx JVM option,
            // but the maximum amount of heap space you can allocate
            // depends on the physical memory available on your machine.
//            Long[] items = new Long[N];
//            for (int i = 0; i < N; i++) {
//                items[i] = (long) StdRandom.uniform();
//            }
            Double[] items = new Double[N];
            for (int i = 0; i < N; i++) {
                items[i] = StdRandom.uniform();
            }

            int passes = NaturalMergeSort.sort(items);
            System.out.printf("For N = %d, natural mergesort took %d passes\n", N, passes);
        }
    }
}