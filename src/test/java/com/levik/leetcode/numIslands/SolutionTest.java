package com.levik.leetcode.numIslands;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void testCase1() {
        char[][] grid =  {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;

        int actual = new Solution().numIslands(grid);

        assertThat(actual).isEqualTo(expected);
    }
}