package com.levik.leetcode.findErrorNums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums =  {1,2,2,4};
        int[] expected = {2, 3};

        int[] actualNums = new Solution().findErrorNums(nums);

        assertThat(actualNums).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums =  {1,1};
        int[] expected = {1, 2};

        int[] actualNums = new Solution().findErrorNums(nums);

        assertThat(actualNums).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int[] nums =  {2,2};
        int[] expected = {2, 1};

        int[] actualNums = new Solution().findErrorNums(nums);

        assertThat(actualNums).isEqualTo(expected);
    }
}