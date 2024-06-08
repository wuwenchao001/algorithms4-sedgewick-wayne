package com.chao.chapter1.session2;

import com.chao.chapter1.session2.util.Date;

/**
 * 1.2.13
 * Using the implementation of Date as a model, develop an implementation of Transaction.
 */
public class Exercise13_Transaction_Date {

    public class Transaction {
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
    }
}
