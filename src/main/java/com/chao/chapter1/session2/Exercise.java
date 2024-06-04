package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;

public class Exercise {
    public static void main(String[] args) {
        // Page 65. Counter.
        Counter heads;
        heads = new Counter("heads");
        heads.increment();
        Counter tails = new Counter("tails");
        tails.increment();
        int headsToTails = heads.tally() - tails.tally();
        StdOut.println(heads + " " + tails + " " + headsToTails);

    }
}
