package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.*;

/**
 *  1.2.3
 *  Write an Interval2D client that takes command-line arguments N, min,and max
 *  and generates N random 2D intervals
 *  whose width and height are uniformly distributed between min and max in the unit square.
 *  Draw them on StdDraw
 *  and print the number of pairs of intervals that intersect
 *  and the number of intervals that are contained in one another.
 */
public class Exercise3_Interval2D {
    public static void main(String[] args) {
        numbersAndDraw();
    }

    public static void numbersAndDraw() {
        StdOut.printf("Input the arguments N, min, and max and generates " +
                "N random 2D intervals whose width and height are uniformly " +
                "distributed between min and max. \nN min max:\n");
        String readString = StdIn.readLine(); //10 1.1 11.11
        String[] strings = readString.split("\\s");
        int n = Integer.parseInt(strings[0]);
        Double min = Double.parseDouble(strings[1]);
        Double max = Double.parseDouble(strings[2]);

        StdDraw.setCanvasSize(512, 512);
        StdDraw.setPenRadius(0.001);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.setPenColor(StdDraw.BLUE);

        Interval2D[] interval2DS = new Interval2D[n];
        Point2D[][] point2DS = new Point2D[n][2];

        for (int i = 0; i < n; i++) {
            double x1 = StdRandom.uniform(min, max);
            double x2 = StdRandom.uniform(min, max);
            if (x1 > x2) {
                double temp = x1;
                x1 = x2;
                x2 = temp;
                //not stable
//                x1 = x1 - x2;
//                x2 = x1 + x2;
//                x1 = -(x1 - x2);
            }
            double y1 = StdRandom.uniform(min, max);
            double y2 = StdRandom.uniform(min, max);
            if (y1 > y2) {
                double y = y1;
                y1 = y2;
                y2 = y;
            }

            Interval1D interval1DX = new Interval1D(x1, x2);
            Interval1D interval1DY = new Interval1D(y1, y2); //

            interval2DS[i] = new Interval2D(interval1DX, interval1DY);
            interval2DS[i].draw();

            // save the diagonal of the rectangle interval2DS[i] in point2DS
            point2DS[i][0] = new Point2D(x1, y1);
            point2DS[i][1] = new Point2D(x2, y2);
        }

        int countIntersectNum = countIntersect(interval2DS);
        StdOut.printf("Intersect interval2D numbers: %s \n", countIntersectNum);

        int countContainedNum = countContained(interval2DS, point2DS);
        StdOut.printf("Contained interval2D numbers: %s", countContainedNum);
    }

    private static int countIntersect(Interval2D[] interval2DS) {
        int count = 0;
        for (int i = 0; i < interval2DS.length; i++) {
            for (int j = i + 1; j < interval2DS.length; j++) {
                if (interval2DS[i].intersects(interval2DS[j])) count++;
            }
        }
        return count;
    }

    private static int countContained(Interval2D[] interval2Ds, Point2D[][] point2DSS) {
        int count = 0;
//        // cannot access the x and y
//        for (int i = 0; i < interval2DS.length; i++) {
//            for (int j = 0; j < interval2DS.length; j++) {
//                if (interval2DS[i].contains(interval2DS[j].x.max) &&
//                        interval2DS[i].contains(interval2DS[j].y.max) &&
//                        interval2DS[i].contains(interval2DS[j].x.min) &&
//                        interval2DS[i].contains(interval2DS[j].x.min)) count++;
//            }
//        }
        for (int i = 0; i < interval2Ds.length; i++) {
            for (int j = i + 1; j < interval2Ds.length; j++) {
                if ( interval2Ds[i].contains(point2DSS[j][0]) && interval2Ds[i].contains(point2DSS[j][1])
                        || interval2Ds[j].contains(point2DSS[i][0]) && interval2Ds[j].contains(point2DSS[i][1])
                ) count++;
            }

        }
        return count;
    }
}
