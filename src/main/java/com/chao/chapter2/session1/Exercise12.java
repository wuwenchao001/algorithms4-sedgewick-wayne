package com.chao.chapter2.session1;

import java.util.Random;

public class Exercise12 {

    public static void sort(Double[] arr) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; // This is an example of a gap sequence

        for (int gapIndex = 0; gapIndex < gaps.length; gapIndex++) {
            int gap = gaps[gapIndex];
            int compares = 0;
            for (int i = gap; i < arr.length; i++) {
                Double temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                    compares++;
                }
                arr[j] = temp;
            }
            System.out.println("Gap: " + gap + ", Compares/Array Size: " + (double) compares / arr.length);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 2; i <= 6; i++) {
            int size = (int) Math.pow(10, i);
            Double[] arr = new Double[size];
            for (int j = 0; j < size; j++) {
                arr[j] = rand.nextDouble();
            }
            System.out.println("Array Size: " + size);
            sort(arr);
            System.out.println();
        }
    }

}
