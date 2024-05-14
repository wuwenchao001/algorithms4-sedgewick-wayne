package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise3_intermixed_sequence {
    public static void main(String[] args) throws IOException {
        int[][] testNumberLists = readNumbers();
        testSequence(testNumberLists);
    }

    /**
     * read 8 lines of numbers from "Exercise3.txt"
     */
    private static int[][] readNumbers() throws IOException {
        String fileName = "src/main/java/com/chao/chapter1/session3/Exercise3.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            int[][] a = new int[8][10];
            int lineNum = 0;
            while (line != null) {
                String[] oneLineNumbers;
                oneLineNumbers = line.split(" ");
                for (int i = 1; i <= 10; i++) {
                    a[lineNum][i - 1] = Integer.parseInt(oneLineNumbers[i]);
                }
                lineNum++;
                line = br.readLine();
            }
            return a;
        }
    }

    private static void testSequence(int[][] a) {
        for (int k = 0; k < 8; k++) {
            Stack<Integer> s = new Stack<>();

            int i = 0, j = 0;
            while (i < 10 && j <= 10) {
                if (!s.isEmpty() && s.peek() == a[k][i]) {
                    StdOut.print(s.pop() + " ");
                    i++;
                } else {
                    if (j < 10) s.push(j);
                    j++;
                }
            }
            StdOut.printf("       %d unprinted: [ %s] %s \n", 10 - i, s, i == 10 && s.isEmpty());
        }
    }
}

