package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Random;

public class Exercise18_visual_trace_chatGPT {
    //}
//public class SortAnimation {
    private static final int ARRAY_SIZE = 50; // Adjust the array size as needed
    private static final double CANVAS_WIDTH = 800.0;
    private static final double CANVAS_HEIGHT = 800.0;
    private static final double TRACE_HEIGHT = 200.0; // Height reserved for visual traces
    private static final Color DEFAULT_COLOR = Color.BLUE;
    private static final Color HIGHLIGHT_COLOR = Color.RED;
    private static final Color ACCENT_COLOR = Color.GRAY;

    // Generate an array of random double values
    private static double[] generateRandomArray(int size) {
        Random rand = new Random();
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextDouble();
        }
        return arr;
    }

    // Show the array contents as vertical bars with visual traces
    private static void show(double[] arr, int i, int j) {
        StdDraw.clear();
        StdDraw.setXscale(0, arr.length);
        StdDraw.setYscale(0, 1.0 + TRACE_HEIGHT / CANVAS_HEIGHT);

        // Draw visual traces
        StdDraw.setPenColor(ACCENT_COLOR);
        for (int k = 0; k < arr.length; k++) {
            StdDraw.line(k, 0, k, arr[k] * TRACE_HEIGHT / 2.0);
        }

        // Draw bars
        for (int k = 0; k < arr.length; k++) {
            Color color = (k == i || k == j) ? HIGHLIGHT_COLOR : DEFAULT_COLOR;
            StdDraw.setPenColor(color);
            StdDraw.filledRectangle(k + 0.5, arr[k] / 2.0, 0.4, arr[k] / 2.0);
        }
        StdDraw.show();
    }

    // Insertion sort with animation
    public static void insertionSort(double[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                double temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                show(arr, j - 1, j); // Show array after each swap, highlighting the swapped items
            }
        }
    }

    // Selection sort with animation
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            show(arr, i, minIndex); // Show array after each swap, highlighting the swapped items
        }
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize((int) CANVAS_WIDTH, (int) CANVAS_HEIGHT);
        double[] arr = generateRandomArray(ARRAY_SIZE);
        // Uncomment one of the following lines to sort the array using either Insertion or Selection sort
        //insertionSort(arr);
        selectionSort(arr);
    }
}
