//package com.chao.chapter1.session3;
//
//import edu.princeton.cs.algs4.Stack;
//
//import java.util.Collection;
//import java.util.Iterator;
//import java.util.ListIterator;
//
//public class CircularLinkedList<T> implements Iterable<T> {
//    private Node<T> first;     // top of stack
//    private Node<T> last;
//    private int n;                // size of the stack
//
//    public CircularLinkedList() {
//        first = null;
//        last = null;
//        n = 0;
//    }
//
//    @Override
//    public Iterator<T> iterator() {
//        return new ListIterator<T>() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public T next() {
//                return null;
//            }
//
//            @Override
//            public boolean hasPrevious() {
//                return false;
//            }
//
//            @Override
//            public T previous() {
//                return null;
//            }
//
//            @Override
//            public int nextIndex() {
//                return 0;
//            }
//
//            @Override
//            public int previousIndex() {
//                return 0;
//            }
//
//            @Override
//            public void remove() {
//
//            }
//
//            @Override
//            public void set(T t) {
//
//            }
//
//            @Override
//            public void add(T t) {
//
//            }
//        };
//    }
//}
//
//    public CircularLinkedList(Stack<T> stack) {
//        while (!stack.isEmpty()) {
//            fist.t = stack.pop();
//            last.next = first;
//            first = first.next;
//        }
//        first = null;
//    }
//
//    public void catenation(CircularLinkedList<> circularLinkedList) {
//        return;
//
//    }
//
//    public void add(T t) {
//        Node<T> oldfirst = first;
//        first = new Node<T>();
//        first.t = t;
//        first.next = oldfirst;
//        n++;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        while (first != last.next) {
//            sb.append(first.t);
//        }
//        String s = sb.toString();
//        return s;
//    }
//
//    private static class Node<T> {
//        private T t;
//        private Node<T> next;
//    }
