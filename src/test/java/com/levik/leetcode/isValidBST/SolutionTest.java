package com.levik.leetcode.isValidBST;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        Solution.TreeNode root = new Solution.TreeNode(2);
        root.left = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(3);

        boolean expected = true;

        boolean actual = new Solution().isValidBST(root);

        assertThat(actual).isEqualTo(expected);
    }
}