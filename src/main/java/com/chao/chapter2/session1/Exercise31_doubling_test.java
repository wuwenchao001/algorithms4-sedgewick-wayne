package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortCompare;
import com.chao.chapter2.session1.utils.SortType;
import edu.princeton.cs.algs4.StdOut;

public class Exercise31_doubling_test {

    private static final int MAXIMUM_INTEGER = 10000000;
    private static final int STARTING_N = 1000;

    public static double time(SortType alg, int N) {
        return SortCompare.timeRandomInput(alg, N, 1);
    }

    public static void main(String[] args) {
//        SortType alg = SortType.valueOf(args[0].toUpperCase());

//        testQuadraticInsertionAndSelection();
        testSubQuadraticShell();
    }

    private static void testSubQuadraticShell() {
        SortType alg = SortType.SHELL;
        int N = STARTING_N;
        double prevTime = time(alg, N);
        int prevN = N;

        StdOut.printf("Testing %s\n", alg);
        StdOut.printf("%7s %7s %5s %4s\n", "N", "Predict", "Time", "Ratio");
        while (N < MAXIMUM_INTEGER) {
            N *= 2;
            double currentTime = time(alg, N);
            double ratio = currentTime / (prevTime * 4); // 4 = 2^2
            double predictedTime = prevTime * (double) N / prevN * (Math.log(N) / Math.log(prevN));
            prevTime = currentTime;
            prevN = N;
            StdOut.printf("%7d %7.1f %5.1f %4.1f\n", N, predictedTime, currentTime, ratio);
        }

    }

    public static void testQuadraticInsertionAndSelection() {
        for (SortType alg : new SortType[]{SortType.INSERTION, SortType.SELECTION}) {
            int N = STARTING_N;
            double prevTime = time(alg, N);
            int prevN = N;

            StdOut.printf("Testing %s\n", alg);
            StdOut.printf("%7s %7s %5s %4s\n", "N", "Predict", "Time", "Ratio");
            while (N < MAXIMUM_INTEGER) {
                N *= 2;
                double currentTime = time(alg, N);
                double ratio = currentTime / (prevTime * 4); // 4 = 2^2
//                double predictedTime = prevTime * (double) N / prevN * (Math.log(N) / Math.log(prevN));
                double predictedTime = prevTime * (double) (N / prevN) * (N / prevN);
                prevTime = currentTime;
                prevN = N;
                StdOut.printf("%7d %7.1f %5.1f %4.1f\n", N, predictedTime, currentTime, ratio);
            }
        }
    }
}

/**
 * Testing INSERTION
 * N Predict  Time Ratio
 * 2000     0.0   0.0  0.1
 * 4000     0.0   0.0  1.2
 * 8000     0.0   0.0  0.8
 * 16000     0.1   0.2  1.0
 * 32000     0.4   1.0  1.4
 * 64000     2.1   2.8  0.7
 * 128000     5.9  18.5  1.7
 *
 * Testing SELECTION
 * N Predict  Time Ratio
 * 2000     0.0   0.0  1.3
 * 4000     0.0   0.0  0.2
 * 8000     0.0   0.0  0.7
 * 16000     0.1   0.2  1.0
 * 32000     0.4   0.7  1.0
 * 64000     1.5   2.7  1.0
 * 128000     5.8  10.9  1.0
 *
 * Testing SHELL
 *       N Predict  Time Ratio
 *    2000     0.0   0.0  0.5
 *    4000     0.0   0.0  0.3
 *    8000     0.0   0.0  0.3
 *   16000     0.0   0.0  0.4
 *   32000     0.0   0.0  0.7
 *   64000     0.0   0.0  0.3
 *  128000     0.0   0.0  1.0
 *  256000     0.1   0.1  0.6
 *  512000     0.2   0.3  0.6
 * 1024000     0.6   0.8  0.7
 * 2048000     1.6   2.2  0.7
 * 4096000     4.5   5.4  0.6
 * 8192000    11.3  13.7  0.6
 */