package com.levik.leetcode.coinChange;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[] coins = {1,2,5};
        int amount = 11;
        int expected = 3;

        int actual = new Solution().coinChange(coins, amount);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int[] coins = {2};
        int amount = 3;
        int expected = -1;

        int actual = new Solution().coinChange(coins, amount);

        assertThat(actual).isEqualTo(expected);
    }
}