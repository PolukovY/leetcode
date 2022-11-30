package com.levik.leetcode.countNegatives;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testCase1() {
        int[][] grid = {
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };

        int expected = 8;

        int actual = new Solution().countNegatives2(grid);

        assertThat(actual).isEqualTo(expected);
    }
}