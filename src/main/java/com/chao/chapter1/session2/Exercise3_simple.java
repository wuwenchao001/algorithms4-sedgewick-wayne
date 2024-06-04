package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.*;

public class Exercise3_simple {
    public static void main(String[] args) {

        // Set the size of the drawing canvas.
        StdDraw.setCanvasSize(800, 800);

        // Set the scale of the coordinate system.
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);

        // Set the pen radius and color.
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLUE);


        int N = 10; //Integer.parseInt(args[0]);
        double min = 1.0;  //Double.parseDouble(args[1]);
        double max = 5.0; //Double.parseDouble(args[2]);

        Interval2D[] intervals = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double width = StdRandom.uniform(min, max);
            double height = StdRandom.uniform(min, max);
            Point2D point = new Point2D(width / 2, height / 2);
            Interval1D xInterval = new Interval1D(point.x() - width / 2, point.x() + width / 2);
            Interval1D yInterval = new Interval1D(point.y() - height / 2, point.y() + height / 2);
            intervals[i] = new Interval2D(xInterval, yInterval);
            intervals[i].draw();
        }

        int intersectCount = 0, containCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (intervals[i].intersects(intervals[j])) intersectCount++;
//                if (intervals[i].contains(intervals[j]) || intervals[j].contains(intervals[i])) containCount++;
            }
        }

        StdOut.println("Number of pairs of intervals that intersect: " + intersectCount);
        StdOut.println("Number of intervals that are contained in one another: " + containCount);
    }
}
