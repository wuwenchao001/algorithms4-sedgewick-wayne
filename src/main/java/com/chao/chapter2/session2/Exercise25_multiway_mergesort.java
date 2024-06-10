package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/*
2.2.25 Multiway mergesort.
Develop a mergesort implementation based on the idea of doing k-way merges (rather than 2-way merges).
Analyze your algorithm,
develop a hypothesis regarding the best value of k, and run experiments to validate your hypothesis.
 */
public class Exercise25_multiway_mergesort {

    private static class Node {
        private int arrayIndex;
        private int elementIndex;
        private int value;

        public Node(int arrayIndex, int elementIndex, int value) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
            this.value = value;
        }
    }

    public static void sort(int[] array, int k) {
        if (k <= 1) {
            return;
        }

        int length = array.length;
        int partSize = (length + k - 1) / k;
        int[][] parts = new int[k][];

        // Divide the array into k parts and sort each part recursively
        for (int i = 0; i < k; i++) {
            int start = i * partSize;
            // check to ensure that start is less than length before creating a partition
            // ensure the size of the array is less than k
            if (start < length) {
                int end = Math.min(start + partSize, length);
                int[] part = Arrays.copyOfRange(array, start, end);
                if (part.length > 1) { // Recursively calling itself with a proper base case to stop the recursion.
                    sort(part, k);
                    // Avoid: This leads to an infinite recursion, causing a StackOverflowError.
                    // Checks if the length of the part is greater than 1 before calling itself recursively.
                    // This ensures that the recursion stops when the part contains only one element,
                    // preventing a StackOverflowError.
                }
                parts[i] = part;
            }
        }

        // Merge the sorted parts using a priority queue
        // The priority queue is a data structure that always keeps the smallest element at the top
        // (assuming it's a min-heap).
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));
        for (int i = 0; i < k; i++) {
            // checks if parts[i] is not null before accessing its length.
            // This ensures that the NullPointerException does not occur when the array size is less than k.
            if (parts[i] != null && parts[i].length > 0) {
                pq.add(new Node(i, 0, parts[i][0]));
            }
        }

        int index = 0;
        while (!pq.isEmpty()) {
            Node smallest = pq.poll(); //removes and returns the smallest element from the priority queue
            array[index++] = smallest.value;

            //checks if there are more elements in the array from which the smallest element came.
            // If there are, it adds the next element from that array to the priority queue.
            if (smallest.elementIndex + 1 < parts[smallest.arrayIndex].length) {
                pq.add(new Node(smallest.arrayIndex, smallest.elementIndex + 1,
                        parts[smallest.arrayIndex][smallest.elementIndex + 1]));
            }
        }
    }

    public static void main(String[] args) {
        int[] ks = {2, 3, 4, 5, 10, 20};
        int[] ns = {1000, 10000, 100000, 1000000};
        Random rand = new Random();

        for (int k : ks) {
            for (int n : ns) {
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    array[i] = rand.nextInt(n);
                }

                long start = System.currentTimeMillis();
                sort(array, k);
                long end = System.currentTimeMillis();

                StdOut.println("k = " + k + ", n = " + n + ", time = " + (end - start) + " ms");
            }
        }
    }
}
