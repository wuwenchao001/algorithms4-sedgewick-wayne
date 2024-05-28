/**
 * javac -classpath .:lib/algs4.jar:src/main/java src/main/java/com/chao/chapter2/session1/Exercise33_distribution.java
 * java -classpath .:lib/algs4.jar:src/main/java com.chao.chapter2.session1.Exercise33_distribution selection 1000 500
 */
package com.chao.chapter2.session1;

import com.chao.chapter2.session1.utils.SortCompare;
import com.chao.chapter2.session1.utils.SortType;
import edu.princeton.cs.algs4.*;

public class Exercise33_distribution {

    private static final int MAXIMUM_INTEGER = 1000000;

    public static double time(SortType alg, int N) {
        return SortCompare.timeRandomInput(alg, N, 1);
    }

    public static void main(String[] args) {
        SortType alg = SortType.valueOf(args[0].toUpperCase());
        int maxN = Integer.parseInt(args[1]);
        int arraySize = Integer.parseInt(args[2]);

        StdDraw.setCanvasSize(800, 800);
//        StdDraw.setXscale(0, maxN);
//        StdDraw.setYscale(0, time(alg, maxN));
        StdDraw.setXscale(-maxN * 0.1, maxN * 1.1);
        StdDraw.setYscale(-time(alg, maxN) * 0.1, time(alg, maxN) * 1.1);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);

        // Draw the horizontal and vertical axes
        StdDraw.line(0, 0, maxN, 0); // x-axis
        StdDraw.line(0, 0, 0, time(alg, maxN)); // y-axis
        // Label the axes
        StdDraw.text(maxN / 2, -time(alg, maxN) * 0.08, "Trial");
        StdDraw.text(-maxN * 0.08, time(alg, maxN) / 2, "Time", 90);
//        StdDraw.text(maxN / 2, time(alg, maxN) * 0.95, "Distribution of Running Times for " + alg);
//        StdDraw.textLeft(0, time(alg, maxN) * 0.05, "Time");
//        StdDraw.text(maxN / 2, time(alg, maxN) * 0.05, "Trial");
//        StdDraw.text(-maxN * 0.05, time(alg, maxN) / 2, "Time", 90);

        int trial = 0;
        while (true) {
            double time = time(alg, arraySize);
            StdDraw.point(trial, time);
            trial++;
        }
    }
}
