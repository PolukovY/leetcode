package com.levik.leetcode.findMedianSortedArrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] num1 = {1,3};
        int[] num2 = {2};
        double expected = 2.000;

        double actual = new Solution().findMedianSortedArrays(num1, num2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] num1 = {1,2};
        int[] num2 = {3, 4};
        double expected = 2.500;

        double actual = new Solution().findMedianSortedArrays(num1, num2);

        assertThat(actual).isEqualTo(expected);
    }
}