package com.levik.leetcode.fib;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int n = 2;
        int expected = 1;

        int actual = new Solution().fib(n);

        assertThat(actual).isEqualTo(expected);
    }
}