package com.levik.leetcode.arrangeCoins;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int n = 5;
        int expected = 2;

        int actual = new Solution().arrangeCoins(n);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase2() {
        int n = 8;
        int expected = 3;

        int actual = new Solution().arrangeCoins(n);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testCase3() {
        int n = 1;
        int expected = 1;

        int actual = new Solution().arrangeCoins(n);

        assertThat(actual).isEqualTo(expected);
    }
}