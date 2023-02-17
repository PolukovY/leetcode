package com.levik.leetcode.isSameTree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        Solution.TreeNode first = new Solution.TreeNode(1);
        first.left = new Solution.TreeNode(2);
        first.right = new Solution.TreeNode(3);

        Solution.TreeNode second = new Solution.TreeNode(1);
        second.left = new Solution.TreeNode(2);
        second.right = new Solution.TreeNode(3);

        boolean expected = true;

        boolean actual = new Solution().isSameTree(first, second);

        assertThat(actual).isEqualTo(expected);
    }
}