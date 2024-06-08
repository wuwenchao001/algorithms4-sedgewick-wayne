/**
 * Hypotheses:
 * Insertion Sort:
 * Insertion sort should perform relatively well on arrays with just two distinct keys.
 * This is because insertion sort performs a linear number of operations
 * when the array is already sorted or nearly sorted. In the case of two distinct keys,
 * the array is nearly sorted in a certain sense because there are only two possible values.
 * Therefore, we can expect the running time of insertion sort to be approximately linear in this case.
 * Selection Sort:
 * Selection sort performs poorly on nearly sorted arrays and well-sorted arrays
 * because it always makes a full pass over the remaining unsorted elements to find the smallest one,
 * regardless of the order of the elements.
 * Therefore, we can expect the running time of selection sort to be quadratic,
 * even for arrays with just two distinct keys.
 * Validate:
 * you can modify the SortCompare class to generate arrays with just two distinct keys
 * and measure the running times of insertion sort and selection sort.
 * Here's an example of how you can do it:
 */

package com.chao.chapter2.session1;

import com.chao.chapter2.session1.util.SortType;
import edu.princeton.cs.algs4.*;

public class Exercise28_equal_keys {

    public static void main(String[] args) {
        int N = 128;
        int T = 100; // number of trials

        while (N <= 1024) { // stop at 1024 for example
            StdOut.printf("Array size: %d\n", N);
            SortCompare.compare(SortType.INSERTION, SortType.SELECTION, N, T);
            N *= 2; // double the array size
        }
    }

    public static class SortCompare {
        public static void compare(SortType sortType1, SortType sortType2, int N, int T) {
            double t1 = timeRandomInput(sortType1, N, T);
            double t2 = timeRandomInput(sortType2, N, T);
            StdOut.printf("For %d random integers\n    %s is", N, sortType1);
            StdOut.printf(" %.1f times faster than %s\n", t2 / t1, sortType2);
        }

        public static double timeRandomInput(SortType sortType, int N, int T) {
            double total = 0.0;
            for (int t = 0; t < T; t++) {
                Double[] a = generateTwoKeyInput(N);
                total += time(sortType, a);
            }
            return total;
        }

        private static Double[] generateTwoKeyInput(int N) {
            Double[] a = new Double[N];
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform() < 0.5 ? 0.0 : 1.0;
            return a;
        }

        public static double time(SortType sortType, Double[] a) {
            Stopwatch timer = new Stopwatch();
            if (sortType == SortType.INSERTION) Insertion.sort(a);
            if (sortType == SortType.SELECTION) Selection.sort(a);
            if (sortType == SortType.SHELL) Shell.sort(a);

            return timer.elapsedTime();
        }

    }
}
