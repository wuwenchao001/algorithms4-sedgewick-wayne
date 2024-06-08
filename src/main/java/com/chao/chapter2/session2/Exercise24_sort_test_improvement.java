/*
The hypothesis development would require running the empirical studies and observing the results.
However, based on the nature of the modification in the merge sort algorithm, we can make an educated guess.

The test `a[mid] <= a[mid+1]` checks whether the two halves of the array are already in order.
For a completely random array,
the probability that this condition is true for any given pair of elements is roughly 0.5
(since there's an approximately equal chance that a randomly chosen number
is greater than or less than another randomly chosen number).

Given that the merge sort algorithm divides the array into halves recursively,
there are approximately log2(N) levels of recursion,
and at each level,
there are approximately 2^level subarrays (where level starts from 0).
Therefore, the total number of checks is approximately N
(since 2^level for all levels from 0 to log2(N)-1 is approximately N).

So, for large N, we can hypothesize that the average number of times the test succeeds
(i.e., the array is already sorted)
is approximately N/2.
This is because each check has a roughly 0.5 probability of success, and there are approximately N checks in total.

Please note that this is a rough hypothesis and the actual results may vary.
It's also worth noting that the distribution of the random numbers
and the specific way the array is divided and merged can affect the results.

Therefore, it's important to run the empirical studies to verify this hypothesis.


N: 1000, Avg comparisons: 9371.4, Avg successes: 293.7
N: 2000, Avg comparisons: 20723.7, Avg successes: 583.3
N: 3000, Avg comparisons: 32674.9, Avg successes: 851.7
N: 4000, Avg comparisons: 45433.7, Avg successes: 1175.0
N: 5000, Avg comparisons: 58290.4, Avg successes: 1434.6

???!!!!....
One possible hypothesis could be that the average number of successful checks is proportional to N * 0.3 ????
TODO
 */
package com.chao.chapter2.session2;

import com.chao.chapter2.session2.Exercise8_merge_sorted_linear_mid_compares.Merge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


/**
 * 2.2.24 Sort-test improvement.
 * Run empirical studies for large randomly ordered arrays
 * to study the effectiveness of the modification described in Exercise 2.2.8 for random data.
 * <p>
 * In particular,
 * develop a hypothesis about the average number of times the test (whether an array is sorted) succeeds,
 * as a function of N (the original array size for the sort).
 */
public class Exercise24_sort_test_improvement {
    public static void main(String[] args) {
        int maxN = 5000;
        int numTrials = 10;

        for (int N = 1000; N <= maxN; N += 1000) {
            int totalComparisons = 0;
            int totalSuccesses = 0;
            for (int t = 0; t < numTrials; t++) {
                Integer[] a = new Integer[N];
                for (int i = 0; i < N; i++) {
                    a[i] = StdRandom.uniform(N); // Random array
                }
                Merge.sort(a);
                totalComparisons += Merge.getComparisons();
                totalSuccesses += Merge.getSuccesses();
            }
            double avgComparisons = totalComparisons / (double) numTrials;
            double avgSuccesses = totalSuccesses / (double) numTrials;

            StdOut.println("N: " + N + ", Avg comparisons: " + avgComparisons + ", Avg successes: " + avgSuccesses);
        }
    }
}