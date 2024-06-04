/**
 * The lower bound for the average case can be proven using the concept of decision trees.
 * <p>
 * A decision tree is a binary tree that represents the comparisons between elements that are performed
 * by a sorting algorithm operating on an input of a given size.
 * In a decision tree, each internal node represents a comparison,
 * each leaf node represents an outcome (a possible ordering of the input),
 * and the path from the root to a leaf represents the sequence of comparisons made by the algorithm for that outcome.
 * <p>
 * The number of compares used by a sorting algorithm for a specific input
 * is equal to the length of the path from the root to the corresponding leaf in the decision tree.
 * Therefore, the average number of compares used by the algorithm is equal to the average length of all paths
 * from the root to the leaves, which is also known as the external path length of the tree.
 * <p>
 * Now, consider a decision tree for a compare-based sorting algorithm operating on an input of size `N`.
 * Since there are `N!` possible orderings of the input, the tree must have at least `N!` leaves.
 * The tree that minimizes the external path length for a given number of leaves is a perfectly balanced binary tree,
 * where each leaf is at the same depth.
 * However, a binary tree with `N!` leaves must have a depth of at least `lg(N!)`,
 * because a binary tree of depth `d` can have at most `2^d` leaves.
 * <p>
 * Therefore, the expected number of compares used by any compare-based sorting algorithm
 * must be at least the depth of a perfectly balanced binary tree with `N!` leaves,
 * which is `~N lg N`. This is because `lg(N!)` is approximately `N lg N` by Stirling's approximation.
 */

package com.chao.chapter2.session2;

/**
 * 2.2.13 Lower bound for average case.
 * Prove that the expected number of compares used by any compare-based sorting algorithm must be at least ~N lg N
 * (assuming that all possible orderings of the input are equally likely).
 * Hint: The expected number of compares is at least the external path length of the compare tree
 * (the sum of the lengths of the paths from the root to all leaves),
 * which is minimized when it is balanced.
 */
public class Exercise13_lower_bound_for_average_case {
    public static void main(String[] args) {
        testDepth();
    }

    public static void testDepth() {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        assert tree.depth(tree.root) == 3;
    }

    private static class Node {
        Node left, right;
        int item;

        Node(int item) {
            this.item = item;
            left = right = null;
        }
    }

    private static class BinaryTree {
        Node root;

        // Function to calculate depth of the tree
        int depth(Node node) {
            if (node == null) {
                return 0;
            } else {
                int leftDepth = depth(node.left);
                int rightDepth = depth(node.right);

                // Use the larger depth
                if (leftDepth > rightDepth)
                    return (leftDepth + 1);
                else
                    return (rightDepth + 1);
            }
        }
    }
}

