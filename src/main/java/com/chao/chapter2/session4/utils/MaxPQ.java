package com.chao.chapter2.session4.utils;

// Page 318 ALGORITHM 2.6 Heap priority queue
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;             // heap-ordered complete binary tree
    private int N = 0;            //    in pq[1..N] with pq[0] unused

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];        // Retrieve max key from top.
        exch(1, N--);       // Exchange with last item.
        pq[N + 1] = null;     // Avoid loitering.
        sink(1);        // Restore heap property.
        return max;
    }


    // See pages 145-147 (page315-page316) for implementations of these helper methods.
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // Bottom-up reheapify (swim) implementation
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //Top-down reheapify (sink) implementation
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;  // choose the bigger one between j+1 and j
            if (!less(k, j)) break;              // whether k is larger than the bigger child
            exch(k, j);
            k = j;
        }
    }
}
