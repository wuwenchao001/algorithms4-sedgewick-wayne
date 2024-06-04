package com.chao.chapter1.session2.utils;

/**
 * Page 91 An abstract data type to encapsulate dates.
 */
public class Date {
    private final int value;

    public Date(int m, int d, int y) {
        value = y * 512 + m * 32 + d;
    }

    public int month() {
        return (value / 32) % 16;
    }

    public int day() {
        return value % 32;
    }

    public int year() {
        return value / 512;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    /**
     * Page 103.
     * Overriding equals() in a data-type definition.
     * @return boolean
     */
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Date that = (Date) x;
        if (this.day() != that.day()) return false;
        if (this.month() != that.month()) return false;
        if (this.year() != that.year()) return false;
        return true;
    }
}