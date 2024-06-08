package com.chao.chapter2.session1;

import com.chao.chapter2.session1.util.SortCompare;
import com.chao.chapter2.session1.util.SortType;
import edu.princeton.cs.algs4.StdDraw;

public class Exercise32_plot_running_times {

    private static final int MAXIMUM_INTEGER = 100000;
    private static final int STARTING_N = 1000;
    private static final int TRIALS = 5;

    public static double time(SortType alg, int N) {
        return SortCompare.timeRandomInput(alg, N, 1);
    }

    public static void main(String[] args) {
//        SortType alg = SortType.valueOf(args[0].toUpperCase());
        SortType alg = SortType.SHELL;
//        int maxN = Integer.parseInt(args[1]);
        int maxN = MAXIMUM_INTEGER;

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(STARTING_N, maxN);
        StdDraw.setYscale(0, time(alg, maxN));
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);

        StdDraw.text(maxN / 2, time(alg, maxN) * 0.95, "Average Running Times for " + alg);
        StdDraw.textLeft(STARTING_N, time(alg, maxN) * 0.05, "Time");
        StdDraw.text(maxN / 2, time(alg, maxN) * 0.05, "Array Size");

//        for (int N = STARTING_N; N <= maxN; N += 100) {
//            double time = time(alg, N);
//            StdDraw.point(N, time);
//        }

        for (int N = STARTING_N; N <= maxN; N += 100) {
            double totalTime = 0;
            for (int t = 0; t < TRIALS; t++) {
                totalTime += time(alg, N);
            }
            double avgTime = totalTime / TRIALS;
            StdDraw.point(N, avgTime);
        }
    }
}
