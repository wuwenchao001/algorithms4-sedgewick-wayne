package com.chao.chapter2.session2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise {
    public static void main(String[] args) {
        // generate a random int[100]
        Integer[] array = new Integer[100];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }
        Arrays.stream(array).forEach(StdOut::print);
    }
}
