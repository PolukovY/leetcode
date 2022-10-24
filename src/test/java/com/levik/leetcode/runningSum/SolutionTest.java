package com.levik.leetcode.runningSum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {1,2,3,4};
        int[] expected = {1,3,6,10};

        int[] actual = new Solution().runningSum(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {1,1,1,1,1};
        int[] expected = {1,2,3,4,5};

        int[] actual = new Solution().runningSum(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] nums = {3,1,2,10,1};
        int[] expected = {3,4,6,16,17};

        int[] actual = new Solution().runningSum(nums);

        assertThat(actual).isEqualTo(expected);
    }
}