package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.13
 * Using the implementation of Date as a model, develop an implementation of Transaction.
 */
public class Exercise19_parsing_Transaction_Date {

    public static class Transaction {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        // Parse constructor
        public Transaction(String transaction) {
            String[] fields = transaction.split(" ");
            this.who = fields[0];
            this.when = new Date(fields[1]); // Assuming Date has a parse constructor
            this.amount = Double.parseDouble(fields[2]);
        }

        public String who() {
            return who;
        }

        public Date when() {
            return when;
        }

        public double amount() {
            return amount;
        }

        public String toString() {
            return String.format("%s made a transaction of %.2f on %s", who, amount, when.toString());
        }
    }

    public static class Date {
        private final int month;
        private final int day;
        private final int year;

        public Date(int month, int day, int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }

        // Parse constructor
        public Date(String date) {
            String[] fields = date.split("/");
            this.month = Integer.parseInt(fields[0]);
            this.day = Integer.parseInt(fields[1]);
            this.year = Integer.parseInt(fields[2]);
        }

        public int month() {
            return month;
        }

        public int day() {
            return day;
        }

        public int year() {
            return year;
        }

        public String toString() {
            return month + "/" + day + "/" + year;
        }
    }

    public static void main(String[] args) {
        Date date = new Date("5/22/1939");
        StdOut.println(date);

        Transaction transaction = new Transaction("Turing 5/22/1939 11.99");
        StdOut.println(transaction);
    }
}
