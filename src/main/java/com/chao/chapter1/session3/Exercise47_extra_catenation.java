//package com.chao.chapter1.session3;
//
//import edu.princeton.cs.algs4.Stack;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.LinkedQueue;
//import edu.princeton.cs.algs4.LinkedStack;
//
//public class Exercise47_extra_catenation {
//    // Destructively? 不知道这问的是什么，是直接String输出，还是造一些新的Stack Queue类来继承CircularLinkedList
//    // Hint: Use a circular linked list
//    public static void main(String[] args) {
//        Stack<Integer> integers1 = new Stack<>();
//        Stack<Integer> integers2 = new Stack<>();
//        for (int i = 0; i < 10; i++) {
//            integers1.push(i);
//            integers2.push(100+ i);
//        }
//
//        CircularLinkedList<Integer> circularLinkedList1 = new CircularLinkedList<Integer>();
//        CircularLinkedList<Integer> circularLinkedList2 = new CircularLinkedList<Integer>();
//        circularLinkedList1.catenation(circularLinkedList2);
//        StdOut.println(circularLinkedList1.toString());
//    }
//
//}
