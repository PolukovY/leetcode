package com.levik.leetcode.detectCycle;

public class Solution {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode intersect = intersect(head);
        if (intersect == null) {
            return null;
        }

        ListNode current = head;
        while (current != intersect) {
            current = current.next;
            intersect = intersect.next;
        }
        return current;

    }

    public ListNode intersect(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }
}
