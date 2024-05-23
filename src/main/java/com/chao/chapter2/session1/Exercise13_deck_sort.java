/**
 * Deck sort.
 * Represent each card as an integer from 0 to 51,
 * where the suit is determined by the card number divided by 13 (0 = spades, 1 = hearts, 2 = clubs, 3 = diamonds)
 * and the rank is determined by the card number modulo 13 (0 = Ace, 1 = 2, ..., 12 = King).
 * 52 for the little joker, 53 for the big joker.
 *
 * Next, feel free to use any kind of sorting from this section.
 * For simplicity, ignore 52 53 here.
 *
 * SelectionSort
 */
package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;
//
// importing static members (methods or variables) of a class,
// so that you can use them in your code without prefixing them with the class name
//
// static
//
import static edu.princeton.cs.algs4.StdRandom.shuffle;

public class Exercise13_deck_sort {
    public static void sort(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < deck.length; j++) {
                if (compare(deck[j], deck[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(deck, i, minIndex);
        }
    }

    private static int compare(int card1, int card2) {
        int suit1 = card1 / 13, suit2 = card2 / 13;
        if (suit1 != suit2) {
            return suit2 - suit1;
        } else {
            int rank1 = card1 % 13, rank2 = card2 % 13;
            return rank1 - rank2;
        }
    }

    private static void swap(int[] deck, int i, int j) {
        int temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }

    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
        shuffleDeck(deck);
        sort(deck);
        show(deck);
    }

    private static void shuffleDeck(int[] deck) {
//        java.util.Collections.shuffle(java.util.Arrays.asList(deck));
        shuffle(deck);
        show(deck);
    }

    private static void show(int[] deck) {
        for (int i = 0; i < deck.length; i++) {
            StdOut.print(deck[i] + " ");
            if (i % 13 == 12) {
                StdOut.println();
            }
        }
        StdOut.println();
    }

}
