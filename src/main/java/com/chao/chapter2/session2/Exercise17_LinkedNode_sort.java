package com.chao.chapter2.session2;

/**
 * 2.2.17 Linked-list sort.
 * Implement a natural mergesort for linked lists.
 * (This is the method of choice for sorting linked lists
 * because it uses no extra space and is guaranteed to be linearithmic.)
 */
public class Exercise17_LinkedNode_sort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public static ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode prev = null, slow = head, fast = head;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = null;

            ListNode l1 = sortList(head);
            ListNode l2 = sortList(slow);

            return merge(l1, l2);
        }

        public static ListNode merge(ListNode l1, ListNode l2) {
            ListNode l = new ListNode(0), p = l;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }

            if (l1 != null)
                p.next = l1;

            if (l2 != null)
                p.next = l2;

            return l.next;
        }
    }

    public static void main(String[] args) {
        // Setup input list: 4 -> 2 -> 1 -> 3
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(9);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(11);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(2);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node8;
        node8.next = node6;

        // Run the sortList method
        ListNode sortedHead = ListNode.sortList(node4);

        // Check the sorted list: 1 -> 2 -> 3 -> 4
        assert 1 == sortedHead.val;
        assert 2 == sortedHead.next.val;
        assert 3 == sortedHead.next.next.val;
        assert 4 == sortedHead.next.next.next.val;
        assert 5 == sortedHead.next.next.next.next.val;
        assert 9 == sortedHead.next.next.next.next.next.val;
        assert 9 == sortedHead.next.next.next.next.next.next.val;
        assert 11 == sortedHead.next.next.next.next.next.next.next.val;
    }
}
