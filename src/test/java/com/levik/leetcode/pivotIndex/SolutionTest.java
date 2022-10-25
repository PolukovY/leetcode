package com.levik.leetcode.pivotIndex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {1,7,3,6,5,6};
        int expected = 3;

        int actual = new Solution().pivotIndex(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {1,2,3};
        int expected = -1;

        int actual = new Solution().pivotIndex(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] nums = {2,1,-1};
        int expected = 0;

        int actual = new Solution().pivotIndex(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase4() {
        int[] nums = {-1,-1,-1,-1,-1,0};
        int expected = 2;

        int actual = new Solution().pivotIndex(nums);

        assertThat(actual).isEqualTo(expected);
    }
}