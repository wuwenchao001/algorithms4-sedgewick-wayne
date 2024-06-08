package com.chao.chapter2.session2;

import java.util.Arrays;

/**
 * 2.2.21 Triplicates.
 * Given three lists of N names each,
 * devise a linearithmic algorithm to determine if there is any name common to all three lists, and if so,
 * return the first such name.
 */
public class Exercise21_triplicates {

        public static String findCommonName(String[] list1, String[] list2, String[] list3) {
            Arrays.sort(list1);
            Arrays.sort(list2);
            Arrays.sort(list3);

            int i = 0, j = 0, k = 0;

            while (i < list1.length && j < list2.length && k < list3.length) {
                int compare12 = list1[i].compareTo(list2[j]);
                int compare23 = list2[j].compareTo(list3[k]);

                if (compare12 == 0 && compare23 == 0) {
                    return list1[i];
                } else if (compare12 <= 0 && compare23 <= 0) {
                    i++;
                } else if (compare12 >= 0 && compare23 <= 0) {
                    j++;
                } else {
                    k++;
                }
            }

            return null;
        }

        public static void main(String[] args) {
            String[] list1 = {"Alice", "Bob", "Charlie", "Dave"};
            String[] list2 = {"Bob", "Charlie", "Dave", "Eve"};
            String[] list3 = {"Charlie", "Dave", "Eve", "Frank"};

            String commonName = findCommonName(list1, list2, list3);

            if (commonName != null) {
                System.out.println("Common name: " + commonName);
            } else {
                System.out.println("No common name found.");
            }
        }
    }
