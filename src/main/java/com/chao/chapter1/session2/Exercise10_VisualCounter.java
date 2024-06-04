package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import static java.lang.Thread.sleep;

/**
 * 1.2.10 Develop a class VisualCounter that allows both increment and decrement operations.
 * Take two arguments N and max in the constructor,
 * where N specifies the maximum number of operations
 * and max specifies the maximum absolute value for the counter.
 * As a side effect, create a plot showing the value of the counter each time its tally change
 */
public class Exercise10_VisualCounter {
    public static void main(String[] args) throws InterruptedException {
        VisualCounter vc = new VisualCounter(100, 30);
        for (int i = 0; i < 20; i++) {  // set counter -> 20, close to max:30
            vc.increment();
        }
        for (int i = 0; i < 100; i++) {
            if (StdRandom.uniform(10) <= 5) {
                vc.increment();
            } else {
                vc.decrement();
            }
            sleep(20);
        }
    }

    public static class VisualCounter {
        final private int N;
        final private int max;
        private int counter = 0;
        private int ops = 0;

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = max;
            StdDraw.setXscale(0, N * 2);
            StdDraw.setYscale(0, N);
            StdDraw.setPenRadius(.005);
            StdDraw.line(0, max, N, max);
            StdDraw.line(N, 0, N, max);
            StdDraw.text(N, max, "(N:100, max:30)", 45);
        }

        public void increment() {
            if (ops < N && counter < max) {
                counter++;
                ops++;
                StdDraw.point(ops, counter);
            }
        }

        public void decrement() {
            if (ops < N && counter > -max) { // maximum ops < N, minimum counter > -max
                counter--;
                ops++;
                StdDraw.point(ops, counter);
            }
        }
    }
}
