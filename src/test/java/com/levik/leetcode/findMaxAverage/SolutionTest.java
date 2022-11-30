package com.levik.leetcode.findMaxAverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[] nums = new int[]{1,12,-5,-6,50,3};
        int k = 4;
        double expected = 12.75000;

        double actual = new Solution().findMaxAverage(nums, k);

        assertThat(actual).isEqualTo(expected);
    }
}