package com.levik.leetcode.maxProfit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 5;

        int actual = new Solution().maxProfit(prices);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] prices = {7,6,4,3,1};
        int expected = 0;

        int actual = new Solution().maxProfit(prices);

        assertThat(actual).isEqualTo(expected);
    }
}