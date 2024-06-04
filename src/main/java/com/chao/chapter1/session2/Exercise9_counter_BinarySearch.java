package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

/**
 * Instrument BinarySearch
 * to use a Counter to count the total number of keys examined during all searches
 * and then print the total after all searches are complete.
 * Hint : Create a Counter in main() and pass it as an argument to rank().
 */
public class Exercise9_counter_BinarySearch {

    public static void main(String[] args) {
        // Assume 'keys' and 'whitelist' are the arrays of keys and whitelist values
        int[] whitelist = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] keys = {10, 1, 5};

        Counter counter = new Counter("keys examined");
        for (int key : keys) {
            if (rank(key, whitelist, counter) == -1) {
                StdOut.println(key);
            }
        }
        StdOut.println();
        StdOut.println(counter);
    }

    public static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            counter.increment();  // Increment the counter each time a key is examined
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
