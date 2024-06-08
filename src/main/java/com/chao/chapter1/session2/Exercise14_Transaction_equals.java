package com.chao.chapter1.session2;

import com.chao.chapter1.session2.util.Date;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.14 
 * Using our implementation of equals() in Date as a model (page103),
 * develop implementations of equals() for Transaction.
 */
public class Exercise14_Transaction_equals {
    public static void main(String[] args) {
        Transaction chao1 = new Transaction("chao", new Date(2, 29, 2024), 24.0);
        Transaction chao2 = new Transaction("chao", new Date(2, 29, 2024), 24.0);
        Transaction chao3 = new Transaction("chao", new Date(2, 29, 2028), 24.0);
        StdOut.println(chao1.equals(chao2));
        StdOut.println(chao1.equals(chao3));
    }
    public static class Transaction {
        private final String who;
        private final Date when;
        private final double amount;

        public Transaction(String who, Date when, double amount) {
            this.who = who;
            this.when = when;
            this.amount = amount;
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

        public boolean equals(Object x) {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Transaction that = (Transaction) x;
            if (!this.who.equals(that.who)) return false;
            if (!this.when.equals(that.when)) return false;
            if (this.amount != that.amount) return false;
            return true;
        }
    }
}
