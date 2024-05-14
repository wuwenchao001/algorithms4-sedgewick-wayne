package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise45_stack_generability {
    // seems similar to 1.3.3
    public static void main(String[] args) {
        String s = "1 2 3 - 4 - - 5 - - - - -";
        StdOut.printf("Whether sequence '%s' cause overflow: %s \n", s, willCauseUnderflow(s));

        String permutation = "9 13 16";
        StdOut.println("Can '" + permutation + "' be generated? Expect true: " + isGeneratedPermutation(permutation));
        permutation = "5 4 3 2 1 0 9 8 7 6";
        StdOut.println("Can '" + permutation + "' be generated? Expect true: " + isGeneratedPermutation(permutation));
        permutation = "5 4 6 8 7 3 2 9 0 1";        // forbidden triple "9 0 1"
        StdOut.println("Can '" + permutation + "' be generated? Expect false: " + isGeneratedPermutation(permutation));
        permutation = "16 9 13";                    // forbidden triple "16 9 13"
        StdOut.println("Can '" + permutation + "' be generated? Expect false: " + isGeneratedPermutation(permutation));
    }

    private static boolean willCauseUnderflow(String s) {
        int indicator = 0;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            // use ".equals()", but not "=="
            if (split[i].equals("-")) indicator--;
            else indicator++;
        }
        return indicator < 0;
    }

    public static boolean isGeneratedPermutation(String permutation) {
        String[] split = permutation.split(" ");
        int length = split.length;

        int maxInt = 0;
        int[] integers = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            integers[i] = Integer.parseInt(split[i]);
        }
        // the max interger in the intergers array
        for (int integer : integers) {
            maxInt = Math.max(maxInt, integer);
        }

        int i = 0, j = 0;
        while (i < length && j <= maxInt + 1) {
            if (!stack.isEmpty() && stack.peek() == integers[i]) {
                stack.pop();
                i++;
            } else {
                if (j < maxInt + 1) stack.push(j);
                j++;
            }
        }

        return i == length;
    }
}
