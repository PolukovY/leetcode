package com.levik.leetcode.uniquePaths;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int m = 3, n = 2;
        int expected = 3;

        int actual = new Solution().uniquePaths(m, n);

        assertThat(actual).isEqualTo(expected);
    }
}