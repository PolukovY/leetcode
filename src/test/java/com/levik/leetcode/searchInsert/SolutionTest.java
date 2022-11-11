package com.levik.leetcode.searchInsert;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {1,3,5,6};
        int target = 5;
        int expected = 2;

        int actual = new Solution().searchInsert(nums, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {1,3,5,6};
        int target = 2;
        int expected = 1;

        int actual = new Solution().searchInsert(nums, target);

        assertThat(actual).isEqualTo(expected);
    }
}