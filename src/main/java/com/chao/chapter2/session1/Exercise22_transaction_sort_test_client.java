package com.chao.chapter2.session1;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import com.chao.chapter2.session1.Exercise21_comparable_transactions.Transaction;

public class Exercise22_transaction_sort_test_client {
//}
//public class SortTransactions {

    // Read transactions from standard input
    public static Transaction[] readTransactions() {
        int count = StdIn.readInt();
        Transaction[] transactions = new Transaction[count];

        for (int i = 0; i < count; i++) {
            String who = StdIn.readString();
            int month = StdIn.readInt();
            int day = StdIn.readInt();
            int year = StdIn.readInt();
            double amount = StdIn.readDouble();

            transactions[i] = new Transaction(who, new Date(month, day, year), amount);
        }

        return transactions;
    }

    public static void main(String[] args) {
        // Generate 10 transactions for testing
        Transaction[] transactions = generateTransactions();

        // Sort transactions
        Shell.sort(transactions);

        // Print sorted transactions
        for (Transaction transaction : transactions) {
            StdOut.println(transaction);
        }
    }

    // Generate 10 test transactions
    public static Transaction[] generateTransactions() {
        Transaction[] transactions = new Transaction[10];
        transactions[0] = new Transaction("Alice", new Date(1, 1, 2022), 100.0);
        transactions[1] = new Transaction("Bob", new Date(2, 2, 2022), 200.0);
        transactions[2] = new Transaction("Charlie", new Date(3, 3, 2022), 300.0);
        transactions[3] = new Transaction("David", new Date(4, 4, 2022), 400.0);
        transactions[4] = new Transaction("Eve", new Date(5, 5, 2022), 500.0);
        transactions[5] = new Transaction("Frank", new Date(6, 6, 2022), 600.0);
        transactions[6] = new Transaction("Grace", new Date(7, 7, 2022), 700.0);
        transactions[7] = new Transaction("Hannah", new Date(8, 8, 2022), 800.0);
        transactions[8] = new Transaction("Isaac", new Date(9, 9, 2022), 900.0);
        transactions[9] = new Transaction("Jack", new Date(10, 10, 2022), 1000.0);
        return transactions;
    }
}

