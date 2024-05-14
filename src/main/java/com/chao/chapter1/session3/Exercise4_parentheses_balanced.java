package com.chao.chapter1.session3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4_parentheses_balanced {
    public static void main(String[] args) {
        // Due to avoid using static modifier for all method, use new Class since 1.3.4.
        // But, is it meaningful when use instance method to test an outside String? No.
        // So, just use static modifier for method algorithms, use public modifier for class algorithms.
//        Exercise4_ParenthesesBalanced exercise = new Exercise4_ParenthesesBalanced();

        StdOut.println("Check '{1{2[221(3)]}}', expected true: " + isBalanced("{1{2[221(3)]}}"));
        StdOut.println("Check '{[(9}]}', expected false: " + isBalanced("{[(9}]}"));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<' || c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            } else if (c == '>' && stack.peek() == '<'
                    || c == ')' && stack.peek() == '('
                    || c == '}' && stack.peek() == '{'
                    || c == ']' && stack.peek() == '[') {
                // Should check the isEmpty before stack.peek? Yes to real engineering
                stack.pop();
                continue;
            } else {
                continue;
            }
        }
        return stack.isEmpty();
    }
}
