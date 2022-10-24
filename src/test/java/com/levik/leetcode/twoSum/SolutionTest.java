package com.levik.leetcode.twoSum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {1,0};

        int[] actual = new Solution().twoSum(nums, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] expected = {2,1};

        int[] actual = new Solution().twoSum(nums, target);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] nums = {3,3};
        int target = 6;
        int[] expected = {1,0};

        int[] actual = new Solution().twoSum(nums, target);

        assertThat(actual).isEqualTo(expected);
    }
}