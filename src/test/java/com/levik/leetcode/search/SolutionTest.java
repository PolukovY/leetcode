package com.levik.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int expected = 4;

        int actual = new Solution().search(nums, target);

        assertThat(actual).isEqualTo(expected);
    }
}