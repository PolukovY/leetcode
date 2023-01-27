package com.levik.leetcode.calculateMinimumHP;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        int[][] input = {
                {-2,-3,3},
                {-5,-10,1},{10,30,-5}
        };
        int expected = 7;

        int actual = new Solution().calculateMinimumHP(input);

        assertThat(actual).isEqualTo(expected);
    }
}