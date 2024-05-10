package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.*;

public class Exercise3 {
    public static void main(String[] args) {
        StdOut.printf("Input the arguments N, min, and max and generates " +
                "N random 2D intervals whose width and height are uniformly " +
                "distributed between min and max: ");
        String readString = StdIn.readLine();
        String[] strings = readString.split("/");
        int n = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[1]);
        int max = Integer.parseInt(strings[2]);

        Interval2D[] interval2DS = new Interval2D[n];
        Point2D[][] point2DSS = new Point2D[n][2];

        for (int i = 0; i < n; i++) {
            int pointX1 = StdRandom.uniform(min, max);
            int pointX2 = StdRandom.uniform(min, max);
            if (pointX1 > pointX2) {
                pointX1 = pointX1 - pointX2;
                pointX2 = pointX1 + pointX2;
                pointX1 = -(pointX1 - pointX2);
            }

            int pointY1 = StdRandom.uniform(min, max);
            int pointY2 = StdRandom.uniform(min, max);
            if (pointY1 > pointY2) {
                pointY1 = pointY1 - pointY2;
                pointY2 = pointY1 + pointY2;
                pointY1 = -(pointY1 - pointX2);
            }

            Interval1D interval1DX = new Interval1D(pointX1, pointX2);
            Interval1D interval1DY = new Interval1D(pointY1, pointY2);
            // TODO: Somehow, line 37 occasionally goes wrong

            interval2DS[i] = new Interval2D(interval1DX, interval1DY);

            // Because lines and points in the interval2D class are private, we save them when we create them
            // These two points are the two on the diagonal of the rectangle interval2DS[i]
            point2DSS[i][0] = new Point2D(pointX1, pointY1);
            point2DSS[i][1] = new Point2D(pointX2, pointY2);
        }

        int countIntersectNum = countIntersect(interval2DS);
        StdOut.printf("Intersect interval2D numbers: %s \n", countIntersectNum);

        int countContainedNum = countContained(interval2DS, point2DSS);
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
