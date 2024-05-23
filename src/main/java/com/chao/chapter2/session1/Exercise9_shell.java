package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9_shell {
    private static void shellSort(Comparable[] a) {
        int n = a.length;
        for (int gap = n / 3; gap > 0; gap /= 3) {
            for (int i = gap; i < n; i++) {
                for (int j = i; j >= gap && a[j].compareTo(a[j - gap]) < 0; j -= gap) {
                    Comparable temp = a[j];
                    a[j] = a[j - gap];
                    a[j - gap] = temp;
                }
                // print temporary arry
                for (int i1 = 0; i1 < a.length; i1++) {
                    StdOut.print(a[i1]);
                }
                StdOut.println();
            }
        }
    }

    public static void main(String[] args) {
        Character[] a = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        // also for E A S Y S H E L L S O R T Q U E S T I O N
        shellSort(a);
    }
}
/**
 *  gap = 4, n-4 = 8 times
 *   E ASY Q UESTION
 *  E A SYQ U ESTION
 *  EA E YQU S STION
 *  EAE S QUS Y TION
 *   E AES Q USY T ION
 *  E A ESQ I SYT U ON
 *  EA E SQI O YTU S N
 *   EAE N QIO S TUS Y
 *
 *  gap = 1, n-1 = 11 times
 *  AEENQIOSTUSY
 *  AEENQIOSTUSY
 *  AEENQIOSTUSY
 *  AEENQIOSTUSY
 *  AEEINQOSTUSY
 *  AEEINOQSTUSY
 *  AEEINOQSTUSY
 *  AEEINOQSTUSY
 *  AEEINOQSTUSY
 *  AEEINOQSSTUY
 *  AEEINOQSSTUY
 */
