package com.levik.leetcode.merge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        int[] expected = {1,2,2,3,5,6};

        new Solution().merge(nums1, m, nums2, n);

        assertThat(nums1).isEqualTo(expected);
    }
}