package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

/**
 * 1.2.17 Robust implementation of rational numbers.
 * Use assertions to develop an implementation of Rational that is immune to overflow.
 */
public class Exercise17_robust_Rational_numbers {

    public static void main(String[] args) {
        Rational r1 = new Rational(224523325, -2024313235);
        Rational r2 = new Rational(20, 30);
        StdOut.println("r1: " + r1);
        StdOut.println("r2: " + r2);
        StdOut.println("r1 + r2: " + r1.plus(r2));
        StdOut.println("r1 - r2: " + r1.minus(r2));
        StdOut.println("r1 * r2: " + r1.times(r2));
        StdOut.println("r1 / r2: " + r1.divides(r2));
        StdOut.println("r1 equals r2: " + r1.equals(r2));
    }

    public static class Rational {
        private final long numerator;
        private final long denominator;

        public Rational(long numerator, long denominator) {
            assert denominator != 0 : "Denominator cannot be zero";
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            assert this.numerator <= Long.MAX_VALUE && this.numerator >= Long.MIN_VALUE : "Numerator overflow";
            assert this.denominator <= Long.MAX_VALUE && this.denominator >= Long.MIN_VALUE : "Denominator overflow";
        }

        private static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public Rational plus(Rational b) {
            long newNumerator = this.numerator * b.denominator + this.denominator * b.numerator;
            long newDenominator = this.denominator * b.denominator;
            assert newNumerator <= Long.MAX_VALUE && newNumerator >= Long.MIN_VALUE : "Numerator overflow in plus operation";
            assert newDenominator <= Long.MAX_VALUE && newDenominator >= Long.MIN_VALUE : "Denominator overflow in plus operation";
            return new Rational(newNumerator, newDenominator);
        }

        public Rational minus(Rational b) {
            long newNumerator = this.numerator * b.denominator - this.denominator * b.numerator;
            long newDenominator = this.denominator * b.denominator;
            assert newNumerator <= Long.MAX_VALUE && newNumerator >= Long.MIN_VALUE : "Numerator overflow in minus operation";
            assert newDenominator <= Long.MAX_VALUE && newDenominator >= Long.MIN_VALUE : "Denominator overflow in minus operation";
            return new Rational(newNumerator, newDenominator);
        }

        public Rational times(Rational b) {
            long newNumerator = this.numerator * b.numerator;
            long newDenominator = this.denominator * b.denominator;
            assert newNumerator <= Long.MAX_VALUE && newNumerator >= Long.MIN_VALUE : "Numerator overflow in times operation";
            assert newDenominator <= Long.MAX_VALUE && newDenominator >= Long.MIN_VALUE : "Denominator overflow in times operation";
            return new Rational(newNumerator, newDenominator);
        }

        public Rational divides(Rational b) {
            long newNumerator = this.numerator * b.denominator;
            long newDenominator = this.denominator * b.numerator;
            assert newNumerator <= Long.MAX_VALUE && newNumerator >= Long.MIN_VALUE : "Numerator overflow in divides operation";
            assert newDenominator <= Long.MAX_VALUE && newDenominator >= Long.MIN_VALUE : "Denominator overflow in divides operation";
            return new Rational(newNumerator, newDenominator);
        }

        public boolean equals(Rational that) {
            if (this == that) return true;
            if (that == null) return false;
            if (this.getClass() != that.getClass()) return false;
            return this.numerator == that.numerator && this.denominator == that.denominator;
        }

        public String toString() {
            return numerator + "/" + denominator;
        }
    }
}