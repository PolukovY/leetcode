package com.levik.leetcode.minSubArrayLen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int expected = 2;

        int actual = new Solution().minSubArrayLen(target, nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int target = 4;
        int[] nums = {1,4,4};
        int expected = 1;

        int actual = new Solution().minSubArrayLen(target, nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        int expected = 0;

        int actual = new Solution().minSubArrayLen(target, nums);

        assertThat(actual).isEqualTo(expected);
    }
}