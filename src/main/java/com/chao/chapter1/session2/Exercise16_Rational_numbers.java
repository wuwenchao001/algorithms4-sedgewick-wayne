package com.chao.chapter1.session2;

/**
 * 1.2.16 Rational numbers.
 * Implement an immutable data type Rational for rational numbers
 * that supports addition, subtraction, multiplication, and division.
 */
public class Exercise16_Rational_numbers {

    public static void main(String[] args) {
        Rational r1 = new Rational(25, -105);
        Rational r2 = new Rational(20, 30);
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r1 + r2: " + r1.plus(r2));
        System.out.println("r1 - r2: " + r1.minus(r2));
        System.out.println("r1 * r2: " + r1.times(r2));
        System.out.println("r1 / r2: " + r1.divides(r2));
        System.out.println("r1 equals r2: " + r1.equals(r2));
    }

    public static class Rational {
        private final long numerator;

        private final long denominator;

        public Rational(long numerator, long denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero");
            }
            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        private static long gcd(long a, long b) { // If |a| < |b|, a <=> b.
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public Rational plus(Rational b) {
            long newNumerator = this.numerator * b.denominator + this.denominator * b.numerator;
            long newDenominator = this.denominator * b.denominator;
            return new Rational(newNumerator, newDenominator);
        }

        public Rational minus(Rational b) {
            long newNumerator = this.numerator * b.denominator - this.denominator * b.numerator;
            long newDenominator = this.denominator * b.denominator;
            return new Rational(newNumerator, newDenominator);
        }

        public Rational times(Rational b) {
            return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
        }

        public Rational divides(Rational b) {
            return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
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
