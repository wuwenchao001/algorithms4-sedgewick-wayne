package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise11_shell {
    public static void sort(int[] arr) {
        int[] gaps = {99, 57, 23, 10, 4, 1}; // This is an example of an increment gap sequence

        for (int gapIndex = 0; gapIndex < gaps.length; gapIndex++) {
            int gap = gaps[gapIndex];
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100]; // Let's use an array of integers as an example.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
