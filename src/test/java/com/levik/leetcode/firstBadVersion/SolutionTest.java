package com.levik.leetcode.firstBadVersion;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int n = 5;
        int expected = 4;

        int actual = new Solution().firstBadVersion(n);

        assertThat(actual).isEqualTo(expected);
    }
}