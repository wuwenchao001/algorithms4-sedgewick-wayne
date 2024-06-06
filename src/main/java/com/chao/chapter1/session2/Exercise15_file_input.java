package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise15_file_input {

    public static void main(String... args) {
        int[] ints = readInts("src/main/java/com/chao/chapter1/session2/Exercise15_file_input.txt");

        for (int i : ints) {
            StdOut.print(i + " ");
        }
    }

    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }
}
