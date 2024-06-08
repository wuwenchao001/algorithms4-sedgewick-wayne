/**
 * Explain the recursive trickery:
 * The roles of the input array and the auxiliary array are switched at each level of recursion,
 * eliminating the need to copy the array before merging.
 * <p>
 * The key point here is that the merge() method always merges elements from the src array
 * and puts the sorted output in the dst array.
 * So, by switching the roles of src and dst at each level of recursion,
 * you ensure that the sorted output is always in the original array a,
 * and you don't need to copy elements to the auxiliary array before merging.
 */
package com.chao.chapter2.session2;

import com.chao.chapter2.session2.util.Merge_algorithm_2_4;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.2.23 Improvements.
 * Runempirical studies to evaluate the effectiveness of ??each?? of the three improvements to mergesort
 * that are described in the text (see Exercise 2.2.11).
 * Also,
 * compare the performance of the merge implementation given in the text with the merge described in Exercise 2.2.10.
 * In particular,
 * empirically determine the best value of the parameter
 * that decides when to switch to insertion sort for small subarrays.
 */
public class Exercise23_improvements_page275_evaluate {
    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 4000, 8000, 16000, 32000};
        for (int size : sizes) {
            Integer[] a = new Integer[size];
            for (int i = 0; i < size; i++) {
                a[i] = StdRandom.uniform(1000);
            }
            long startTime = System.currentTimeMillis();
            Exercise11_improvements_page275.Merge.sort(a);
            long endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time with improvements: " + (endTime - startTime) + " ms");

            for (int i = 0; i < size; i++) {
                a[i] = StdRandom.uniform(1000);
            }
            startTime = System.currentTimeMillis();
            Merge_algorithm_2_4.sort(a);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time without improvements: " + (endTime - startTime) + " ms");

            for (int i = 0; i < size; i++) {
                a[i] = StdRandom.uniform(1000);
            }
            startTime = System.currentTimeMillis();
            Exercise10_merge_faster.Merge.sort(a);
            endTime = System.currentTimeMillis();
            System.out.println("Size: " + size + ", Time with faster merge: " + (endTime - startTime) + " ms");
        }
    }
}
/*

Size: 1000, Time with improvements: 1 ms
Size: 1000, Time without improvements: 3 ms
Size: 1000, Time with faster merge: 1 ms
Size: 2000, Time with improvements: 0 ms
Size: 2000, Time without improvements: 0 ms
Size: 2000, Time with faster merge: 1 ms
Size: 4000, Time with improvements: 0 ms
Size: 4000, Time without improvements: 1 ms
Size: 4000, Time with faster merge: 1 ms
Size: 8000, Time with improvements: 1 ms
Size: 8000, Time without improvements: 2 ms
Size: 8000, Time with faster merge: 6 ms
Size: 16000, Time with improvements: 5 ms
Size: 16000, Time without improvements: 16 ms
Size: 16000, Time with faster merge: 12 ms
Size: 32000, Time with improvements: 9 ms
Size: 32000, Time without improvements: 32 ms
Size: 32000, Time with faster merge: 8 ms
 */

