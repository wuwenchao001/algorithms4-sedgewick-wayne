package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.6
 * A string s is a circular rotation of a string t
 * if it matches when the characters are circularly shifted by any number of positions;
 * e.g., ACTGACG is a circular shift of TGACGAC,
 * and vice versa.
 * Detecting this condition is important in the study of genomic sequences.
 * Write a program that checks whether two given strings s and t are circular shifts of one another.
 * Hint : The solution is a one-liner with indexOf(), length(), and string concatenation.
 */
public class Exercise6_string_circular_rotation {
    public static void main(String[] args) {
        String s = "abc";
        String t = "cab";
        StdOut.printf("Is '%s' and '%s' are circular shift of one another? %s", s, t, isCircularRotationShift(s, t));
    }

    private static boolean isCircularRotationShift(String s, String t) {
        return (s.length() == t.length()) && ((s + s).indexOf(t) != -1);
    }
}
