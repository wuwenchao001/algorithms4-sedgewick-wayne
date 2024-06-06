package com.chao.chapter1.session2;

import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;

/**
 * 1.2.17 Robust implementation of rational numbers.
 * Use assertions to develop an implementation of Rational that is immune to overflow.
 */
public class Exercise17_BigInteger_Rational_numbers {

    public static void main(String[] args) {
        Rational r1 = new Rational(252443353, -105);
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
        private final BigInteger numerator;
        private final BigInteger denominator;

        public Rational(long numerator, long denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero");
            }
            BigInteger gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator));
            this.numerator = BigInteger.valueOf(numerator).divide(gcd);
            this.denominator = BigInteger.valueOf(denominator).divide(gcd);
        }

        public Rational plus(Rational b) {
            BigInteger newNumerator = this.numerator.multiply(b.denominator).add(this.denominator.multiply(b.numerator));
            BigInteger newDenominator = this.denominator.multiply(b.denominator);
            return new Rational(newNumerator.longValue(), newDenominator.longValue());
        }

        public Rational minus(Rational b) {
            BigInteger newNumerator = this.numerator.multiply(b.denominator).subtract(this.denominator.multiply(b.numerator));
            BigInteger newDenominator = this.denominator.multiply(b.denominator);
            return new Rational(newNumerator.longValue(), newDenominator.longValue());
        }

        public Rational times(Rational b) {
            return new Rational(this.numerator.multiply(b.numerator).longValue(), this.denominator.multiply(b.denominator).longValue());
        }

        public Rational divides(Rational b) {
            return new Rational(this.numerator.multiply(b.denominator).longValue(), this.denominator.multiply(b.numerator).longValue());
        }

        public boolean equals(Rational that) {
            if (this == that) return true;
            if (that == null) return false;
            if (this.getClass() != that.getClass()) return false;
            return this.numerator.equals(that.numerator) && this.denominator.equals(that.denominator);
        }

        public String toString() {
            return numerator + "/" + denominator;
        }
    }


}