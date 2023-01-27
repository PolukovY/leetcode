package com.levik.leetcode.findKthLargest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        var nums = new int[]{3,2,1,5,6,4};
        int k = 2;

        int expected = 5;

        int actual = new Solution().findKthLargest(nums, k);

        assertThat(actual).isEqualTo(expected);
    }
}