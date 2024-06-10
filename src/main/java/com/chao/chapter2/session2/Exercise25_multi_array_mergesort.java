package com.chao.chapter2.session2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Exercise25_multi_array_mergesort {


    public class MultiwayMergeSort {
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

        public static void sort(int[][] arrays) {
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.value));

            int totalSize = 0;
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length > 0) {
                    pq.add(new Node(i, 0, arrays[i][0]));
                    totalSize += arrays[i].length;
                }
            }

            int[] sortedArray = new int[totalSize];
            int currentIndex = 0;
            while (!pq.isEmpty()) {
                Node smallest = pq.poll();
                sortedArray[currentIndex++] = smallest.value;

                if (smallest.elementIndex + 1 < arrays[smallest.arrayIndex].length) {
                    pq.add(new Node(smallest.arrayIndex, smallest.elementIndex + 1,
                            arrays[smallest.arrayIndex][smallest.elementIndex + 1]));
                }
            }

            // Print the sorted array
            for (int i = 0; i < sortedArray.length; i++) {
                System.out.print(sortedArray[i] + " ");
            }
        }


    }

    public static void main(String[] args) {
        int[][] arrays = {
                {10, 15, 30, 40},
                {12, 15, 20},
                {17, 20, 32}
        };

        MultiwayMergeSort.sort(arrays);
    }
}
