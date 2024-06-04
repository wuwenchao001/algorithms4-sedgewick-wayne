package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.11
 * Develop an implementation SmartDate of our Date API that raises an exception if the date is not legal.
 */
public class Exercise12_SmartDate_dayOfTheWeek {
    public static void main(String[] args) {
        SmartDate smartDate = new SmartDate(2, 29, 2024);
        StdOut.print(smartDate);
        StdOut.println("\s" + smartDate.dayOfTheWeek() + "\n");

        smartDate = new SmartDate(2, 28, 2023);
        StdOut.print(smartDate);
        StdOut.println("\s" + smartDate.dayOfTheWeek() + "\n");

        smartDate = new SmartDate(2, 29, 2023);
    }

    private static class SmartDate {
        private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        private final int month;
        private final int day;
        private final int year;

        public SmartDate(int month, int day, int year) {
            if (!isValid(month, day, year)) {
                throw new IllegalArgumentException("Invalid date");
            }
            this.month = month;
            this.day = day;
            this.year = year;
        }

        private static boolean isValid(int m, int d, int y) {
            if (m < 1 || m > 12) return false;
            if (d < 1 || d > DAYS[m]) return false;
            if (m == 2 && d == 29 && !isLeapYear(y)) return false;
            return true;
        }

        private static boolean isLeapYear(int y) {
            if (y % 400 == 0) return true;
            if (y % 100 == 0) return false;
            return y % 4 == 0;
        }

        @Override
        public String toString() {
            return new StringBuffer().append(month).append("-").append(day).append("-").append(year).toString();
        }

        public String dayOfTheWeek() {
            int m = month;
            int d = day;
            int y = year;
            if (m < 3) {
                m += 12;
                y -= 1;
            }
            int h = (0 + d + ((13*(m+1))/5) + y + y/4 - y/100 + y/400) % 7;
            switch (h) {
                case 0: return "Saturday";
                case 1: return "Sunday";
                case 2: return "Monday";
                case 3: return "Tuesday";
                case 4: return "Wednesday";
                case 5: return "Thursday";
                case 6: return "Friday";
                default: return "";  // This line will never be reached.
            }
        }
    }
}
