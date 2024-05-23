/**
 * Just put the smaller of the two cards on the bottom and do it consistently
 */
package com.chao.chapter2.session1;

import java.util.Deque;
import java.util.LinkedList;

public class Exercise14_dequeue_sort {

    public static void sort(Deque<Integer> deck) {
        int size = deck.size();
        while (size > 0) {
            int maxIndex = 0;
            for (int i = 0; i < size; i++) {
                int top = deck.remove();
                if (top > deck.peek()) {
                    deck.addFirst(deck.remove());
                    deck.addFirst(top);
                    maxIndex = i + 1;
                } else {
                    deck.addLast(top);
                }
            }
            for (int i = 0; i < size - maxIndex; i++) {
                deck.addLast(deck.remove());
            }
            size--;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deck = new LinkedList<>();
        deck.addLast(3);
        deck.addLast(1);
        deck.addLast(4);
        deck.addLast(1);
        deck.addLast(5);
        deck.addLast(9);
        sort(deck);
        while (!deck.isEmpty()) {
            System.out.println(deck.remove());
        }
    }
}
