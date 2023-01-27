package com.levik.leetcode.findPeakElement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = {1,2,3,1};
        int expected = 2;

        int actual = new Solution().findPeakElement(nums);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] nums = {1,2,1,3,5,6,4};
        int expected = 5;

        int actual = new Solution().findPeakElement(nums);

        assertThat(actual).isEqualTo(expected);
    }
}