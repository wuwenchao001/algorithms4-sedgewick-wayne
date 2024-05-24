/**
 * Isn't this just a ring array, with a first and last connection?
 * Ideas for using ALGORITHM2.2 InsertionSort
 *
 * The top 2 cards are the front-runner for insertion (bubbling) sort,
 * put the sorted(smaller values, increasing array) to bottom.
 */
package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Deque;
import java.util.LinkedList;

public class Exercise14_dequeue_sort {

    public static void sort(Deque<Comparable> deck) {
        int size = deck.size();

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                Comparable top = deck.remove();
                if (top.compareTo(deck.peek()) < 0) {
                    deck.addLast(top);
                } else {
                    deck.addLast(deck.remove());
                    deck.addFirst(top);
                }
            }
            // Put the n elements of the sorted array, plus the new ones that need to be compared, to the top.
            for (int k = size - i - 1; k > 0; k--) {
                deck.addLast(deck.remove());
            }
        }
        // Minus one that need to be compared: put the largest number to the bottom of the sorted deck.
        deck.addLast(deck.remove());
    }

    public static void main(String[] args) {
        // Generate a deck
        Deque<Comparable> deck = new LinkedList<>();
        for (int i = 26; i > 0; i--) {
            deck.addLast(i);
        }
        deck.addLast(29);
        deck.addLast(31);
        deck.addLast(30);
        deck.addLast(28);
        for (int i = 32; i < 52; i++) {
            deck.addLast(i);
        }

        printDeque(deck);
        sort(deck);
        printDeque(deck);
    }

    private static void printDeque(Deque<Comparable> deck) {
        deck.forEach(StdOut::println);
        StdOut.println("-------------");
    }
}
