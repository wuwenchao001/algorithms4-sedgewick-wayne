package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;

public class Exercise21_comparable_transactions {
    public Exercise21_comparable_transactions() {
    }

    public static void main(String[] args) {
        Date date = new Date(8, 3, 2016);
        Transaction transaction1 = new Transaction("Rene", date, 500);
        Transaction transaction2 = new Transaction("John", date, 300);
        StdOut.println(transaction1.compareTo(transaction2));
        StdOut.println("Expected: 1 (since 500 is greater than 300)");
    }

    public static class Transaction implements Comparable<Transaction> {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String who() {
            return this.who;
        }

        public Date when() {
            return this.when;
        }

        public double amount() {
            return this.amount;
        }

        public String toString() {
            return this.who() + " spent " + this.amount() + " on " + this.when();
        }

        @Override
        public int compareTo(Transaction that) {
            if (this.amount < that.amount) {
                return -1;
            } else {
                return this.amount > that.amount ? 1 : 0;
            }
        }
    }
}

