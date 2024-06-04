package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise7_reverse_recursive {

    public static void main(String[] args) {
        String s = "abc";
        StdOut.println(mystery(s));
        StdOut.println("Expected: cba");
    }

    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }
}
