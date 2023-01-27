package com.levik.leetcode.removeDuplicates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {


    @Test
    void testCase1() {
        int[] nums = {1, 1, 2};
        int expected = 2;

        int actual = new Solution().removeDuplicates(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int expected = 5;

        int actual = new Solution().removeDuplicates(nums);

        assertThat(actual).isEqualTo(expected);
    }
}