package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

public class Steque<T> implements Iterable<T>{
    private Node<T> first;
    private Node<T> bottom;
    private int size;

    private static class Node<T>{
        private T data;
        private Node<T> next;
    }

    public Steque() {
        this.first = null;
        this.bottom = null;
        this.size = 0;
    }

    public void push(T t) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.data = t;
        first.next = oldfirst;
        size++;
    }



    public boolean isEmpty() {
        return this.size == 0;
    }
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
