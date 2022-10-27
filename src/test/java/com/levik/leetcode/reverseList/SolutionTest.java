package com.levik.leetcode.reverseList;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        Solution.ListNode head = new Solution.ListNode(1);
        head.next = new Solution.ListNode(2);
        head.next.next = new Solution.ListNode(3);
        head.next.next.next = new Solution.ListNode(4);
        head.next.next.next.next = new Solution.ListNode(5);

        Solution.ListNode expected = new Solution.ListNode(5);
        head.next = new Solution.ListNode(4);
        head.next.next = new Solution.ListNode(3);
        head.next.next.next = new Solution.ListNode(2);
        head.next.next.next.next = new Solution.ListNode(1);

        Solution.ListNode actual = new Solution().reverseList(head);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        Solution.ListNode head = new Solution.ListNode(1);
        head.next = new Solution.ListNode(2);

        Solution.ListNode expected = new Solution.ListNode(2);
        head.next = new Solution.ListNode(1);

        Solution.ListNode actual = new Solution().reverseList(head);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        Solution.ListNode head = new Solution.ListNode();

        Solution.ListNode expected = new Solution.ListNode();

        Solution.ListNode actual = new Solution().reverseList(head);

        assertThat(actual).isEqualTo(expected);
    }
}