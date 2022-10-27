package com.levik.leetcode.mergeTwoLists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var listNode1 = new Solution.ListNode(1);
        listNode1.next = new Solution.ListNode(2);
        listNode1.next.next = new Solution.ListNode(4);

        var listNode2 = new Solution.ListNode(1);
        listNode2.next = new Solution.ListNode(3);
        listNode2.next.next = new Solution.ListNode(4);

        var expected = new Solution.ListNode(1);
        expected.next = new Solution.ListNode(1);
        expected.next.next = new Solution.ListNode(2);
        expected.next.next.next = new Solution.ListNode(3);
        expected.next.next.next.next = new Solution.ListNode(4);
        expected.next.next.next.next.next = new Solution.ListNode(4);

        Solution.ListNode actual = new Solution().mergeTwoLists(listNode1, listNode2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        var listNode1 = new Solution.ListNode();
        var listNode2 = new Solution.ListNode();

        var expected = new Solution.ListNode();

        Solution.ListNode actual = new Solution().mergeTwoLists(listNode1, listNode2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        var listNode1 = new Solution.ListNode();
        var listNode2 = new Solution.ListNode();
        listNode2.next = new Solution.ListNode(0);

        var expected = new Solution.ListNode();
        expected.next = new Solution.ListNode(0);

        Solution.ListNode actual = new Solution().mergeTwoLists(listNode1, listNode2);

        assertThat(actual).isEqualTo(expected);
    }
}